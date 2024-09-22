package com.ruoyi.user.service.impl.kun;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.ruoyi.route.domain.TblChannelInfo;
import com.ruoyi.user.service.impl.kun.api.req.KunOrderHistoryReq;
import global.kun.shade.com.google.common.collect.Maps;
import global.kun.shade.yop.sdk.service.common.YopClient;
import global.kun.shade.yop.sdk.service.common.YopClientBuilder;
import global.kun.shade.yop.sdk.service.common.request.YopRequest;
import global.kun.shade.yop.sdk.service.common.response.YopResponse;

import java.util.Map;

public class KunTest {
    public static final YopClient yopClient = YopClientBuilder.builder().build();
    public static final String OUT_USER_ID = "1";
    public static final String OUT_USER_NAME = "test";
    public static final String PHONE = "15876545678";
    public static final String EMAIL = "15876545678@qq.com";
    public static final String CARD_ID = "1047463874056716288";
    //开卡
    public static void main(String[] args) {
//        openCard();
//        queryOpenCard();
//        queryCardInfo();
//        {code=00000000, message=成功, cardId=1047463874056716288, cardNo=/M29cfwkAY2q1eX3oM4jpioNWXYTbkm9ijDJyYe4H1Q=, cardNoMask=**** **** **** 4889, cvv=Vy85evS21nB8rS5yxfhnJA==, expiryDate=09/27, balance=5.00000000000000000000, cardStatus=ACTIVE}
//        queryCardKeyInfo();
        //这个密钥是永久的 可以直接存在数据库里 不用每次查询
//        {code=00000000, message=查询成功, aesKey=b564a32c540875a8930986ebf0e182ad}
//        AES aes = SecureUtil.aes("b564a32c540875a8930986ebf0e182ad".getBytes());
//        System.out.println(new String(aes.decrypt("/M29cfwkAY2q1eX3oM4jpioNWXYTbkm9ijDJyYe4H1Q=")));
//        System.out.println(new String(aes.decrypt("Vy85evS21nB8rS5yxfhnJA==")));
//        recharge();
//        {code=00000000, message=成功, status=PROCESSING, requestNo=1832038644161167360, orderId=1047553690412810240, rechargeAmount=20, rechargeCurrency=HKD}
//        rechargeQuery();
//        {code=00000000, message=查询完成, status=SUCCESS, requestNo=1832038644161167360, afterAmount=25.00000000000000000000}

        orderHistory();
    }

    public static void openCard(){
        YopRequest yopRequest = new YopRequest("/rest/v1.0/card/open", "POST");
        Map<String, Object> map = Maps.newHashMap();
        map.put("customerId", "957775851585191936");
        map.put("requestNo", IdUtil.getSnowflakeNextIdStr());
        map.put("outUserId", OUT_USER_ID);
        map.put("outUserName", OUT_USER_NAME);
        map.put("openAmount", "20");
        map.put("openCurrency", "USDT");
        map.put("ip", "127.0.0.1");
        Map<String, Object> meta = Maps.newHashMap();
        meta.put("dialCode", "86");
        meta.put("phone", PHONE);
        meta.put("email", EMAIL);
        map.put("meta", meta);
        String json = JSONUtil.toJsonStr(map);
        yopRequest.setContent(json);
        YopResponse response = yopClient.request(yopRequest);
        System.out.println("-------------------------------");
        System.out.println(response.getResult());
//        返回 {code=00000000, message=成功, status=PROCESSING, requestNo=1831226375089029120, cardId=1040899617840062464, openAmount=50, openCurrency=USDT}
//        {code=00000000, message=成功, status=PROCESSING, requestNo=1831298472465289216, cardId=1041490227382878208, openAmount=50, openCurrency=USDT}
//        {code=00000000, message=成功, status=PROCESSING, requestNo=1831667025391587328, cardId=1044509417593274368, openAmount=20, openCurrency=USDT}
    }

    public static void queryOpenCard(){
        YopRequest yopRequest = new YopRequest("/rest/v1.0/card/open-query", "POST");
        Map<String, Object> map = Maps.newHashMap();
        map.put("customerId", "957775851585191936");
        map.put("requestNo", "46");
        String json = JSONUtil.toJsonStr(map);
        yopRequest.setContent(json);
        YopResponse response = yopClient.request(yopRequest);
        System.out.println("-------------------------------");
        System.out.println(response.getStringResult());
//        返回 {code=00000000, message=商户开卡余额不足,开卡失败, status=FAIL, requestNo=1831226375089029120, cardId=1040899617840062464}
    }

    public static void queryCardInfo(){
        YopRequest yopRequest = new YopRequest("/rest/v1.0/card/pin-query", "POST");
        Map<String, Object> map = Maps.newHashMap();
        map.put("cardId", "1047463874056716288");
        map.put("customerId", "957775851585191936");
        map.put("requestNo", IdUtil.getSnowflakeNextIdStr());
        String json = JSONUtil.toJsonStr(map);
        yopRequest.setContent(json);
        YopResponse response = yopClient.request(yopRequest);
        System.out.println("-------------------------------");
        System.out.println(response.getResult());
//        返回 {code=CD300003, message=card is not exist!}
    }

    public static void queryCardKeyInfo(){
        YopRequest yopRequest = new YopRequest("/rest/v1.0/card/aes-query", "POST");
        Map<String, Object> map = Maps.newHashMap();
        map.put("requestNo", IdUtil.getSnowflakeNextIdStr());
        String json = JSONUtil.toJsonStr(map);
        yopRequest.setContent(json);
        YopResponse response = yopClient.request(yopRequest);
        System.out.println("-------------------------------");
        System.out.println(response.getResult());
//        返回 {code=00000000, message=查询成功, aesKey=b564a32c540875a8930986ebf0e182ad}
    }

    public static void recharge(){
        YopRequest yopRequest = new YopRequest("/rest/v1.0/card/recharge", "POST");
        Map<String, Object> map = Maps.newHashMap();
        map.put("cardId", "1047463874056716288");
        map.put("amount", "20");
//        map.put("currency", "USDT");
        map.put("currency", "HKD");
        map.put("ip", "127.0.0.1");
        map.put("customerId", "957775851585191936");
        map.put("requestNo", IdUtil.getSnowflakeNextIdStr());
        String json = JSONUtil.toJsonStr(map);
        yopRequest.setContent(json);
        YopResponse response = yopClient.request(yopRequest);
        System.out.println("-------------------------------");
        System.out.println(response.getResult());
//        返回 {code=CD399999, message=充值失败，卡不存在或卡状态异常, rechargeAmount=1, rechargeCurrency=USDT}
    }

    public static void rechargeQuery(){
        YopRequest yopRequest = new YopRequest("/rest/v1.0/card/recharge-query", "POST");
        Map<String, Object> map = Maps.newHashMap();
        map.put("customerId", "957775851585191936");
        map.put("requestNo", "1832038644161167360");
        String json = JSONUtil.toJsonStr(map);
        yopRequest.setContent(json);
        YopResponse response = yopClient.request(yopRequest);
        System.out.println("-------------------------------");
        System.out.println(response.getResult());
//        返回 {code=CD300003, message=订单不存在, requestNo=1831228619498889216}
    }

    public static void orderHistory() {
        YopRequest yopRequest = new YopRequest("/rest/v1.0/card/order-history", "POST");
        KunOrderHistoryReq req = new KunOrderHistoryReq();
        req.setCustomerId("957775851585191936");
        req.setRequestNo(IdUtil.getSnowflakeNextIdStr());
        req.setTransactionStartTime("2024-01-01T00:00:00Z");
        req.setTransactionEndTime("2024-09-15T23:59:59Z");
        String json = JSONUtil.toJsonStr(req);
        yopRequest.setContent(json);
        YopResponse response = yopClient.request(yopRequest);
        System.out.println("-------------------------------");
        System.out.println(response.getResult());
    }
}
