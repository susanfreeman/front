package com.ruoyi.user.service.impl.kun.api.res;

import lombok.Data;

@Data
public class KunAesKeyRes {
    private String code;      //"code": "00000000",
    private String message;      //"message": "查询成功",
    private String aesKey;     //"aesKey": "b564a32c540899a8990986ebf0e982cd"
}
