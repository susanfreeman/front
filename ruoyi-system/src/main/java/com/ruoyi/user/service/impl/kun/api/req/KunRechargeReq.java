package com.ruoyi.user.service.impl.kun.api.req;

import lombok.Data;

@Data
public class KunRechargeReq {
    private String cardId;
    private String amount;
    private String currency;
    private String ip;
    private String customerId;
    private String requestNo;
}
