package com.ruoyi.user.service.impl.kun.api.res;

import lombok.Data;

@Data
public class KunOpenCardRes {
    private String code;        //"code": "00000000",
    private String message;      //"message": "成功",
    private String status;      //"status": "PROCESSING",
    private String requestNo;     //"requestNo": "22234044351222222-4803",
    private String cardId;      //"cardId": "773999089999670528",
    private String openAmount;      //"openAmount": "3000",
    private String openCurrency;      //"openCurrency": "USDT"
}
