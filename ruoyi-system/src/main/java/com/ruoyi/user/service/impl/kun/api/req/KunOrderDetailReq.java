package com.ruoyi.user.service.impl.kun.api.req;

import lombok.Data;

@Data
public class KunOrderDetailReq {
    private String customerId;//必填
    private String requestNo;//必填
    private String orderId;//必填
    private String createTransactionDate;//必填 示例值：2024-06-06T00:08:02.000Z
}

