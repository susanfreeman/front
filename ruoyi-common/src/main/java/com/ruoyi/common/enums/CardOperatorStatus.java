package com.ruoyi.common.enums;
public enum CardOperatorStatus {
    SUCCESS("SUCCESS", "成功"),
    FAIL("FAIL", "失败"),
    INIT("INIT", "初始化"),
    CANCEL("CANCEL", "销卡");
    private final String code;
    private final String description;

    CardOperatorStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
