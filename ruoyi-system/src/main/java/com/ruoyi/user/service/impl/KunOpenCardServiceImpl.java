package com.ruoyi.user.service.impl;

import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.enums.BusTransStatus;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.risk.domain.TblOperatorCard;
import com.ruoyi.route.domain.TblChannelInfo;
import com.ruoyi.route.domain.TblRouteInfo;
import com.ruoyi.trans.domain.TblTrans;
import com.ruoyi.user.domain.TblUserChannelMapping;
import com.ruoyi.user.domain.TblUserInfo;
import com.ruoyi.user.domain.TblUserOpenCard;
import com.ruoyi.user.service.IOpenCardService;
import com.ruoyi.user.service.ITblUserChannelMappingService;
import com.ruoyi.user.service.ITblUserOpenCardService;
import com.ruoyi.user.service.impl.kun.KunUtils;
import com.ruoyi.user.service.impl.kun.api.res.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("kun")
public class KunOpenCardServiceImpl implements IOpenCardService {

    @Autowired
    ITblUserChannelMappingService tblUserchannelMappingService;

    @Autowired
    ITblUserOpenCardService tblUserOpenCardService;

    @Override
    public void saveCardHold(TblUserInfo tblUserInfo, TblChannelInfo tblChannelInfo) throws ServiceException {
        TblUserChannelMapping newUserChannelMapping = new TblUserChannelMapping();
        newUserChannelMapping.setCiId(tblChannelInfo.getCiId());
        newUserChannelMapping.setUiId(tblUserInfo.getUiId());
        //暂无
//        newUserChannelMapping.setUcmNo("");
        tblUserchannelMappingService.insertTblUserChannelMapping(newUserChannelMapping);
    }

    @Override
    public void openCard(TblUserChannelMapping tblUserChannelMapping, TblUserInfo tblUserInfo, TblRouteInfo tblRouteInfo, TblChannelInfo tblChannelInfo, TblUserOpenCard userOpenCard, String chargeAmt, String cardCurr) throws ServiceException {
        String res = KunUtils.openCard(tblUserInfo, tblChannelInfo, userOpenCard.getUocId() + "", "127.0.0.1", chargeAmt, cardCurr);
        KunCardInfoRes kunCardInfoRes = JSONUtil.toBean(res, KunCardInfoRes.class);
        userOpenCard.setCardId(kunCardInfoRes.getCardId());
        userOpenCard.setCardStatus(BusTransStatus.PROCESS.getCode());
        tblUserOpenCardService.updateTblUserOpenCard(userOpenCard);
//        {"customerId":"957775851585191936","requestNo":"46","outUserId":"100","outUserName":"周均","openAmount":"20","openCurrency":"HKD","ip":"127.0.0.1","meta":{"dialCode":"+86","phone":"13311112222","email":"oneketes@protonmail.com"}}
    }

    @Override
    public void queryCardInfoStatusAndBalance(TblUserOpenCard tblUserOpenCard, TblChannelInfo tblChannelInfo, String queryStatus) {
        switch (queryStatus) {
            case Constants.QUEYR_STATUS.STATUS:
                String openCardJsonRes = KunUtils.openCardQuery(tblChannelInfo, tblUserOpenCard.getUocId() + "");
                KunOpenCardQueryRes openCardRes = JSONUtil.toBean(openCardJsonRes, KunOpenCardQueryRes.class);
                tblUserOpenCard.setCardStatus(openCardRes.getStatus());
//                tblUserOpenCardService.updateTblUserOpenCard(tblUserOpenCard);

                return;
            case Constants.QUEYR_STATUS.INFO:
                String cardInfoJsonRes = KunUtils.cardInfoQuery(tblChannelInfo, tblUserOpenCard);
                KunCardInfoRes cardInfoRes = JSONUtil.toBean(cardInfoJsonRes, KunCardInfoRes.class);
                if (StrUtil.equals(cardInfoRes.getCardStatus(), "ACTIVE")) {
                    String aesJsonRes = KunUtils.AesKeyQuery(tblChannelInfo);
                    //解密cvv和卡号
                    KunAesKeyRes aesRes = JSONUtil.toBean(aesJsonRes, KunAesKeyRes.class);
                    AES aes = SecureUtil.aes(aesRes.getAesKey().getBytes());
                    cardInfoRes.setCvv(new String(aes.decrypt(cardInfoRes.getCvv())));
                    cardInfoRes.setCardNo(new String(aes.decrypt(cardInfoRes.getCardNo())));
                    tblUserOpenCard.setCardNo(cardInfoRes.getCardNo());
                    tblUserOpenCard.setCvv(cardInfoRes.getCvv());
                    tblUserOpenCard.setExpire(cardInfoRes.getExpiryDate());
                    //暂无
                    tblUserOpenCard.setCardHead("");
                }
//                tblUserOpenCardService.updateTblUserOpenCard(tblUserOpenCard);
                return;
            case Constants.QUEYR_STATUS.BALANCE:
                String balanceJsonRes = KunUtils.cardInfoQuery(tblChannelInfo, tblUserOpenCard);
                KunCardInfoRes balanceRes = JSONUtil.toBean(balanceJsonRes, KunCardInfoRes.class);
                tblUserOpenCard.setBalance(balanceRes.getCodbalancee());
                return;
            default:
                return;
        }
    }

    @Override
    public void recharge(TblChannelInfo tblChannelInfo, TblUserOpenCard tblUserOpenCard, TblTrans tblTrans, String chargeAmt, String cardCurr) {
        String res = KunUtils.recharge(tblChannelInfo, tblUserOpenCard, chargeAmt, cardCurr, tblTrans.getTtId() + "", "");
        //返回状态
        KunRechargeRes kunRechargeRes = JSONUtil.toBean(res, KunRechargeRes.class);
        if (StrUtil.equals("00000000", kunRechargeRes.getCode())) {
            tblTrans.setTransStatus(kunRechargeRes.getStatus());
        }
    }

    @Override
    public void rechargeQuery(TblChannelInfo tblChannelInfo, TblTrans tblTrans) {
        String res = KunUtils.rechargeQuery(tblChannelInfo, tblTrans.getTtId() + "");
        KunRechargeQueryRes kunRechargeQueryRes = JSONUtil.toBean(res, KunRechargeQueryRes.class);
        if (StrUtil.equals("00000000", kunRechargeQueryRes.getCode())) {
            tblTrans.setTransStatus(kunRechargeQueryRes.getStatus());
        }
    }

    @Override
    public List<TblTrans> openCardQuery(TblChannelInfo tblChannelInfo, TblUserOpenCard tblUserOpenCard) {
        return null;
    }

    @Override
    public boolean cancelCard(TblChannelInfo tblChannelInfo, TblUserOpenCard tblUserOpenCard, TblOperatorCard operatorCard) {
        String destroy = KunUtils.destroy(tblChannelInfo, tblUserOpenCard, operatorCard.getID() + "");
        KunDestroyRes destroyRes = JSONUtil.toBean(destroy, KunDestroyRes.class);
        if (StrUtil.equals("00000000", destroyRes.getCode())) {
            operatorCard.setStatuss(destroyRes.getStatus());
        }
        return false;
    }
}
