package com.ruoyi.user.service.impl.kun.api.res;

import lombok.Data;

import java.util.List;

@Data
public class KunOrderDetailRes {
    private String code;     //"code": "00000000",
    private String message;   //"message": "成功",
    private String customerId;   //"customerId": "202311162099781601",
    private String cardId;   //"cardId": "87136032812318240",
    private String cardNo;   //"cardNo": "**** **** **** 5211",
    private String orderId;   //"orderId": "1799074314523919041",
    private List<resData> data;   //"data":

    @Data
    public static class resData {
        private String subOrderId;   //"subOrderId": "711873758993243904",
        private String transactionAmount;  //"transactionAmount": "23.000000",
        private String transactionCurrency;  //"transactionCurrency": "HKD",
        private String billingAmount;  //"billingAmount": "23.000000",
        private String billingCurrency;  //"billingCurrency": "HKD",
        private String movingAmount;  //"movingAmount": "23.000000",
        private String movingCurrency;  //"movingCurrency": "HKD",
        private String orderType;  //"orderType": "AUTHORIZATION",
        private String createTransactionDate;  //"createTransactionDate": "2024-06-06T00:08:02.000Z",
        private String tradeTime;  //"tradeTime": "2024-06-06T00:08:02.000Z",
        private String feeAmount;  //"feeAmount": "0.000000",
        private String feeCurrency;  //"feeCurrency": "HKD",
        private String accountStatus;  //"accountStatus": "FINISH",
        private String affectMerBalance;  //"affectMerBalance": "0",
        private String channelCode;  //"channelCode": "SUN_VCC",
        private String channelNotifyType;  //"channelNotifyType": "CLEAR_LATER",
        private String merchantName;  //"merchantName": "Reap",
        private String merchantCity;  //"merchantCity": "www.reap.global",
        private String merchantCountry;  //"merchantCountry": "HKG",
        private String mccCode;  //"mccCode": "1232",
        private String mccCategory;  //"mccCategory": "Electronics Stores"
    }
}

