package com.ruoyi.notify.trans.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 交易通知手续费明细对象 tbl_trans_fee_detail_
 * 
 * @author ruoyi
 * @date 2024-08-15
 */
public class TblTransFeeDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表id */
    private Long id;

    /** 订单表id */
    @Excel(name = "订单表id")
    private Long transTableId;

    /** 渠道订单号 */
    @Excel(name = "渠道订单号")
    private String channelTransId;

    /** 币种 */
    @Excel(name = "币种")
    private String currency;

    /** 手续费 */
    @Excel(name = "手续费")
    private BigDecimal fee;

    /** 手续费模型 费用明细类型。RateFee：百分百费用；FixFee：固定费用；MinFee：最低收费；MaxFee：最大收费；CrossBoardFee：跨境费。 */
    @Excel(name = "手续费模型 费用明细类型。RateFee：百分百费用；FixFee：固定费用；MinFee：最低收费；MaxFee：最大收费；CrossBoardFee：跨境费。")
    private String feeModel;

    /** 该笔订单总手续费 */
    @Excel(name = "该笔订单总手续费")
    private BigDecimal totalFee;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setTransTableId(Long transTableId) 
    {
        this.transTableId = transTableId;
    }

    public Long getTransTableId() 
    {
        return transTableId;
    }

    public void setChannelTransId(String channelTransId) 
    {
        this.channelTransId = channelTransId;
    }

    public String getChannelTransId() 
    {
        return channelTransId;
    }

    public void setCurrency(String currency) 
    {
        this.currency = currency;
    }

    public String getCurrency() 
    {
        return currency;
    }

    public void setFee(BigDecimal fee) 
    {
        this.fee = fee;
    }

    public BigDecimal getFee() 
    {
        return fee;
    }

    public void setFeeModel(String feeModel)
    {
        this.feeModel = feeModel;
    }

    public String getFeeModel()
    {
        return feeModel;
    }

    public void setTotalFee(BigDecimal totalFee) 
    {
        this.totalFee = totalFee;
    }

    public BigDecimal getTotalFee() 
    {
        return totalFee;
    }

    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("transTableId", getTransTableId())
            .append("channelTransId", getChannelTransId())
            .append("currency", getCurrency())
            .append("fee", getFee())
            .append("feeModel", getFeeModel())
            .append("totalFee", getTotalFee())
            .append("createdAt", getCreatedAt())
            .toString();
    }
}
