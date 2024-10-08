package com.ruoyi.framework.web.service;

import com.ruoyi.agent.service.ITblAgentInfoService;
import com.ruoyi.coin.service.ITblColdCoinAddressService;
import com.ruoyi.coin.service.impl.SafeHeronUtils;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.user.domain.TblUserInfo;
import com.ruoyi.user.service.ITblUserInfoService;
import com.safeheron.client.config.SafeheronConfig;
import com.safeheron.client.response.CreateAccountResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.RegisterBody;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.exception.user.CaptchaException;
import com.ruoyi.common.exception.user.CaptchaExpireException;
import com.ruoyi.common.utils.MessageUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.manager.AsyncManager;
import com.ruoyi.framework.manager.factory.AsyncFactory;
import com.ruoyi.system.service.ISysConfigService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * 注册校验方法
 * 
 * @author ruoyi
 */
@Component
@Slf4j
public class SysRegisterService
{
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private RedisCache redisCache;
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    private TransactionDefinition transactionDefinition;

    @Autowired
    private ITblUserInfoService tblUserInfoService;

    @Autowired
    private ITblAgentInfoService agentInfoService;


    @Resource(name = "safeheronConfig")
    private SafeheronConfig safeheronConfig;

    @Value("${support.coinList}")
    private List<String> coinList;


    /**
     * 注册
     */
    public String register(RegisterBody registerBody)
    {
        String msg = "", username = registerBody.getEmail(), password = registerBody.getPass();
        SysUser sysUser = new SysUser();
        sysUser.setUserName(username);

        // 验证码开关
        boolean captchaEnabled = configService.selectCaptchaEnabled();
        if (captchaEnabled)
        {
            validateCaptcha(username, registerBody.getValidCode(), registerBody.getUuid());
        }

        // 验证邮箱
        validateCaptcha(username, registerBody.getCode(), registerBody.getMailUuid());

        if (StringUtils.isEmpty(username))
        {
            msg = "用户名不能为空";
        }
        else if (StringUtils.isEmpty(password))
        {
            msg = "用户密码不能为空";
        }
        else if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH)
        {
            msg = "账户长度必须在2到20个字符之间";
        }
        else if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH)
        {
            msg = "密码长度必须在5到20个字符之间";
        }
        else if (StringUtils.isEmpty(registerBody.getReCode()))
        {
            msg = "用户推荐不能为空";
        }
        else if (!userService.checkUserNameUnique(sysUser))
        {
            msg = "保存用户'" + username + "'失败，注册账号已存在";
        }
        else
        {
            sysUser.setUserName(username);
            sysUser.setEmail(username);
            sysUser.setPassword(SecurityUtils.encryptPassword(password));
            boolean regFlag = false;
            TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
            try {

                regFlag = userService.registerUser(sysUser);

//                CreateAccountResponse accountAndAddCoin = SafeHeronUtils.createAccountAndAddCoin(safeheronConfig,
//                        username.substring(0,username.indexOf("@") + 1) + sysUser.getUserId(), true, coinList);
                TblUserInfo userInfo = new TblUserInfo();
                userInfo.setUserId(sysUser.getUserId());
                userInfo.setBalance(new BigDecimal(0));
                userInfo.setBalanceFroze(new BigDecimal(0));
                userInfo.setBalanceUsdt(new BigDecimal(0));
                userInfo.setBalanceGbp(new BigDecimal(0));
                userInfo.setBalanceEur(new BigDecimal(0));
                userInfo.setEmail(username);
//                userInfo.setTronAddr(accountAndAddCoin.getAccountKey());
                if(StringUtils.isNotBlank(sysUser.getInviteUri()) && sysUser.getInviteUri().startsWith("A")) {
                    Optional.ofNullable(agentInfoService.selectTblAgentInfoByInviteUri(sysUser.getInviteUri()))
                            .map(info -> {
                                userInfo.setAiId(info.getAiId());
                                return info;
                            })
                            .orElseGet(() -> {
                                // 如果 agentInfo 为 null，是否需要做其他操作
                                return null;
                            });
                }else if(StringUtils.isNotBlank(sysUser.getInviteUri()) && sysUser.getInviteUri().startsWith("U")) {
                    Optional.ofNullable(tblUserInfoService.selectTblUserInfoByInviteUri(sysUser.getInviteUri()))
                            .map(info -> {
                                userInfo.setInviteUiId(info.getUiId());
                                return info;
                            })
                            .orElseGet(() -> {
                                // 如果 agentInfo 为 null，是否需要做其他操作
                                return null;
                            });
                }
                String random = RandomStringUtils.random(4, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray());
                int length = (sysUser.getUserId() + "").length();
                userInfo.setInviteUri("U"+StringUtils.leftPad(sysUser.getUserId()+"", 5, random.substring(length-1)));
                tblUserInfoService.insertTblUserInfo(userInfo);
                dataSourceTransactionManager.commit(transactionStatus); // 手动提交
            } catch (Exception e) {
                dataSourceTransactionManager.rollback(transactionStatus);
                log.error("注册失败",e);
                throw new ServiceException("注册失败,请联系系统管理人员");
            }

            if (!regFlag)
            {
                msg = "注册失败,请联系系统管理人员";
            }
            else
            {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.REGISTER, MessageUtils.message("user.register.success")));
            }
        }
        return msg;
    }

    /**
     * 校验验证码
     * 
     * @param username 用户名
     * @param code 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    public void validateCaptcha(String username, String code, String uuid)
    {
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null)
        {
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha))
        {
            throw new CaptchaException();
        }
    }
}
