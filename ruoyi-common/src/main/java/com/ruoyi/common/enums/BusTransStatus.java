package com.ruoyi.common.enums;

/**
 * description: BusTransStatus <br>
 * date: 2024/7/22 23:45 <br>
 *
 *  <br>
 * @version: 1.0 <br>
 */
public enum BusTransStatus {
    INIT("0", "初始化"), PROCESS("1", "处理中"), SUCCESS("2", "成功"),FAIL("3","失败"),BATCH_PROCESS("4","批处理中"),CANCEL("5","已注销");

    private final String code;
    private final String info;

    BusTransStatus(String code, String info)
    {
        this.code = code;
        this.info = info;
    }

    public String getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }
}
