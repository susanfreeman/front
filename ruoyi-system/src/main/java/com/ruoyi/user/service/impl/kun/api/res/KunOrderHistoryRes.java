package com.ruoyi.user.service.impl.kun.api.res;

import lombok.Data;

import java.util.List;

@Data
public class KunOrderHistoryRes {
    private String code;     //"code": "00000000",
    private String message; //"message": "查询完成",
    private String pageNo;  //"pageNo": "1",
    private String pageSize;   //"pageSize": "10",
    private String totalPage;    //"totalPage": "1",
    private List<resData> data;  //"data":

    @Data
    public static class resData {
        private String orderId;     //"orderId": "******",
        private String cardId;    //"cardId": "******",
        private String cardNo;    //"cardNo": "**** **** **** 0235",
        private String transactionAmount;    //"transactionAmount": "20.000000",
        private String transactionCurrency;    //"transactionCurrency": "HKD",
        private String billAmount;    //"billAmount": "20.000000",
        private String billReversalAmount;    //"billReversalAmount": "10.000000",
        private String clearAmount;    //"clearAmount": "0.000000",
        private String feeAmount;    //"feeAmount": "0.000000",
        private String cardCurrency;    //"cardCurrency": "HKD",
        private String status;    //"status": "PENDING",
        private String createTransactionDate;    //"createTransactionDate": "2024-06-06T16:27:34.000Z",
        private String tradeDate;    //"tradeDate": "2024-06-06T16:27:34.000Z",
        private String merchantNameLocation;    //"merchantNameLocation": "Reap",
        private String merchantCategoryCode;    //"merchantCategoryCode": "5732"
    }
}

