package com.ruoyi.notify.balOperate.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资金变动通知对象 tbl_notify_balance_operate
 * 
 * @author ruoyi
 * @date 2024-08-15
 */
public class TblNotifyBalanceOperate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表id */
    private Long id;

    /** 渠道编号 */
    @Excel(name = "渠道编号")
    private String channelNo;

    /** 平台订单号 */
    @Excel(name = "平台订单号")
    private String platformId;

    /** 渠道订单号 */
    @Excel(name = "渠道订单号")
    private String channelTransId;

    /** 卡号 */
    @Excel(name = "卡号")
    private String cardNo;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 渠道返状态码 */
    @Excel(name = "渠道返状态码")
    private String channelRespStatus;

    /** 渠道返回描述 */
    @Excel(name = "渠道返回描述")
    private String channelRespMsg;

    /** 金额操作类型 card_id：卡的金额增加；card_out：卡的金额减少。 */
    @Excel(name = "金额操作类型 card_id：卡的金额增加；card_out：卡的金额减少。")
    private String operateType;

    /** 币种 */
    @Excel(name = "币种")
    private String currency;

    /** 手续费 */
    @Excel(name = "手续费")
    private BigDecimal channelFee;

    /** 渠道返回日期 */
    @Excel(name = "渠道返回日期")
    private String respDate;

    /** 渠道返回时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "渠道返回时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date respTime;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 备用字段 */
    @Excel(name = "备用字段")
    private String rsv1;

    /** 备用字段 */
    @Excel(name = "备用字段")
    private String rsv2;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setChannelNo(String channelNo)
    {
        this.channelNo = channelNo;
    }

    public String getChannelNo()
    {
        return channelNo;
    }

    public void setPlatformId(String platformId) 
    {
        this.platformId = platformId;
    }

    public String getPlatformId() 
    {
        return platformId;
    }

    public void setChannelTransId(String channelTransId) 
    {
        this.channelTransId = channelTransId;
    }

    public String getChannelTransId() 
    {
        return channelTransId;
    }

    public void setCardNo(String cardNo) 
    {
        this.cardNo = cardNo;
    }

    public String getCardNo() 
    {
        return cardNo;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setChannelRespStatus(String channelRespStatus) 
    {
        this.channelRespStatus = channelRespStatus;
    }

    public String getChannelRespStatus() 
    {
        return channelRespStatus;
    }

    public void setChannelRespMsg(String channelRespMsg) 
    {
        this.channelRespMsg = channelRespMsg;
    }

    public String getChannelRespMsg() 
    {
        return channelRespMsg;
    }

    public void setOperateType(String operateType) 
    {
        this.operateType = operateType;
    }

    public String getOperateType() 
    {
        return operateType;
    }

    public void setCurrency(String currency) 
    {
        this.currency = currency;
    }

    public String getCurrency() 
    {
        return currency;
    }

    public void setChannelFee(BigDecimal channelFee) 
    {
        this.channelFee = channelFee;
    }

    public BigDecimal getChannelFee() 
    {
        return channelFee;
    }

    public void setRespDate(String respDate) 
    {
        this.respDate = respDate;
    }

    public String getRespDate() 
    {
        return respDate;
    }

    public void setRespTime(Date respTime) 
    {
        this.respTime = respTime;
    }

    public Date getRespTime() 
    {
        return respTime;
    }

    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }

    public void setRsv1(String rsv1) 
    {
        this.rsv1 = rsv1;
    }

    public String getRsv1() 
    {
        return rsv1;
    }

    public void setRsv2(String rsv2) 
    {
        this.rsv2 = rsv2;
    }

    public String getRsv2() 
    {
        return rsv2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("channelNo", getChannelNo())
            .append("platformId", getPlatformId())
            .append("channelTransId", getChannelTransId())
            .append("cardNo", getCardNo())
            .append("status", getStatus())
            .append("channelRespStatus", getChannelRespStatus())
            .append("channelRespMsg", getChannelRespMsg())
            .append("operateType", getOperateType())
            .append("currency", getCurrency())
            .append("channelFee", getChannelFee())
            .append("respDate", getRespDate())
            .append("respTime", getRespTime())
            .append("createdAt", getCreatedAt())
            .append("rsv1", getRsv1())
            .append("rsv2", getRsv2())
            .toString();
    }
}
