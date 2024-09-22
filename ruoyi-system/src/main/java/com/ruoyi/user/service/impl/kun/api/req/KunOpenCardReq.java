package com.ruoyi.user.service.impl.kun.api.req;

import lombok.Data;

@Data
public class KunOpenCardReq {
    private String customerId;//商户编号
    private String requestNo;//请求
    private String outUserId;//外部用户ID
    private String outUserName;//外部用户名称
    private String openAmount;//开卡金额
    private String openCurrency;//开卡币种
    private String ip;//IP
    private Meta meta;

    @Data
    public static class Meta {
        private String dialCode;//手机区号
        private String phone;//手机号
        private String email;//邮箱
    }
}
