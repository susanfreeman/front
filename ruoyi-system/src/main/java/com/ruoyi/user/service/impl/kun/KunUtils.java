package com.ruoyi.user.service.impl.kun;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.ruoyi.route.domain.TblChannelInfo;
import com.ruoyi.trans.domain.TblTrans;
import com.ruoyi.user.domain.TblUserInfo;
import com.ruoyi.user.domain.TblUserOpenCard;
import com.ruoyi.user.service.impl.kun.api.req.*;
import global.kun.shade.yop.sdk.service.common.YopClient;
import global.kun.shade.yop.sdk.service.common.YopClientBuilder;
import global.kun.shade.yop.sdk.service.common.request.YopRequest;
import global.kun.shade.yop.sdk.service.common.response.YopResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KunUtils {

    public static final YopClient yopClient = YopClientBuilder.builder().build();


    public static String openCard(TblUserInfo userInfo, TblChannelInfo channelInfo, String platformId, String ip, String chargeAmt, String cardCurr) {
        KunOpenCardReq req = new KunOpenCardReq();
        KunOpenCardReq.Meta meta = new KunOpenCardReq.Meta();
        req.setCustomerId(channelInfo.getAppId());
        req.setRequestNo(platformId);
        req.setOutUserId(StrUtil.toString(userInfo.getUserId()));
        req.setOutUserName(userInfo.getFirstName() + userInfo.getLastName());
        req.setOpenAmount(chargeAmt);
        req.setOpenCurrency(cardCurr);
        req.setIp(ip);
        meta.setDialCode(userInfo.getMobilePrefix());
        meta.setPhone(userInfo.getMobile());
        meta.setEmail(userInfo.getEmail());
        req.setMeta(meta);
        String json = JSONUtil.toJsonStr(req);
        return KunUtils.doReq("/rest/v1.0/card/open", "POST", json);
    }

    public static String openCardQuery(TblChannelInfo channelInfo, String platformId) {
        KunOpenCardQueryReq req = new KunOpenCardQueryReq();
        req.setCustomerId(channelInfo.getAppId());
        req.setRequestNo(platformId);
        String json = JSONUtil.toJsonStr(req);
        return KunUtils.doReq("/rest/v1.0/card/open-query", "POST", json);
    }

    public static String cardInfoQuery(TblChannelInfo channelInfo, TblUserOpenCard tblUserOpenCard) {
        KunCardInfoReq req = new KunCardInfoReq();
        req.setCustomerId(channelInfo.getAppId());
        req.setCardId(tblUserOpenCard.getCardId());
        req.setRequestNo(IdUtil.getSnowflakeNextIdStr());
        String json = JSONUtil.toJsonStr(req);
        return KunUtils.doReq("/rest/v1.0/card/pin-query", "POST", json);
    }

    public static String AesKeyQuery(TblChannelInfo channelInfo) {
        KunAesKeyReq req = new KunAesKeyReq();
        req.setRequestNo(IdUtil.getSnowflakeNextIdStr());
        String json = JSONUtil.toJsonStr(req);
        return KunUtils.doReq("/rest/v1.0/card/aes-query", "POST", json);
    }


    public static String recharge(TblChannelInfo channelInfo, TblUserOpenCard tblUserOpenCard, String chargeAmt, String cardCurr, String platformId, String ip) {
        KunRechargeReq req = new KunRechargeReq();
        req.setCardId(tblUserOpenCard.getCardId());
        req.setAmount(chargeAmt);
        req.setCurrency(cardCurr);
        req.setIp(ip);
        req.setCustomerId(channelInfo.getAppId());
        req.setRequestNo(platformId);
        String json = JSONUtil.toJsonStr(req);
        return KunUtils.doReq("/rest/v1.0/card/recharge", "POST", json);
    }

    public static String rechargeQuery(TblChannelInfo channelInfo, String platformId) {
        KunRechargeQueryReq req = new KunRechargeQueryReq();
        req.setCustomerId(channelInfo.getAppId());
        req.setRequestNo(platformId);
        String json = JSONUtil.toJsonStr(req);
        return KunUtils.doReq("/rest/v1.0/card/recharge-query", "POST", json);
    }

    public static String destroy(TblChannelInfo channelInfo, TblUserOpenCard tblUserOpenCard, String platformId) {
        KunDestroyReq req = new KunDestroyReq();
        req.setCustomerId(channelInfo.getAppId());
        req.setRequestNo(platformId);
        req.setCardId(tblUserOpenCard.getCardId());
        String json = JSONUtil.toJsonStr(req);
        return KunUtils.doReq("/rest/v1.0/card/destroy", "POST", json);
    }


    public static String orderHistory(TblChannelInfo channelInfo, String platformId, String startTime, String endTime) {
        KunOrderHistoryReq req = new KunOrderHistoryReq();
        req.setCustomerId(channelInfo.getAppId());
        req.setRequestNo(platformId);
        req.setTransactionStartTime(startTime);
        req.setTransactionEndTime(endTime);
        String json = JSONUtil.toJsonStr(req);
        return KunUtils.doReq("/rest/v1.0/card/order-history", "POST", json);
    }


    public static String OrderDetail(TblChannelInfo channelInfo, TblTrans tblTrans, String platformId) {
        KunOrderDetailReq req = new KunOrderDetailReq();
        req.setCustomerId(channelInfo.getAppId());
        req.setRequestNo(platformId);
        req.setOrderId(StrUtil.toString(tblTrans.getTtId()));
//        req.setCreateTransactionDate(DateTime.of(tblTrans.getTransTime(), DatePattern.PURE_DATETIME_MS_PATTERN));
        String json = JSONUtil.toJsonStr(req);
        return KunUtils.doReq("/rest/v1.0/card/order-detail", "POST", json);
    }

    private static String doReq(String uri, String method, String json) {
        YopRequest yopRequest = new YopRequest(uri, method);
        yopRequest.setContent(json);
        YopResponse res = yopClient.request(yopRequest);
        return res.getStringResult();
    }
}
