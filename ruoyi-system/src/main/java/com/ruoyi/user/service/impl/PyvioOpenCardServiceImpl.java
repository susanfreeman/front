package com.ruoyi.user.service.impl;

import com.pyvio.openapi.sdk.entity.issuing.balance.CardBalanceGetResponse;
import com.pyvio.openapi.sdk.entity.issuing.balance.CardRechargeResponse;
import com.pyvio.openapi.sdk.entity.issuing.card.CardCancelResponse;
import com.pyvio.openapi.sdk.entity.issuing.card.CardCreateResponse;
import com.pyvio.openapi.sdk.entity.issuing.card.CardDetailGetResponse;
import com.pyvio.openapi.sdk.entity.issuing.card.CardStatusGetResponse;
import com.pyvio.openapi.sdk.entity.issuing.cardholder.CardholderCreateResponse;
import com.pyvio.openapi.sdk.entity.issuing.transaction.CardTransactionGetResponse;
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
import com.ruoyi.user.service.impl.pyvio.PyvioIssuing;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * description: OpenCardServiceImpl <br>
 * date: 2024/7/21 23:05 <br>
 *
 * <br>
 *
 * @version: 1.0 <br>
 */
@Service("pyvio")
public class PyvioOpenCardServiceImpl implements IOpenCardService {

    public static interface trans_type{
        public static String CREATE = "Create";
        public static String RECHARGE = "Recharge";
    }

    @Autowired
    ITblUserChannelMappingService tblUserchannelMappingService;

    @Autowired
    ITblUserOpenCardService tblUserOpenCardService;

    @Override
    public void saveCardHold(TblUserInfo tblUserInfo, TblChannelInfo tblChannelInfo) throws ServiceException {
        CardholderCreateResponse cardholderCreateResponse = PyvioIssuing.cardholderCreateRequest(tblUserInfo, tblChannelInfo);
        if (StringUtils.isNotBlank(cardholderCreateResponse.getCard_holder_id())) {
            TblUserChannelMapping newUserChannelMapping = new TblUserChannelMapping();
            newUserChannelMapping.setCiId(tblChannelInfo.getCiId());
            newUserChannelMapping.setUiId(tblUserInfo.getUiId());
            newUserChannelMapping.setUcmNo(cardholderCreateResponse.getCard_holder_id());
            tblUserchannelMappingService.insertTblUserChannelMapping(newUserChannelMapping);
        } else {
            throw new ServiceException(cardholderCreateResponse.getErrorMsg());
        }
    }

    @Override
    public void openCard(TblUserChannelMapping tblUserChannelMapping, TblUserInfo tblUserInfo, TblRouteInfo tblRouteInfo, TblChannelInfo tblChannelInfo, TblUserOpenCard userOpenCard, String chargeAmt, String cardCurr) throws ServiceException {
        CardCreateResponse cardCreateResponse = PyvioIssuing.cardCreateRequest(tblUserChannelMapping,tblUserInfo, tblChannelInfo, tblRouteInfo, userOpenCard, chargeAmt, cardCurr);
//        438357卡被撸  直接拒
        if (StringUtils.isNotBlank(cardCreateResponse.getCard_id()) && !cardCreateResponse.getCard_id().startsWith("438357")) {
            userOpenCard.setCardId(cardCreateResponse.getCard_id());
            userOpenCard.setCardStatus(BusTransStatus.PROCESS.getCode());
            tblUserOpenCardService.updateTblUserOpenCard(userOpenCard);
        } else {
            throw new ServiceException(cardCreateResponse.getErrorMsg());
        }

    }

    @Override
    public void queryCardInfoStatusAndBalance(TblUserOpenCard tblUserOpenCard, TblChannelInfo tblChannelInfo, String queryStatus) {
        switch (queryStatus) {
            case Constants.QUEYR_STATUS.STATUS:
                CardStatusGetResponse cardStatusGetResponse = PyvioIssuing.cardStatusGetRequest(tblChannelInfo, tblUserOpenCard);
                tblUserOpenCard.setCardStatus(cardStatusGetResponse.getApply_status());
//                tblUserOpenCardService.updateTblUserOpenCard(tblUserOpenCard);

                return;
            case Constants.QUEYR_STATUS.INFO:
                CardDetailGetResponse cardDetailGetResponse = PyvioIssuing.cardDetailGetRequest(tblChannelInfo, tblUserOpenCard);
                tblUserOpenCard.setCardNo(cardDetailGetResponse.getCard_number());
                tblUserOpenCard.setCvv(cardDetailGetResponse.getCvv());
                tblUserOpenCard.setExpire(cardDetailGetResponse.getExpiry());
                tblUserOpenCard.setCardHead(cardDetailGetResponse.getCard_bin_id());
//                tblUserOpenCardService.updateTblUserOpenCard(tblUserOpenCard);
                return;
            case Constants.QUEYR_STATUS.BALANCE:
                CardBalanceGetResponse cardBalanceGetResponse = PyvioIssuing.cardBalanceGetRequest(tblChannelInfo, tblUserOpenCard);
                tblUserOpenCard.setBalance(cardBalanceGetResponse.getAvailable_balance());
                return;
            default:
                CardStatusGetResponse csgr = PyvioIssuing.cardStatusGetRequest(tblChannelInfo, tblUserOpenCard);
                tblUserOpenCard.setCardStatus(csgr.getApply_status());

                if ("Active".equals(csgr.getApply_status())) {
                    CardDetailGetResponse cdgr = PyvioIssuing.cardDetailGetRequest(tblChannelInfo, tblUserOpenCard);
                    tblUserOpenCard.setCardNo(cdgr.getCard_number());
                    tblUserOpenCard.setCvv(cdgr.getCvv());
                    tblUserOpenCard.setExpire(cdgr.getExpiry());
                    tblUserOpenCard.setCardHead(cdgr.getCard_bin_id());
//                    tblUserOpenCardService.updateTblUserOpenCard(tblUserOpenCard);

                    CardBalanceGetResponse cbgr = PyvioIssuing.cardBalanceGetRequest(tblChannelInfo, tblUserOpenCard);
                    tblUserOpenCard.setBalance(cbgr.getAvailable_balance());
                }
                return;
        }
    }

    @Override
    public void recharge(TblChannelInfo tblChannelInfo, TblUserOpenCard tblUserOpenCard, TblTrans tblTrans, String chargeAmt, String cardCurr) {
        CardRechargeResponse cardRechargeResponse = PyvioIssuing.cardRechargeRequest(tblChannelInfo, tblUserOpenCard, chargeAmt, cardCurr, tblTrans.getTtId() + "");
    }

    @Override
    public void rechargeQuery(TblChannelInfo tblChannelInfo, TblTrans tblTrans) {
        CardTransactionGetResponse cardTransactionGetResponse = PyvioIssuing.cardTransactionsGetRequest(tblChannelInfo, tblTrans,null);
        if (cardTransactionGetResponse != null && cardTransactionGetResponse.getList() != null && cardTransactionGetResponse.getList().size() > 0
                && cardTransactionGetResponse.getList().get(0) != null && "Recharge".equals(cardTransactionGetResponse.getList().get(0).getTransaction_type())) {
            if ("Success".equals(cardTransactionGetResponse.getList().get(0).getTransaction_status())) {
                tblTrans.setTransStatus(BusTransStatus.SUCCESS.getCode());
                tblTrans.setTransCost(cardTransactionGetResponse.getList().get(0).getMerchant_fee().getTotal_fee_amount());
            } else if ("Failure".equals(cardTransactionGetResponse.getList().get(0).getTransaction_status())) {
                tblTrans.setTransStatus(BusTransStatus.FAIL.getCode());
            }
        }
    }

    @Override
    public List<TblTrans> openCardQuery(TblChannelInfo tblChannelInfo, TblUserOpenCard tblUserOpenCard) {
        CardTransactionGetResponse response = PyvioIssuing.cardTransactionsGetRequest(tblChannelInfo, null,tblUserOpenCard);
        List<TblTrans> list = new ArrayList();
        if (response.getTotal() > 0) {
            response.getList().stream().forEach(info ->{
                if("Success".equals(info.getTransaction_status())) {
                    TblTrans trans = new TblTrans();
                    trans.setTransAmt(info.getTransaction_amount());
                    trans.setTransCurr(info.getTransaction_currency());
                    trans.setTransCost(info.getMerchant_fee().getTotal_fee_amount());
                    if (trans_type.CREATE.equals(info.getTransaction_type())) {
                        trans.setTransType("O");
                        list.add(trans);
                    }else if (trans_type.RECHARGE.equals(info.getTransaction_type())) {
                        trans.setTransType("R");
                        if (StringUtils.isNotBlank(info.getPartner_order_id())
                                && StringUtils.isNotBlank(tblUserOpenCard.getCardId())
                                && info.getPartner_order_id().equals(tblUserOpenCard.getCardId())) {
                            //首充  partner_order_id 和cardId相同
                            list.add(trans);
                        }
                    }
                }
            });
            return list;
        }
        return null;
    }

    @Override
    public boolean cancelCard(TblChannelInfo tblChannelInfo, TblUserOpenCard tblUserOpenCard, TblOperatorCard operatorCard) {
        CardCancelResponse res = PyvioIssuing.cardCancelPostRequest(tblChannelInfo, operatorCard.getID().toString(), tblUserOpenCard.getCardId(), tblUserOpenCard.getCardCurr());
        if (res.isSuccess()) {
            return true;
        }
        return false;
    }


}
