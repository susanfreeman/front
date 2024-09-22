package com.ruoyi.user.service.impl.kun.api.res;

import lombok.Data;

@Data
public class KunRechargeQueryRes {
    private String code;       //"code": "00000000",
    private String message;         //"message": "查询完成",
    private String status;        //"status": "PROCESS",
    private String requestNo;        //"requestNo": "32ampl55equ2es32t2No",
    private String afterAmount;        //"afterAmount": "-"
}
