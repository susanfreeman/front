package com.ruoyi.user.service.impl.kun.api.req;

import lombok.Data;

@Data
public class KunOrderHistoryReq {
    private String customerId;//必填
    private String requestNo;//必填
    private String transactionStartTime;//必填  2024-05-01T01:01:01Z
    private String transactionEndTime;//必填  2024-05-01T01:01:01Z
    private String cardId;
    private String pageNo;
    private String pageSize;
}

