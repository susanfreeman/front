package com.ruoyi.user.service.impl.pyvio;

import cn.hutool.core.date.DateTime;
import com.alibaba.fastjson2.JSONObject;
import com.pyvio.openapi.sdk.client.ClientConfig;
import com.pyvio.openapi.sdk.client.Endpoint;
import com.pyvio.openapi.sdk.client.PyvioClient;
import com.pyvio.openapi.sdk.entity.authentication.AccessTokenGetRequest;
import com.pyvio.openapi.sdk.entity.authentication.AccessTokenGetResponse;
import com.pyvio.openapi.sdk.entity.issuing.balance.CardBalanceGetRequest;
import com.pyvio.openapi.sdk.entity.issuing.balance.CardBalanceGetResponse;
import com.pyvio.openapi.sdk.entity.issuing.balance.CardRechargeRequest;
import com.pyvio.openapi.sdk.entity.issuing.balance.CardRechargeResponse;
import com.pyvio.openapi.sdk.entity.issuing.card.*;
import com.pyvio.openapi.sdk.entity.issuing.cardholder.CardholderCreateRequest;
import com.pyvio.openapi.sdk.entity.issuing.cardholder.CardholderCreateResponse;
import com.pyvio.openapi.sdk.entity.issuing.transaction.AuthTransactionsGetRequest;
import com.pyvio.openapi.sdk.entity.issuing.transaction.AuthTransactionsGetResponse;
import com.pyvio.openapi.sdk.entity.issuing.transaction.CardTransactionGetRequest;
import com.pyvio.openapi.sdk.entity.issuing.transaction.CardTransactionGetResponse;
import com.pyvio.openapi.sdk.enums.AuthorizationEnum;
import com.ruoyi.route.domain.TblChannelInfo;
import com.ruoyi.route.domain.TblRouteInfo;
import com.ruoyi.trans.domain.TblTrans;
import com.ruoyi.user.domain.TblUserChannelMapping;
import com.ruoyi.user.domain.TblUserInfo;
import com.ruoyi.user.domain.TblUserOpenCard;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * project RuoYi
 * packageName com.ruoyi.user.service.impl.pyvio
 *
 * @version JDK 8
 * @className PyvioIssuing
 * @date 2024/7/22
 **/
@Slf4j
public class PyvioIssuing {

    /**
     * description: 创建执行引擎 <br>
     * version: 1.0 <br>
     * date: 2024/7/22 23:51 <br>
     *  <br>
     *
     * @Param: endpoint
     * @Param: channelInfo
     *
     * @return com.pyvio.openapi.sdk.client.PyvioClient
     */
    public static PyvioClient getClient(Endpoint endpoint, TblChannelInfo channelInfo){
        ClientConfig clientConfig = new ClientConfig();

        //sandbox
        clientConfig.setAppId(channelInfo.getAppId());
        clientConfig.setAppSecret(channelInfo.getSecretKey());
        clientConfig.setDomainUrl(channelInfo.getCiUri());
        clientConfig.setPrivateKey(channelInfo.getCiPrivateKey());

        clientConfig.setDebug(true);

        PyvioClient pyvioClient = new PyvioClient(clientConfig);
        if(endpoint.isAuthorization()){
            AccessTokenGetRequest tokenRequest = new AccessTokenGetRequest();
            tokenRequest.setApp_id(clientConfig.getAppId());
            tokenRequest.setApp_secret(clientConfig.getAppSecret());
            tokenRequest.setGrant_type(AuthorizationEnum.GrantType.ClientCredentials.getCode());
            AccessTokenGetResponse tokenResponse = pyvioClient.execute(tokenRequest);
            if(!tokenResponse.isSuccess()){
                throw new RuntimeException("Get Access Token Error");
            }
            clientConfig.setAccessToken(tokenResponse.getAccess_token());
        }
        return pyvioClient;
    }


    /**
     * description: 创建持卡人 <br>
     * version: 1.0 <br>
     * date: 2024/7/22 23:52 <br>
     *  <br>
     *
     * @Param: userInfo
     * @Param: channelInfo
     *
     * @return com.pyvio.openapi.sdk.entity.issuing.cardholder.CardholderCreateResponse
     */
    public static CardholderCreateResponse cardholderCreateRequest(TblUserInfo userInfo,TblChannelInfo channelInfo) {
        log.info("------------CardholderCreateRequest---------------");
        PyvioClient client = getClient(Endpoint.CardholderCreate,channelInfo);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        CardholderCreateRequest request = new CardholderCreateRequest();
        request.setPartner_holder_id(userInfo.getUiId()+"");
        request.setCountry_code(userInfo.getCountry());
        request.setMobile_prefix(userInfo.getMobilePrefix());
        request.setMobile(userInfo.getMobile());
        request.setRegion(userInfo.getCountry());
        request.setFirst_name(userInfo.getFirstName());
        request.setLast_name(userInfo.getLastName());
        request.setEmail(userInfo.getEmail());
        request.setBirth_date(sdf.format(userInfo.getBirthday()));
        request.setState(userInfo.getProvince());
        request.setCity(userInfo.getCity());
        request.setAddress(userInfo.getAddress());
        request.setPostcode(userInfo.getPostCode());

        CardholderCreateResponse response = client.execute(request);
        log.info(JSONObject.toJSONString(response));
        log.info("------------CardholderCreateRequest---------------");
        return response;
    }

    /**
     * description: 开卡 <br>
     * version: 1.0 <br>
     * date: 2024/7/22 23:53 <br>
     *  <br>
     *
     * @Param: userInfo
     * @Param: channelInfo
     * @Param: tblRouteInfo
     *
     * @return com.pyvio.openapi.sdk.entity.issuing.card.CardCreateResponse
     */
    public static CardCreateResponse cardCreateRequest(TblUserChannelMapping tblUserChannelMapping,TblUserInfo userInfo, TblChannelInfo channelInfo, TblRouteInfo tblRouteInfo, TblUserOpenCard tblUserOpenCard, String chargeAmt, String cardCurr) {
        log.info("------------CardCreateRequest---------------");
        PyvioClient pyvioClient = getClient(Endpoint.CardCreate,channelInfo);

        CardCreateRequest request = new CardCreateRequest();
        request.setPartner_order_id(tblUserOpenCard.getUocId()+"");
        request.setCard_bin_id(CardHeadEnum.getCardHeadByCardBin(tblRouteInfo.getCardHead()));
        request.setCurrency(cardCurr);
        request.setAccount_currency(cardCurr);
        request.setAmount(new BigDecimal(chargeAmt));
        request.setCard_holder_id(tblUserChannelMapping.getUcmNo());

        CardCreateResponse response = pyvioClient.execute(request);
        log.info(JSONObject.toJSONString(response));
        log.info("------------CardCreateRequest---------------");
        return response;
    }

    /**
     * description: 卡状态查询 <br>
     * version: 1.0 <br>
     * date: 2024/7/22 23:54 <br>
     *  <br>
     *
     *
     * @return com.pyvio.openapi.sdk.entity.issuing.card.CardStatusGetResponse
     */
    public static CardStatusGetResponse cardStatusGetRequest(TblChannelInfo channelInfo,TblUserOpenCard tblUserOpenCard) {
        log.info("------------cardStatusGetRequest---------------");
        PyvioClient pyvioClient = getClient(Endpoint.CardStatusGet,channelInfo);

        CardStatusGetRequest request = new CardStatusGetRequest();
        request.setCard_id(tblUserOpenCard.getCardId());

        CardStatusGetResponse response = pyvioClient.execute(request);
        log.info(JSONObject.toJSONString(response));
        log.info("------------cardStatusGetRequest---------------");
        return response;
    }

    /**
     * description: 卡详情查询 <br>
     * version: 1.0 <br>
     * date: 2024/7/22 23:57 <br>
     *  <br>
     *
     * @Param: channelInfo
     * @Param: tblUserOpenCard
     *
     * @return com.pyvio.openapi.sdk.entity.issuing.card.CardDetailGetResponse
     */
    public static CardDetailGetResponse cardDetailGetRequest(TblChannelInfo channelInfo, TblUserOpenCard tblUserOpenCard) {
        log.info("------------CardDetailGetRequest---------------");
        PyvioClient pyvioClient = getClient(Endpoint.CardDetailGet,channelInfo);

        CardDetailGetRequest request = new CardDetailGetRequest();
        request.setCard_id(tblUserOpenCard.getCardId());

        CardDetailGetResponse response = pyvioClient.execute(request);
        log.info(JSONObject.toJSONString(response));
        log.info("------------cardStatusGetRequest---------------");
        return response;
    }


    public static CardBalanceGetResponse cardBalanceGetRequest(TblChannelInfo channelInfo, TblUserOpenCard tblUserOpenCard) {
        log.info("------------cardBalanceGetRequest---------------");
        PyvioClient pyvioClient = getClient(Endpoint.CardBalanceGet,channelInfo);

        CardBalanceGetRequest request = new CardBalanceGetRequest();
        request.setCard_id(tblUserOpenCard.getCardId());

        CardBalanceGetResponse response = pyvioClient.execute(request);
        log.info(JSONObject.toJSONString(response));
        log.info("------------cardBalanceGetRequest---------------");
        return response;
    }

    public static CardRechargeResponse cardRechargeRequest(TblChannelInfo channelInfo, TblUserOpenCard tblUserOpenCard,String chargeAmt,String cardCurr,String transId) {
        log.info("------------cardRechargeRequest---------------");
        PyvioClient pyvioClient = getClient(Endpoint.CardRecharge,channelInfo);

        CardRechargeRequest request = new CardRechargeRequest();
        request.setPartner_order_id(transId);
        request.setCard_id(tblUserOpenCard.getCardId());
        request.setAmount(new BigDecimal(chargeAmt));
        request.setAccount_currency(cardCurr);

        CardRechargeResponse response = pyvioClient.execute(request);
        log.info(JSONObject.toJSONString(response));
        log.info("------------cardRechargeRequest---------------");
        return response;
    }

    public static CardTransactionGetResponse cardTransactionsGetRequest(TblChannelInfo channelInfo, TblTrans tblTrans,TblUserOpenCard tblUserOpenCard) {
        log.info("------------testCardTransactionsGetRequest---------------");
        PyvioClient pyvioClient = getClient(Endpoint.CardTransactionsGet,channelInfo);

        CardTransactionGetRequest request = new CardTransactionGetRequest();

        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        if (tblTrans != null && tblTrans.getTtId()!=0) {
            request.setPartner_order_id(tblTrans.getTtId()+"");
            if( tblTrans.getTransTime()!=null){
                instance.setTime(tblTrans.getTransTime());
            }
        }
        if (tblUserOpenCard != null && StringUtils.isNotBlank(tblUserOpenCard.getCardId())) {
            request.setCard_id(tblUserOpenCard.getCardId());
            if( tblUserOpenCard.getTransTime()!=null){
                instance.setTime(tblUserOpenCard.getTransTime());
            }
        }

        instance.add(Calendar.DATE,-1);
        Date startTime = instance.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        request.setBegin_time(dateFormat.format(startTime));

        instance.add(Calendar.DATE,2);
        Date endTime = instance.getTime();
        request.setEnd_time(dateFormat.format(endTime));

        CardTransactionGetResponse response = (CardTransactionGetResponse)pyvioClient.execute(request);
        log.info(JSONObject.toJSONString(response));
        log.info("------------testCardTransactionsGetRequest---------------");
        return response;
    }

    public static CardCancelResponse cardCancelPostRequest(TblChannelInfo channelInfo,String platformId , String cardId, String currency) {
        log.info("------------CancelCardPostRequest begin---------------");
        PyvioClient pyvioClient = getClient(Endpoint.CardCancel,channelInfo);
        CardCancelRequest request = new CardCancelRequest();
        request.setPartner_order_id(platformId);
        request.setCard_id(cardId);
        request.setAccount_currency(currency);
        CardCancelResponse response = pyvioClient.execute(request);
        log.info(JSONObject.toJSONString(response));
        log.info("------------CancelCardPostRequest end---------------");
        return response;
    }


    public static AuthTransactionsGetResponse authTransactionsGetRequest(TblChannelInfo channelInfo, String cardNo, Integer pageNum, Integer pageSize, String beginTime, String endTime) {
        log.info("------------AuthTransactionsGetRequest begin---------------");
        PyvioClient pyvioClient = getClient(Endpoint.CardTransactionsGet,channelInfo);
        AuthTransactionsGetRequest request = new AuthTransactionsGetRequest();
        request.setCard_id(cardNo);
        request.setPage_no(pageNum);
        request.setPage_size(pageSize);
        request.setBegin_time(beginTime);
        request.setEnd_time(endTime);
        AuthTransactionsGetResponse response = (AuthTransactionsGetResponse) pyvioClient.execute(request);
        log.info(JSONObject.toJSONString(response));
        log.info("------------AuthTransactionsGetRequest end---------------");
        return response;
    }

}
