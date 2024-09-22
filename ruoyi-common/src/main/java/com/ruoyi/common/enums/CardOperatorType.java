package com.ruoyi.common.enums;
public enum CardOperatorType {
    FZ("FZ", "冻结"),
    UFZ("UFZ", "解冻"),
    CLO("CLO", "销卡");
    private final String code;
    private final String description;

    CardOperatorType(String code, String description) {
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
