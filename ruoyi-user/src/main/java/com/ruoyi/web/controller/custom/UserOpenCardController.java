package com.ruoyi.web.controller.custom;

import cn.hutool.core.date.DateTime;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.enums.BusTransStatus;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.enums.CardOperatorStatus;
import com.ruoyi.common.enums.CardOperatorType;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SendGroupMsgTg;
import com.ruoyi.common.utils.mask.MaskUtils;
import com.ruoyi.common.utils.mfa.GeogleAuthUtil;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.risk.domain.TblOperatorCard;
import com.ruoyi.risk.service.ITblOperatorCardService;
import com.ruoyi.route.domain.TblChannelInfo;
import com.ruoyi.route.service.ITblChannelInfoService;
import com.ruoyi.system.domain.TblCardBinInfo;
import com.ruoyi.system.service.ITblCardBinInfoService;
import com.ruoyi.trans.domain.TblBalanceTrans;
import com.ruoyi.trans.domain.TblTrans;
import com.ruoyi.trans.service.ITblBalanceTransService;
import com.ruoyi.trans.service.ITblTransService;
import com.ruoyi.user.domain.TblUserInfo;
import com.ruoyi.user.domain.TblUserOpenCard;
import com.ruoyi.user.service.IOpenCardService;
import com.ruoyi.user.service.ITblUserInfoService;
import com.ruoyi.user.service.ITblUserOpenCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户开卡信息Controller
 *
 * @author ruoyi
 * @date 2024-07-20
 */
@RestController
@RequestMapping("/usercard")
public class UserOpenCardController extends BaseController {
    @Autowired
    private ITblUserOpenCardService tblUserOpenCardService;

    @Autowired
    private ITblUserInfoService tblUserInfoService;

    @Autowired
    private ITblTransService tblTransService;

    @Autowired
    private ITblChannelInfoService tblChannelInfoService;

    @Autowired
    private ITblCardBinInfoService tblCardBinInfoService;

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    private TransactionDefinition transactionDefinition;

    @Autowired
    private ITblBalanceTransService tblBalanceTransService;

    @Autowired
    private RedisCache redisService;

    @Autowired
    private ITblOperatorCardService operatorCardService;

    /**
     * 查询用户开卡信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list() {
        TblUserInfo userInfo = tblUserInfoService.selectTblUserInfoByUserId(getUserId());
        TblUserOpenCard tblUserOpenCard = new TblUserOpenCard();
        tblUserOpenCard.setUiId(userInfo.getUiId());
        startPage();
        List<TblUserOpenCard> list = tblUserOpenCardService.selectTblUserOpenCardList(tblUserOpenCard);
        list.forEach(MaskUtils::maskFields);
        return getDataTable(list);
    }


    /**
     * 卡充值界面
     */
    @GetMapping("/getCardInfo/{uocId}")
    public AjaxResult edit(@PathVariable("uocId") Long uocId) {
        TblUserOpenCard tblUserOpenCard = tblUserOpenCardService.selectTblUserOpenCardByUocId(uocId);
        TblCardBinInfo cardBinInfo = tblCardBinInfoService.selectTblCardBinInfoByCbId(tblUserOpenCard.getCbId());
        MaskUtils.maskFields(tblUserOpenCard);
        Map retMap = new HashMap<>();
        retMap.put("cardNo", tblUserOpenCard.getCardNo());
        retMap.put("firstName", tblUserOpenCard.getFirstName());
        retMap.put("openDt", tblUserOpenCard.getTransTime());
        retMap.put("uocId", tblUserOpenCard.getUocId());
        retMap.put("cardRechargeMin", cardBinInfo.getCardRechargeMin());
        retMap.put("cardRechargeFee", cardBinInfo.getCardRechargeFee());
        return AjaxResult.success(retMap);
    }


    /**
     * 验证2FA
     */
    @Log(title = "查看信息", businessType = BusinessType.UPDATE)
    @PostMapping("/cardInfoBy2fa")
    @ResponseBody
    public AjaxResult verify2fa(@RequestBody TblUserOpenCard tblUserOpenCard) {
        TblUserInfo userInfo = tblUserInfoService.selectTblUserInfoByUserId(getUserId());
        Long uocId = tblUserOpenCard.getUocId();
        Long code2fa = tblUserOpenCard.getCode2fa();
        GeogleAuthUtil ga = new GeogleAuthUtil();
        if (!ga.check_code(userInfo.getCode2fa(), code2fa, System.currentTimeMillis())) {
            return AjaxResult.error("验证失败");
        }

        if (null != uocId) {
            TblUserOpenCard tblUserOpenCardfromdb = tblUserOpenCardService.selectTblUserOpenCardByUocId(uocId);
            if (tblUserOpenCardfromdb != null && !tblUserOpenCardfromdb.getUiId().equals(userInfo.getUiId())) {
                SendGroupMsgTg.sendGroupMsgTgTech(String.format("卡充值有人瞎搞，小心攻击，传入卡号：%s,登录用户：%s",tblUserOpenCardfromdb.getCardNo(),getLoginUser().getUsername()));
                return AjaxResult.error("System error.");
            }
            if (tblUserOpenCardfromdb != null && tblUserOpenCardfromdb.getUiId().equals(userInfo.getUiId())) {
                Map map = new HashMap<>();
                map.put("cardNo", tblUserOpenCardfromdb.getCardNo());
                map.put("cvv", tblUserOpenCardfromdb.getCvv());
                map.put("expire", tblUserOpenCardfromdb.getExpire());
                map.put("firstName", tblUserOpenCardfromdb.getFirstName());
                map.put("lastName", tblUserOpenCardfromdb.getLastName());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                map.put("openDt", simpleDateFormat.format(tblUserOpenCardfromdb.getTransTime()));
                return AjaxResult.success(map);
            }
        }
        return AjaxResult.error("查不到当前卡信息");
    }

    /**
     * 卡充值
     */
    @Log(title = "卡充值", businessType = BusinessType.UPDATE)
    @PostMapping("/cardRecharge")
    public AjaxResult editSave(@RequestBody TblUserOpenCard tblUserOpenCard) {
        String amount = tblUserOpenCard.getAmount();
        TblUserInfo tblUserInfo = tblUserInfoService.selectTblUserInfoByUserId(getUserId());
        TblUserOpenCard tblUserOpenCard1 = tblUserOpenCardService.selectTblUserOpenCardByUocId(tblUserOpenCard.getUocId());
        if (tblUserOpenCard1 != null &&  !tblUserOpenCard1.getUiId().equals(tblUserInfo.getUiId())) {
            SendGroupMsgTg.sendGroupMsgTgTech(String.format("卡充值有人瞎搞，小心攻击，传入卡号：%s,登录用户：%s",tblUserOpenCard1.getCardNo(),getLoginUser().getUsername()));
            return AjaxResult.error("System error.");
        }
        TblUserInfo userInfo = tblUserInfoService.selectTblUserInfoByUiId(tblUserOpenCard1.getUiId());
        if (userInfo.getBalance().compareTo(new BigDecimal(amount)) > 0) {
            TblChannelInfo tblChannelInfo = tblChannelInfoService.selectTblChannelInfoByCiId(tblUserOpenCard1.getCiId());
            TblCardBinInfo cardBinInfo = tblCardBinInfoService.selectTblCardBinInfoByCbId(tblUserOpenCard1.getCbId());
            if (cardBinInfo.getCardRechargeMin().compareTo(new BigDecimal(amount)) > 0) {
                return AjaxResult.error(String.format("充值最小金额为:%s", cardBinInfo.getCardRechargeMin()));
            }

            TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
            TblTrans tblTrans = new TblTrans();
            try {
                tblTrans.setAgentStatus(BusTransStatus.INIT.getCode());
                tblTrans.setTransStatus(BusTransStatus.INIT.getCode());
                tblTrans.setCardNo(tblUserOpenCard1.getCardNo());
                tblTrans.setCiId(tblUserOpenCard1.getCiId());
                tblTrans.setTransAmt(new BigDecimal(amount));
                tblTrans.setTransFee(new BigDecimal(amount).multiply(cardBinInfo.getCardRechargeFee()));
                tblTrans.setTransCurr("USD");
                tblTrans.setTransType("R");
                tblTrans.setUiId(userInfo.getUiId());
                tblTrans.setTransTime(new Date());
                tblTrans.setUocId(tblUserOpenCard1.getUocId());
                tblTransService.insertTblTrans(tblTrans);

                TblBalanceTrans tblBalanceChargeTrans = new TblBalanceTrans();
                tblBalanceChargeTrans.setTransTime(new Date());
                tblBalanceChargeTrans.setTransAmt(tblTrans.getTransAmt().add(tblTrans.getTransFee()));
                tblBalanceChargeTrans.setTransBeforeAmt(new BigDecimal(0));
                tblBalanceChargeTrans.setTransAfterAmt(new BigDecimal(0));
                tblBalanceChargeTrans.setTransId(Long.valueOf(tblTrans.getTtId()));
                tblBalanceChargeTrans.setUbType("D");
                tblBalanceChargeTrans.setUiId(userInfo.getUiId());
                tblBalanceChargeTrans.setTransCurr("USD");
                tblBalanceChargeTrans.setRemark("Charge.");
                tblBalanceTransService.insertTblBalanceTransByUserBalance(tblBalanceChargeTrans);

                userInfo.setBalance(new BigDecimal(-(tblTrans.getTransAmt().add(tblTrans.getTransFee())).doubleValue()));
                int i = tblUserInfoService.updateTblUserInfoBalance(userInfo);
                if (i > 0) {
                    dataSourceTransactionManager.commit(transactionStatus); // 手动提交
                } else {
                    throw new ServiceException("余额不足，请检查");
                }
            } catch (Exception e) {
                logger.error("卡充值", e);
                dataSourceTransactionManager.rollback(transactionStatus);
                throw new ServiceException("手续费扣除异常，请检查");
            }
            try {
                IOpenCardService openCardService = SpringUtils.getBean(tblChannelInfo.getCiAopName());
                openCardService.recharge(tblChannelInfo, tblUserOpenCard1, tblTrans, amount, "USD");
            } catch (Exception e) {
                return error(String.format("%s:由于系统升级，暂停支持!!", tblUserOpenCard1.getCardHead()));
            }
            return AjaxResult.success();
        } else {
            return AjaxResult.warn("余额不足，请先进行账户充值");
        }
    }


//    @GetMapping("/transactionData/{uocId}")
//    public String getTransactionData(@PathVariable("uocId") String uocId, ModelMap model) {
//        model.addAttribute("uocId", uocId);
//        return prefix + "/transactionData";
//    }

//    @PostMapping("/transactionData")
//    @ResponseBody
//    public TableDataInfo getTransactionData(@RequestParam("uocId") String uocId) {
//        TblUserOpenCard cardinfo = tblUserOpenCardService.selectTblUserOpenCardByUocId(Long.valueOf(uocId));
//        startPage();
//        // 获取分页参数
//        PageDomain pageDomain = TableSupport.buildPageRequest();
//        Integer pageNum = pageDomain.getPageNum();
//        Integer pageSize = pageDomain.getPageSize();
//
//        TblChannelInfo currChannel = (TblChannelInfo) redisService.getValueByKey(RedisKeys.REDIS_CHANNEL_NAME.PYVIO);
//        if (currChannel == null) {
//            TblChannelInfo tblChannelInfoQuery = new TblChannelInfo();
//            tblChannelInfoQuery.setCiAopName("pyvio");
//            List<TblChannelInfo> tblChannelInfos = tblChannelInfoService.selectTblChannelInfoList(tblChannelInfoQuery);
//            if (tblChannelInfos != null && !tblChannelInfos.isEmpty()) {
//                currChannel = tblChannelInfos.get(0);
//                redisService.setKeyValue(RedisKeys.REDIS_CHANNEL_NAME.PYVIO, currChannel);
//            }
//        }
//
//        String beginTime = "2024-01-01 00:00:00";
//        String endTime = DateTime.now().toString(DatePattern.NORM_DATETIME_PATTERN);
//        AuthTransactionsGetResponse res = PyvioIssuing.authTransactionsGetRequest(currChannel, cardinfo.getCardNo(), pageNum, pageSize, beginTime, endTime);
//        return getDataTable(res.getList());
//    }

    /**
     * 查看余额
     */
    @GetMapping("/queryBalance/{uocId}")
    public AjaxResult queryBalance(@PathVariable("uocId") Long uocId) {
        TblUserOpenCard tblUserOpenCard = tblUserOpenCardService.selectTblUserOpenCardByUocId(uocId);
        TblUserInfo tblUserInfo = tblUserInfoService.selectTblUserInfoByUserId(getUserId());
        if (!tblUserOpenCard.getUiId().equals(tblUserInfo.getUiId())) {
            SendGroupMsgTg.sendGroupMsgTgTech(String.format("查看余额有人瞎搞，小心攻击，传入卡号：%s,登录用户：%s",tblUserOpenCard.getCardNo(),getLoginUser().getUsername()));
            return AjaxResult.error("System error.");
        }

        TblChannelInfo tblChannelInfo = tblChannelInfoService.selectTblChannelInfoByCiId(tblUserOpenCard.getCiId());
        try {
            IOpenCardService openCardService = SpringUtils.getBean(tblChannelInfo.getCiAopName());
            openCardService.queryCardInfoStatusAndBalance(tblUserOpenCard, tblChannelInfo, Constants.QUEYR_STATUS.BALANCE);
            MaskUtils.maskFields(tblUserOpenCard);
            return success(String.format("%s:该卡当前余额为：%s",tblUserOpenCard.getCardNo(),tblUserOpenCard.getBalance()));
        } catch (Exception e) {
            return error(String.format("%s:余额查询失败，请稍后重试!", tblUserOpenCard.getCardHead()));
        }
    }

    /**
     * 销卡
     */
    @GetMapping("/cancel/{uocId}")
    public AjaxResult cancel(@PathVariable("uocId") Long uocId) {
        TblUserOpenCard tblUserOpenCard = tblUserOpenCardService.selectTblUserOpenCardByUocId(uocId);
        TblUserInfo tblUserInfo = tblUserInfoService.selectTblUserInfoByUserId(getUserId());
        if ( !tblUserOpenCard.getUiId().equals(tblUserInfo.getUiId())) {
            SendGroupMsgTg.sendGroupMsgTgTech(String.format("销卡有人瞎搞，小心攻击，传入卡号：%s,登录用户：%s",tblUserOpenCard.getCardNo(),getLoginUser().getUsername()));
            return AjaxResult.error("System error.");
        }

        TblChannelInfo tblChannelInfo = tblChannelInfoService.selectTblChannelInfoByCiId(tblUserOpenCard.getCiId());
        try {
            IOpenCardService openCardService = SpringUtils.getBean(tblChannelInfo.getCiAopName());
            TblOperatorCard operatorCard = new TblOperatorCard();
            operatorCard.setCardNo(tblUserOpenCard.getCardNo());
            operatorCard.setStatuss(CardOperatorStatus.INIT.getCode());
            operatorCard.setOperType(CardOperatorType.CLO.getCode());
            operatorCard.setOperUser(getLoginUser().getUsername());
            operatorCard.setOperTime(DateTime.now());
            operatorCardService.insertTblOperatorCard(operatorCard);

            boolean b = openCardService.cancelCard(tblChannelInfo, tblUserOpenCard, operatorCard);
            MaskUtils.maskFields(tblUserOpenCard);
            if (b) {
                tblUserOpenCard.setCardStatus(BusTransStatus.CANCEL.getCode());
                tblUserOpenCardService.updateTblUserOpenCard(tblUserOpenCard);
                operatorCard.setStatuss(CardOperatorStatus.SUCCESS.getCode());
                operatorCardService.updateTblOperatorCard(operatorCard);
                return success(String.format("%s:销卡成功！！", tblUserOpenCard.getCardNo()));
            } else {
                operatorCard.setStatuss(CardOperatorStatus.FAIL.getCode());
                operatorCardService.updateTblOperatorCard(operatorCard);
                return error(String.format("%s:销卡异常，请稍后重试!", tblUserOpenCard.getCardNo()));
            }
        } catch (Exception e) {
            return error(String.format("%s:销卡异常，请稍后重试!", tblUserOpenCard.getCardHead()));
        }
    }

}
