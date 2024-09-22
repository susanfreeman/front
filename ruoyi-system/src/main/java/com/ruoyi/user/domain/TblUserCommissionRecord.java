package com.ruoyi.user.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户返佣记录对象 tbl_user_commission_record
 * 
 * @author ruoyi
 * @date 2024-08-27
 */
public class TblUserCommissionRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表id */
    private Long id;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Long userId;

    /** 交易时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "交易时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date transTime;

    /** 交易类型 */
    @Excel(name = "交易类型")
    private String transType;

    /** 订单交易金额 */
    @Excel(name = "订单交易金额")
    private BigDecimal transAmt;

    /** 手续费 */
    @Excel(name = "手续费")
    private BigDecimal channelFee;

    /** 分润方式 */
    @Excel(name = "分润方式")
    private String profitMethod;

    /** 返佣金额 */
    @Excel(name = "返佣金额")
    private BigDecimal commissionAmount;

    /** 返佣费率 */
    @Excel(name = "返佣费率")
    private BigDecimal commissionRate;

    /** 渠道返回日期 */
    @Excel(name = "渠道返回日期")
    private String respDate;

    /** 交易流水ID */
    @Excel(name = "交易流水ID")
    private Long ttId;

    /** 渠道返回时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "渠道返回时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date respTime;

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

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setTransTime(Date transTime) 
    {
        this.transTime = transTime;
    }

    public Date getTransTime() 
    {
        return transTime;
    }

    public void setTransType(String transType) 
    {
        this.transType = transType;
    }

    public String getTransType() 
    {
        return transType;
    }

    public void setTransAmt(BigDecimal transAmt) 
    {
        this.transAmt = transAmt;
    }

    public BigDecimal getTransAmt() 
    {
        return transAmt;
    }

    public void setChannelFee(BigDecimal channelFee) 
    {
        this.channelFee = channelFee;
    }

    public BigDecimal getChannelFee() 
    {
        return channelFee;
    }

    public void setProfitMethod(String profitMethod) 
    {
        this.profitMethod = profitMethod;
    }

    public String getProfitMethod() 
    {
        return profitMethod;
    }

    public void setCommissionAmount(BigDecimal commissionAmount) 
    {
        this.commissionAmount = commissionAmount;
    }

    public BigDecimal getCommissionAmount() 
    {
        return commissionAmount;
    }

    public void setCommissionRate(BigDecimal commissionRate) 
    {
        this.commissionRate = commissionRate;
    }

    public BigDecimal getCommissionRate() 
    {
        return commissionRate;
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

    public Long getTtId() {
        return ttId;
    }

    public void setTtId(Long ttId) {
        this.ttId = ttId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("transTime", getTransTime())
            .append("transType", getTransType())
            .append("transAmt", getTransAmt())
            .append("channelFee", getChannelFee())
            .append("profitMethod", getProfitMethod())
            .append("commissionAmount", getCommissionAmount())
            .append("commissionRate", getCommissionRate())
            .append("respDate", getRespDate())
            .append("respTime", getRespTime())
            .append("createdAt", getCreatedAt())
            .append("ttId", getTtId())
            .toString();
    }
}
