package com.ruoyi.user.service.impl.pyvio;

import com.alibaba.fastjson2.JSONObject;
import com.pyvio.openapi.sdk.client.Endpoint;
import com.pyvio.openapi.sdk.client.PyvioClient;
import com.pyvio.openapi.sdk.entity.issuing.cardholder.CardholderCreateRequest;
import com.pyvio.openapi.sdk.entity.issuing.cardholder.CardholderCreateResponse;
import com.pyvio.openapi.sdk.entity.issuing.cardholder.CardholderGetRequest;
import com.pyvio.openapi.sdk.entity.issuing.cardholder.CardholderGetResponse;
import com.pyvio.openapi.sdk.entity.issuing.transaction.CardTransactionGetRequest;
import com.pyvio.openapi.sdk.entity.issuing.transaction.CardTransactionGetResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class IssuingTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    
    public static void testCardholderCreateRequest() {
        log.info("------------testCardholderCreateRequest---------------");
        PyvioClient pyvioClient = getClient(Endpoint.CardholderCreate);

        CardholderCreateRequest request = new CardholderCreateRequest();
        request.setPartner_holder_id("ch" + System.currentTimeMillis());
        request.setCountry_code("USA");
        request.setMobile_prefix("+1");
        request.setMobile("1889999");
        request.setRegion("USA");
        request.setFirst_name("first name");
        request.setLast_name("last name");
        request.setEmail("email@mail.com");
        request.setBirth_date("2000-01-01");
        request.setState("state");
        request.setCity("city");
        request.setAddress("address");
        request.setPostcode("12345");

        CardholderCreateResponse response = pyvioClient.execute(request);
        System.out.println(JSONObject.toJSONString(response));
        log.info("------------testCardholderCreateRequest---------------");
    }

    
    public void testCardholderGetRequest() {
        log.info("------------testCardholderGetRequest---------------");
        PyvioClient pyvioClient = getClient(Endpoint.CardholderGet);

        CardholderGetRequest request = new CardholderGetRequest();
        request.setCard_holder_id("CA2404231777613946289986839");

        CardholderGetResponse response = pyvioClient.execute(request);
        System.out.println(JSONObject.toJSONString(response));
        log.info("------------testCardholderGetRequest---------------");
    }

    
//    public void testCardCreateRequest() {
//        log.info("------------testCardCreateRequest---------------");
//        PyvioClient pyvioClient = getClient(Endpoint.CardCreate);
//
//        CardCreateRequest request = new CardCreateRequest();
//        request.setPartner_order_id("ca" + System.currentTimeMillis());
//        request.setCard_bin_id("100007");
//        request.setCurrency("USD");
//        request.setAccount_currency("EUR");
//        request.setAmount(BigDecimal.valueOf(5));
//
//        CardCreateResponse response = pyvioClient.execute(request);
//        System.out.println(JSONObject.toJSONString(response));
//        log.info("------------testCardCreateRequest---------------");
//    }
//
//
//    public void testCardStatusGetRequest() {
//        log.info("------------testCardStatusGetRequest---------------");
//        PyvioClient pyvioClient = getClient(Endpoint.CardStatusGet);
//
//        CardStatusGetRequest request = new CardStatusGetRequest();
//        request.setCard_id("C1802600709590782523");
//
//        CardStatusGetResponse response = pyvioClient.execute(request);
//        System.out.println(JSONObject.toJSONString(response));
//        log.info("------------testCardStatusGetRequest---------------");
//    }
//
//
//    public void testCardDetailGetRequest() {
//        log.info("------------testCardDetailGetRequest---------------");
//        PyvioClient pyvioClient = getClient(Endpoint.CardDetailGet);
//
//        CardDetailGetRequest request = new CardDetailGetRequest();
//        request.setCard_id("C1802600709590782525");
//
//        CardDetailGetResponse response = pyvioClient.execute(request);
//        System.out.println(JSONObject.toJSONString(response));
//        log.info("------------testCardStatusGetRequest---------------");
//    }
//
//
//    public void testCardBalanceGetRequest() {
//        log.info("------------testCardBalanceGetRequest---------------");
//        PyvioClient pyvioClient = getClient(Endpoint.CardBalanceGet);
//
//        CardBalanceGetRequest request = new CardBalanceGetRequest();
//        request.setCard_id("C1802600709590782525");
//
//        CardBalanceGetResponse response = pyvioClient.execute(request);
//        System.out.println(JSONObject.toJSONString(response));
//        log.info("------------testCardBalanceGetRequest---------------");
//    }
//
//
//    public void testCardRechargeRequest() {
//        log.info("------------testCardRechargeRequest---------------");
//        PyvioClient pyvioClient = getClient(Endpoint.CardRecharge);
//
//        CardRechargeRequest request = new CardRechargeRequest();
//        request.setPartner_order_id("cr" + System.currentTimeMillis());
//        request.setCard_id("C1787421270269145350");
//        request.setAmount(BigDecimal.valueOf(12));
//        request.setAccount_currency("USD");
//
//        CardRechargeResponse response = pyvioClient.execute(request);
//        System.out.println(JSONObject.toJSONString(response));
//        log.info("------------testCardRechargeRequest---------------");
//    }
//
//
//    public void testCardWithdrawRequest() {
//        log.info("------------testCardWithdrawRequest---------------");
//        PyvioClient pyvioClient = getClient(Endpoint.CardWithdraw);
//
//        CardWithdrawRequest request = new CardWithdrawRequest();
//        request.setPartner_order_id("cr" + System.currentTimeMillis());
//        request.setCard_id("C1787421270269145350");
//        request.setAmount(BigDecimal.valueOf(10));
//        request.setAccount_currency("USD");
//
//        CardWithdrawResponse response = pyvioClient.execute(request);
//        System.out.println(JSONObject.toJSONString(response));
//        log.info("------------testCardWithdrawRequest---------------");
//    }
//
//
//    public void testCardCancelRequest() {
//        log.info("------------testCardCancelRequest---------------");
//        PyvioClient pyvioClient = getClient(Endpoint.CardCancel);
//
//        CardCancelRequest request = new CardCancelRequest();
//        request.setPartner_order_id("cr" + System.currentTimeMillis());
//        request.setCard_id("C1787387173408449286");
//        request.setAccount_currency("USD");
//
//        CardCancelResponse response = pyvioClient.execute(request);
//        System.out.println(JSONObject.toJSONString(response));
//        log.info("------------testCardCancelRequest---------------");
//    }
//
//
//    public void testAuthTransactionsGetRequest() {
//        log.info("------------testAuthTransactionsGetRequest---------------");
//        PyvioClient pyvioClient = getClient(Endpoint.AuthTransactionsGet);
//
//        AuthTransactionsGetRequest request = new AuthTransactionsGetRequest();
//        request.setCard_id("C1787370452431837512");
//        request.setPage_no(1);
//        request.setPage_size(20);
//        request.setBegin_time("2024-01-01 00:00:00");
//        request.setEnd_time("2024-06-01 00:00:00");
//
//        AuthTransactionsGetResponse response = (AuthTransactionsGetResponse)pyvioClient.execute(request);
//        System.out.println(JSONObject.toJSONString(response));
//        log.info("------------testAuthTransactionsGetRequest---------------");
//    }
//
//
//    public void testSettlementGetRequest() {
//        log.info("------------testSettlementGetRequest---------------");
//        PyvioClient pyvioClient = getClient(Endpoint.SettlementGet);
//
//        SettlementGetRequest request = new SettlementGetRequest();
////        request.setCard_id("C1787370452431837512");
//        request.setPage_no(1);
//        request.setPage_size(20);
//        request.setBegin_time("2024-01-01 00:00:00");
//        request.setEnd_time("2024-06-01 00:00:00");
//
//        SettlementGetResponse response = (SettlementGetResponse)pyvioClient.execute(request);
//        System.out.println(JSONObject.toJSONString(response));
//        log.info("------------testSettlementGetRequest---------------");
//    }
//
//
    public void testCardTransactionsGetRequest() {
        log.info("------------testCardTransactionsGetRequest---------------");
        PyvioClient pyvioClient = getClient(Endpoint.CardTransactionsGet);

        CardTransactionGetRequest request = new CardTransactionGetRequest();
        request.setPartner_order_id("");
//        request.setCard_id("C1787421270269145350");
//        request.setTransaction_type("Withdraw");
//        request.setPage_no(1);
//        request.setPage_size(200);
//        request.setBegin_time("2024-01-01 00:00:00");
//        request.setEnd_time("2024-06-01 00:00:00");

        CardTransactionGetResponse response = (CardTransactionGetResponse)pyvioClient.execute(request);
        System.out.println(JSONObject.toJSONString(response));
        log.info("------------testCardTransactionsGetRequest---------------");
    }

    public static void main(String[] args) {
        testCardholderCreateRequest();
    }
}
