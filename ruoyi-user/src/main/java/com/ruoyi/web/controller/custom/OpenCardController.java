package com.ruoyi.web.controller.custom;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.OpenCardBody;
import com.ruoyi.common.enums.BusTransStatus;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.MessageUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.route.domain.TblChannelInfo;
import com.ruoyi.route.domain.TblRouteInfo;
import com.ruoyi.route.service.ITblChannelInfoService;
import com.ruoyi.route.service.ITblRouteInfoService;
import com.ruoyi.system.domain.TblCardBinInfo;
import com.ruoyi.system.service.ITblCardBinInfoService;
import com.ruoyi.trans.domain.TblBalanceTrans;
import com.ruoyi.trans.domain.TblTrans;
import com.ruoyi.trans.service.ITblBalanceTransService;
import com.ruoyi.trans.service.ITblTransService;
import com.ruoyi.user.domain.TblUserChannelMapping;
import com.ruoyi.user.domain.TblUserInfo;
import com.ruoyi.user.domain.TblUserOpenCard;
import com.ruoyi.user.service.IOpenCardService;
import com.ruoyi.user.service.ITblUserChannelMappingService;
import com.ruoyi.user.service.ITblUserInfoService;
import com.ruoyi.user.service.ITblUserOpenCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ruoyi.common.core.domain.AjaxResult.*;
import static com.ruoyi.common.utils.SecurityUtils.getUserId;


/**
 * 首页
 *
 * @author ruoyi
 */
@Slf4j
@RestController
public class OpenCardController
{
    @Autowired
    ITblUserInfoService tblUserInfoService;

    @Autowired
    ITblCardBinInfoService cardBinInfoService;

    @Autowired
    ITblUserChannelMappingService tblUserChannelMappingService;

    @Autowired
    ITblRouteInfoService tblRouteInfoService;

    @Autowired
    ITblChannelInfoService tblChannelInfoService;


    @Autowired
    ITblTransService tblTransService;

    @Autowired
    ITblBalanceTransService tblBalanceTransService;

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    private TransactionDefinition transactionDefinition;

    @Autowired
    ITblUserOpenCardService tblUserOpenCardService;

    /**
     * 开卡
     */
    @Log(title = "开卡", businessType = BusinessType.INSERT)
    @PostMapping("/applyCard")
    public AjaxResult applyCard(@RequestBody OpenCardBody openCardBody) {

        String chargeAmt = openCardBody.getChargeAmt();
        String cardHead = openCardBody.getCardHead();

        if (StringUtils.isBlank(chargeAmt)) {
//            return error("充值金额不能为0");
            //国际化返回
            return error(MessageUtils.message("error.recharge"));
        }

        TblUserInfo tblUserInfo = new TblUserInfo();
        tblUserInfo.setFirstName(openCardBody.getFirstName());
        tblUserInfo.setLastName(openCardBody.getLastName());

//        获取用户信息  准备开搞
        TblUserInfo userInfoQuery = new TblUserInfo();
        userInfoQuery.setUserId(getUserId());
        List<TblUserInfo> tblUserInfos = tblUserInfoService.selectTblUserInfoList(userInfoQuery);
        if (tblUserInfos.size() == 1) {
            TblUserInfo tblUserInfo1 = tblUserInfos.get(0);
//            获取路由信息   确定通道   优先找指定用户的路由，没有再找全局的
            TblRouteInfo tblRouteInfo = new TblRouteInfo();
            tblRouteInfo.setCardHead(cardHead);
            tblRouteInfo.setUiId(tblUserInfo1.getUiId());
            List<TblRouteInfo> tblRouteInfos = tblRouteInfoService.selectTblRouteInfoList(tblRouteInfo);
            TblRouteInfo tblRouteInfo1 = null;
            if (tblRouteInfos.isEmpty()) {
                tblRouteInfo.setUiId(null);
                tblRouteInfos = tblRouteInfoService.selectTblRouteInfoList(tblRouteInfo);
            }

            if (!tblRouteInfos.isEmpty()) {
                tblRouteInfo1 = tblRouteInfos.get(0);
            } else {
                return error(String.format("%s:由于系统升级，暂停支持", cardHead));
            }

            TblChannelInfo tblChannelInfo = tblChannelInfoService.selectTblChannelInfoByCiId(tblRouteInfo1.getCiId());
            if (tblChannelInfo == null) {
                return error(String.format("%s:由于系统升级，暂停支持!", cardHead));
            }

            TblCardBinInfo cardBinInfo = new TblCardBinInfo();
            cardBinInfo.setCardBin(cardHead);
            List<TblCardBinInfo> tblCardBinInfos = cardBinInfoService.selectTblCardBinInfoList(cardBinInfo);
            if (!tblCardBinInfos.isEmpty()) {
                cardBinInfo = tblCardBinInfos.get(0);
            } else {
                return error(String.format("%s:由于系统升级，暂停支持", cardHead));
            }

//            根据通道编号，获取用户在通道特性数据
            TblUserChannelMapping tblUserChannelMapping = new TblUserChannelMapping();
            tblUserChannelMapping.setUiId(tblUserInfo1.getUiId());
            TblUserChannelMapping userChannelMapping = null;
            if (tblRouteInfo1 != null) {
                tblUserChannelMapping.setCiId(tblRouteInfo1.getCiId());
                List<TblUserChannelMapping> tblUserChannelMappings = tblUserChannelMappingService.selectTblUserChannelMappingList(tblUserChannelMapping);
                if (!tblUserChannelMappings.isEmpty()) {
                    userChannelMapping = tblUserChannelMappings.get(0);
                }
            }

//            按表中配置的数据  获取通道对应的beanName 进行后续开卡
            IOpenCardService openCardService;
            try {
                openCardService = SpringUtils.getBean(tblChannelInfo.getCiAopName());
            } catch (Exception e) {
                return error(String.format("%s:由于系统升级，暂停支持!!", cardHead));
            }

            fillUserInfo(tblUserInfo, tblUserInfo1);

            TblUserOpenCard userOpenCard = buildUserOpenCard(tblRouteInfo, tblChannelInfo, tblUserInfo1,cardBinInfo);

            try {
                cacullateFee(cardBinInfo, chargeAmt, tblUserInfo1.getUiId(), tblChannelInfo.getCiId(),userOpenCard.getUocId());
            } catch (ServiceException e) {
                return error( e.getMessage());
            }

            try {
//            拿到通道特性数据后，进行开卡操作。
                openCardService.openCard(userChannelMapping, tblUserInfo1, tblRouteInfo1, tblChannelInfo,userOpenCard, chargeAmt, cardBinInfo.getCardCurr());
            } catch (ServiceException e) {
                return error( e.getMessage());
            }

        } else {
            return warn("请先完善个人信息！");
        }
        return success();
    }


    private void fillUserInfo(TblUserInfo source, TblUserInfo target) {
        if (StringUtils.isNotEmpty(source.getFirstName())) {
            target.setFirstName(source.getFirstName());
        }
        if (StringUtils.isNotEmpty(source.getLastName())) {
            target.setLastName(source.getLastName());
        }
        if (null != source.getBirthday()) {
            target.setBirthday(source.getBirthday());
        }
        if (StringUtils.isNotEmpty(source.getPostCode())) {
            target.setPostCode(source.getPostCode());
        }
        if (StringUtils.isNotEmpty(source.getProvince())) {
            target.setProvince(source.getProvince());
        }
        if (StringUtils.isNotEmpty(source.getCity())) {
            target.setCity(source.getCity());
        }
    }

    private TblUserOpenCard buildUserOpenCard(TblRouteInfo tblRouteInfo, TblChannelInfo tblChannelInfo, TblUserInfo tblUserInfo,TblCardBinInfo cardBinInfo) {
        TblUserOpenCard tblUserOpenCard = new TblUserOpenCard();
        tblUserOpenCard.setCardHead(tblRouteInfo.getCardHead());
        tblUserOpenCard.setCiId(tblChannelInfo.getCiId());
        tblUserOpenCard.setUiId(tblUserInfo.getUiId());
        tblUserOpenCard.setFirstName(tblUserInfo.getFirstName());
        tblUserOpenCard.setLastName(tblUserInfo.getLastName());
        tblUserOpenCard.setTransTime(new Date());
        tblUserOpenCard.setCardStatus(BusTransStatus.INIT.getCode());
        tblUserOpenCard.setCbId(cardBinInfo.getCbId());
        tblUserOpenCard.setCardCurr(cardBinInfo.getCardCurr());
        tblUserOpenCardService.insertTblUserOpenCard(tblUserOpenCard);
        return tblUserOpenCard;
    }

    private void cacullateFee(TblCardBinInfo tblCardBinInfo, String chargeAmt, Long uiId, Long ciId,Long userOpenCardId) throws ServiceException {
        TblTrans tblTrans = new TblTrans();
        tblTrans.setAgentStatus(BusTransStatus.INIT.getCode());
        tblTrans.setTransStatus(BusTransStatus.PROCESS.getCode());
        tblTrans.setCardNo(tblCardBinInfo.getCardBin());
        tblTrans.setCiId(ciId);
        tblTrans.setTransAmt(new BigDecimal(0));
        tblTrans.setTransFee(tblCardBinInfo.getCardOpenFee());
        tblTrans.setTransCurr(tblCardBinInfo.getCardCurr());
        tblTrans.setTransType("O");
        tblTrans.setUiId(uiId);
        tblTrans.setTransTime(new Date());
        tblTrans.setUocId(userOpenCardId);

        TblTrans reChargeTrans = new TblTrans();
        reChargeTrans.setAgentStatus(BusTransStatus.INIT.getCode());
        reChargeTrans.setTransStatus(BusTransStatus.PROCESS.getCode());
        reChargeTrans.setCardNo(tblCardBinInfo.getCardBin());
        reChargeTrans.setCiId(ciId);
        reChargeTrans.setTransAmt(new BigDecimal(chargeAmt));
        reChargeTrans.setTransFee(new BigDecimal(chargeAmt).multiply(tblCardBinInfo.getCardRechargeFee()));
        reChargeTrans.setTransCurr(tblCardBinInfo.getCardCurr());
        reChargeTrans.setTransType("R");
        reChargeTrans.setUiId(uiId);
        reChargeTrans.setTransTime(new Date());
        reChargeTrans.setUocId(userOpenCardId);

        BigDecimal needMoney = tblCardBinInfo.getCardOpenFee().add(new BigDecimal(chargeAmt)).add(new BigDecimal(chargeAmt).multiply(tblCardBinInfo.getCardRechargeFee()));
        TblUserInfo userInfo = tblUserInfoService.selectTblUserInfoByUiId(uiId);
        BigDecimal balance = userInfo.getBalance();
        if (balance.compareTo(needMoney) <= 0) {
            throw new ServiceException("余额不够，请先充值");
        }

        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            tblTransService.insertTblTrans(tblTrans);
            tblTransService.insertTblTrans(reChargeTrans);

//            开卡费
            TblBalanceTrans tblBalanceTrans = new TblBalanceTrans();
            tblBalanceTrans.setTransTime(new Date());
            tblBalanceTrans.setTransAmt(tblTrans.getTransAmt().add(tblTrans.getTransFee()));
            tblBalanceTrans.setTransBeforeAmt(new BigDecimal(0));
            tblBalanceTrans.setTransAfterAmt(new BigDecimal(0));
            tblBalanceTrans.setTransId(Long.valueOf(tblTrans.getTtId()));
            tblBalanceTrans.setUbType("D");
            tblBalanceTrans.setUiId(uiId);
            tblBalanceTrans.setTransCurr("USD");
            tblBalanceTrans.setRemark("Open Card.");

            //            充值费
            TblBalanceTrans tblBalanceChargeTrans = new TblBalanceTrans();
            tblBalanceChargeTrans.setTransTime(new Date());
            tblBalanceChargeTrans.setTransAmt(reChargeTrans.getTransAmt().add(reChargeTrans.getTransFee()));
            tblBalanceChargeTrans.setTransBeforeAmt(new BigDecimal(0));
            tblBalanceChargeTrans.setTransAfterAmt(new BigDecimal(0));
            tblBalanceChargeTrans.setTransId(Long.valueOf(reChargeTrans.getTtId()));
            tblBalanceChargeTrans.setUbType("D");
            tblBalanceChargeTrans.setUiId(uiId);
            tblBalanceChargeTrans.setTransCurr("USD");
            tblBalanceChargeTrans.setRemark("Charge.");

            tblBalanceTransService.insertTblBalanceTransByUserBalance(tblBalanceTrans);
            TblUserInfo tblUserInfo = new TblUserInfo();
            tblUserInfo.setUiId(uiId);
            tblUserInfo.setBalance(new BigDecimal(-(tblTrans.getTransAmt().add(tblTrans.getTransFee())).doubleValue()));
            tblUserInfoService.updateTblUserInfoBalance(tblUserInfo);


            tblBalanceTransService.insertTblBalanceTransByUserBalance(tblBalanceChargeTrans);
            tblUserInfo.setUiId(uiId);
            tblUserInfo.setBalance(new BigDecimal(-(reChargeTrans.getTransAmt().add(reChargeTrans.getTransFee())).doubleValue()));
            tblUserInfoService.updateTblUserInfoBalance(tblUserInfo);

            TblUserInfo userInfo1 = tblUserInfoService.selectTblUserInfoByUiId(uiId);
            if (userInfo1.getBalance().doubleValue() < 0 || userInfo1.getBalanceGbp().doubleValue() < 0
                    || userInfo1.getBalanceUsdt().doubleValue() < 0 || userInfo1.getBalanceEur().doubleValue() < 0) {
                throw new ServiceException("余额不足，请检查");
            }
            dataSourceTransactionManager.commit(transactionStatus); // 手动提交
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transactionStatus);
            log.error("计算手续费",e);
            throw new ServiceException("手续费扣除异常，请检查");
        }
    }

}
