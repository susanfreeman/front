package com.ruoyi.web.controller.custom;

import com.google.code.kaptcha.Producer;
import com.ruoyi.coin.service.impl.SafeHeronUtils;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SendGroupMsgTg;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.generator.util.VelocityInitializer;
import com.ruoyi.mail.service.IEmailService;
import com.ruoyi.system.domain.TblCardBinInfo;
import com.ruoyi.system.service.ITblCardBinInfoService;
import com.ruoyi.user.domain.TblUserInfo;
import com.ruoyi.user.service.ITblUserInfoService;
import com.safeheron.client.config.SafeheronConfig;
import com.safeheron.client.response.AccountCoinResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.ruoyi.common.core.domain.AjaxResult.error;
import static com.ruoyi.common.core.domain.AjaxResult.success;
import static com.ruoyi.common.utils.SecurityUtils.getLoginUser;
import static com.ruoyi.common.utils.SecurityUtils.getUserId;

@Slf4j
@RestController
public class NomalController {


    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Autowired
    ITblUserInfoService tblUserInfoService;

    @Resource(name = "safeheronConfig")
    private SafeheronConfig safeheronConfig;

    @Value("${support.coinList}")
    private List<String> coinList;

    @Autowired
    ITblCardBinInfoService cardBinInfoService;

    @Autowired
    private IEmailService emailService;

    @Autowired
    private RedisCache redisCache;

    @Value("${spring.mail.username}")
    private String from;

    @Value("${mail.register.subject}")
    private String subject;


    @RequestMapping("/getBalance")
    public AjaxResult getBalance()
    {
        TblUserInfo userInfo = tblUserInfoService.selectTblUserInfoByUserId(getUserId());
        if (null != userInfo) {
            Map dataMap = new HashMap<>();
            dataMap.put("balanceUsd", userInfo.getBalance());
            dataMap.put("balanceEur", userInfo.getBalanceEur());
            dataMap.put("balanceGbp", userInfo.getBalanceGbp());
            dataMap.put("balanceUsdt", userInfo.getBalanceUsdt());
            dataMap.put("kycFlag", userInfo.getKycFlag());
            return success(dataMap);
        }
        return error();
    }

    @GetMapping("/getRechargeList")
    public AjaxResult getRechargeList()
    {
        return success(coinList);
    }

    @GetMapping("/getRechargeAddr")
    public AjaxResult getRechargeAddr()
    {
        TblUserInfo userInfo = tblUserInfoService.selectTblUserInfoByUserId(getUserId());
        if (null != userInfo) {
            List<AccountCoinResponse> accountCoinResponseList = SafeHeronUtils.listAccountCoin(safeheronConfig, userInfo.getTronAddr());
            Map map = new HashMap();
            accountCoinResponseList.forEach(acctCoin ->{
                map.put(acctCoin.getCoinKey(), acctCoin.getAddressList().get(0).getAddress());
            });
            return success(map);
        }
        return error();
    }

    @GetMapping("/getCardBin")
    public AjaxResult getCardBin()
    {
        TblCardBinInfo cardBinInfo = new TblCardBinInfo();
        cardBinInfo.setIsEnable(UserConstants.YES);
        List<TblCardBinInfo> tblCardBinInfos = cardBinInfoService.selectTblCardBinInfoList(cardBinInfo);
        if (null != tblCardBinInfos) {
            return success(tblCardBinInfos);
        }
        return error();
    }

    @GetMapping("/getCardBinByCbid/{cbId}")
    public AjaxResult getCardBinByCbid(@PathVariable Long cbId)
    {
        TblCardBinInfo tblCardBinInfo = cardBinInfoService.selectTblCardBinInfoByCbId(cbId);
        if (null != tblCardBinInfo) {
            return success(tblCardBinInfo);
        }
        return error();
    }

    /**
     * 验证码生成
     */
    @PostMapping(value = "/captchaEmail")
    public AjaxResult getKaptchaImageToEmail(@RequestBody Map paraMap) {
        String emailto = "";
        if (StringUtils.isNotBlank((String) paraMap.get("email"))) {
            emailto = (String) paraMap.get("email");
        } else {
            emailto =getLoginUser().getUser().getEmail();
        }
        String code = captchaProducer.createText();
        // 保存验证码信息
        String uuid = IdUtils.simpleUUID();
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + uuid;
        redisCache.setCacheObject(verifyKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);

//        Context context = new Context();
//        context.setVariable("emailto", emailto);
//        context.setVariable("code", code);
//        String content = templateEngine.process("email/registerMail.html", context);

//        Map<String, Object> model = new HashMap<>();
//        model.put("emailto", emailto);
//        model.put("code", code);
//        String text = VelocityTemplate.mergeTemplateIntoString(
//                velocityEngine, "email/registerMail.vm", "UTF-8", model);

//        VelocityEngine velocityEngine = new VelocityEngine();
//        Properties p = new Properties();
//        p.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, "src/main/resources/templates");

        VelocityInitializer.initVelocity();
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("emailto", emailto);
        velocityContext.put("code", code);
        // 渲染模板
        StringWriter sw = new StringWriter();
        Template tpl = Velocity.getTemplate("templates/registerMail.vm", Constants.UTF8);
        tpl.merge(velocityContext, sw);
        String text = sw.toString();

//        Map<String, Object> model = new HashMap<>();
//        model.put("emailto", emailto);
//        model.put("code", code);
//        VelocityContext velocityContext = new VelocityContext(model);
//        StringWriter writer = new StringWriter();
//        velocityEngine.mergeTemplate("registerMail.vm", "UTF-8", velocityContext, writer);
//        String text = writer.toString();
        log.info(String.format("this email: %s code is: %s",emailto,code));

        try {
            emailService.sendHtml(from, emailto, subject, text);
//            SendGroupMsgTg.sendGroupMsgTg("邮件发送好了");
        } catch (Exception e) {
            SendGroupMsgTg.sendGroupMsgTg("邮件发送失败了，研发看");
            log.error("邮件发送异常",e);
        }
        AjaxResult ajax = AjaxResult.success();
        ajax.put("uuid", uuid);
        return ajax;
    }
}
