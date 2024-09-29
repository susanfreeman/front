package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.SendGroupMsgTg;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.MimeTypeUtils;
import com.ruoyi.common.utils.mfa.GeogleAuthUtil;
import com.ruoyi.framework.web.service.SysPasswordService;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.user.domain.TblUserInfo;
import com.ruoyi.user.service.ITblUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 个人信息 业务处理
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/user/profile")
public class SysProfileController extends BaseController {
    @Autowired
    private ISysUserService userService;

    @Value("${pord.inviteuri}")
    private String inviteUriBase;

    @Autowired
    private ITblUserInfoService userInfoService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private SysPasswordService passwordService;

    /**
     * 个人信息
     */
    @GetMapping
    public AjaxResult profile() {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        AjaxResult ajax = AjaxResult.success(user);
        ajax.put("userInfo", userInfoService.selectTblUserInfoByUserId(getUserId()));
        ajax.put("inviteUriBase", inviteUriBase);
//        ajax.put("postGroup", userService.selectUserPostGroup(loginUser.getUsername()));
        return ajax;
    }

//    /**
//     * 修改用户
//     */
//    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
//    @PutMapping
//    public AjaxResult updateProfile(@RequestBody SysUser user) {
//        LoginUser loginUser = getLoginUser();
//        SysUser currentUser = loginUser.getUser();
//        currentUser.setNickName(user.getNickName());
//        currentUser.setEmail(user.getEmail());
//        currentUser.setPhonenumber(user.getPhonenumber());
//        currentUser.setSex(user.getSex());
//        if (StringUtils.isNotEmpty(user.getPhonenumber()) && !userService.checkPhoneUnique(currentUser)) {
//            return error("修改用户'" + loginUser.getUsername() + "'失败，手机号码已存在");
//        }
//        if (StringUtils.isNotEmpty(user.getEmail()) && !userService.checkEmailUnique(currentUser)) {
//            return error("修改用户'" + loginUser.getUsername() + "'失败，邮箱账号已存在");
//        }
//        if (userService.updateUserProfile(currentUser) > 0) {
//            // 更新缓存用户信息
//            tokenService.setLoginUser(loginUser);
//            return success();
//        }
//        return error("修改个人信息异常，请联系管理员");
//    }


    /**
     * 头像上传
     */
    @Log(title = "用户头像", businessType = BusinessType.UPDATE)
    @PostMapping("/avatar")
    public AjaxResult avatar(@RequestParam("avatarfile") MultipartFile file) throws Exception {
        if (!file.isEmpty()) {
            LoginUser loginUser = getLoginUser();
            String avatar = FileUploadUtils.upload(RuoYiConfig.getAvatarPath(), file, MimeTypeUtils.IMAGE_EXTENSION);
            if (userService.updateUserAvatar(loginUser.getUsername(), avatar)) {
                AjaxResult ajax = AjaxResult.success();
                ajax.put("imgUrl", avatar);
                // 更新缓存用户头像
                loginUser.getUser().setAvatar(avatar);
                tokenService.setLoginUser(loginUser);
                return ajax;
            }
        }
        return error("上传图片异常，请联系管理员");
    }

    @GetMapping("/getGoogle2fa")
    @ResponseBody
    public AjaxResult getGoogle2fa() {
        if (StringUtils.isNotBlank(getUserId()+"")) {
            AjaxResult ajaxResult = success();
            ajaxResult.put("code2fa", GeogleAuthUtil.generateSecretKey());
            return ajaxResult;
        }
        return error();
    }

    @Log(title = "绑定2fa", businessType = BusinessType.UPDATE)
    @PostMapping("/reset2fa")
    @ResponseBody
    public AjaxResult reset2fa(@RequestBody Map paraMap) {

        String verifyCode =(String) paraMap.get("verifyCode");
        Long confirm2fa =Long.parseLong((String) paraMap.get("confirm2fa"));
        String codeText2fa =(String) paraMap.get("codeText2fa");
        String uuid =(String) paraMap.get("uuid");

        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
        String captcha = redisCache.getCacheObject(verifyKey);
        if (!verifyCode.equals(captcha)) {
            return error();
        }

        redisCache.deleteObject(verifyKey);
        GeogleAuthUtil ga = new GeogleAuthUtil();
        boolean r = ga.check_code(codeText2fa, confirm2fa, System.currentTimeMillis());
        if (r) {
            TblUserInfo tblUserInfos = userInfoService.selectTblUserInfoByUserId(getUserId());
            tblUserInfos.setCode2fa(codeText2fa);
            userInfoService.updateTblUserInfo(tblUserInfos);
            return success();
        }
        return error();
    }

    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwd(@RequestBody Map paraMap)
    {
        String oldPassword = (String) paraMap.get("oldPassword");
        String newPassword = (String) paraMap.get("newPassword");
        LoginUser loginUser = getLoginUser();
        String userName = loginUser.getUsername();
        String password = loginUser.getPassword();
        if (!SecurityUtils.matchesPassword(oldPassword, password))
        {
            return error("修改密码失败，旧密码错误");
        }
        if (SecurityUtils.matchesPassword(newPassword, password))
        {
            return error("新密码不能与旧密码相同");
        }
        newPassword = SecurityUtils.encryptPassword(newPassword);
        if (userService.resetUserPwd(userName, newPassword) > 0)
        {
            // 更新缓存用户密码
            loginUser.getUser().setPassword(newPassword);
            tokenService.setLoginUser(loginUser);
            return success();
        }
        return error("修改密码异常，请联系管理员");
    }

}
