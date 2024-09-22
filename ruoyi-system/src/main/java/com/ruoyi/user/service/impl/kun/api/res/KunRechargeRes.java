package com.ruoyi.user.service.impl.kun.api.res;

import lombok.Data;

@Data
public class KunRechargeRes {
    private String code;       //"code": "00000000",
    private String message;      //"message": "成功",
    private String status;      //"status": "PROCESSING",
    private String requestNo;      //"requestNo": "21010111567889355676784645676",
    private String afterAmount;      //"afterAmount": "-",
    private String orderId;      //"orderId": "9739970929918897900",
    private String rechargeAmount;      //"rechargeAmount": "30",
    private String rechargeCurrency;      //"rechargeCurrency": "USDT"
}
