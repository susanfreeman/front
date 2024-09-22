package com.ruoyi.agent.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 代理商分润对象 tbl_agent_profit_record
 * 
 * @author ruoyi
 * @date 2024-08-19
 */
public class TblAgentProfitRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表id */
    private Long id;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Long userId;

    /** 用户所属合作方号 */
    @Excel(name = "用户所属合作方号")
    private Long supPartnerId;

    /** 交易id */
    @Excel(name = "交易id")
    private String transId;

    /** 交易时间 */
    @Excel(name = "交易时间")
    private Date transTime;

    /** 交易类型 */
    @Excel(name = "交易类型")
    private String transType;

    /** 订单交易金额 */
    @Excel(name = "订单交易金额")
    private BigDecimal transAmt;

    /** 手续费 */
    @Excel(name = "手续费")
    private BigDecimal transFee;

    /** 本次分润手续费金额 */
    @Excel(name = "本次分润手续费金额")
    private BigDecimal profitFee;

    /** 分润方式 */
    @Excel(name = "分润方式")
    private String profitMethod;

    /** 一级分润费率 */
    @Excel(name = "一级分润费率")
    private BigDecimal lv1Rate;

    /** 二级分润费率 */
    @Excel(name = "二级分润费率")
    private BigDecimal lv2Rate;

    /** 三级分润费率 */
    @Excel(name = "三级分润费率")
    private BigDecimal lv3Rate;

    /** 一级分润 */
    @Excel(name = "一级分润")
    private BigDecimal lv1Profit;

    /** 二级分润 */
    @Excel(name = "二级分润")
    private BigDecimal lv2Profit;

    /** 三级分润 */
    @Excel(name = "三级分润")
    private BigDecimal lv3Profit;

    /** 一级合作伙伴id */
    @Excel(name = "一级合作伙伴id")
    private Long lv1PartnerId;

    /** 二级合作伙伴id */
    @Excel(name = "二级合作伙伴id")
    private Long lv2PartnerId;

    /** 三级合作伙伴id */
    @Excel(name = "三级合作伙伴id")
    private Long lv3PartnerId;

    /** 三级合作伙伴id */
    private String rate;


    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "TblAgentProfitRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", supPartnerId=" + supPartnerId +
                ", transId='" + transId + '\'' +
                ", transTime=" + transTime +
                ", transType='" + transType + '\'' +
                ", transAmt=" + transAmt +
                ", transFee=" + transFee +
                ", profitFee=" + profitFee +
                ", profitMethod=" + profitMethod +
                ", lv1Rate=" + lv1Rate +
                ", lv2Rate=" + lv2Rate +
                ", lv3Rate=" + lv3Rate +
                ", lv1Profit=" + lv1Profit +
                ", lv2Profit=" + lv2Profit +
                ", lv3Profit=" + lv3Profit +
                ", lv1PartnerId=" + lv1PartnerId +
                ", lv2PartnerId=" + lv2PartnerId +
                ", lv3PartnerId=" + lv3PartnerId +
                ", rate=" + rate +
                '}';
    }

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

    public void setSupPartnerId(Long supPartnerId) 
    {
        this.supPartnerId = supPartnerId;
    }

    public Long getSupPartnerId() 
    {
        return supPartnerId;
    }

    public void setTransId(String transId) 
    {
        this.transId = transId;
    }

    public String getTransId() 
    {
        return transId;
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

    public void setTransFee(BigDecimal transFee) 
    {
        this.transFee = transFee;
    }

    public BigDecimal getTransFee() 
    {
        return transFee;
    }

    public void setProfitFee(BigDecimal profitFee) 
    {
        this.profitFee = profitFee;
    }

    public BigDecimal getProfitFee() 
    {
        return profitFee;
    }

    public void setProfitMethod(String profitMethod)
    {
        this.profitMethod = profitMethod;
    }

    public String getProfitMethod()
    {
        return profitMethod;
    }

    public void setLv1Rate(BigDecimal lv1Rate) 
    {
        this.lv1Rate = lv1Rate;
    }

    public BigDecimal getLv1Rate() 
    {
        return lv1Rate;
    }

    public void setLv2Rate(BigDecimal lv2Rate) 
    {
        this.lv2Rate = lv2Rate;
    }

    public BigDecimal getLv2Rate() 
    {
        return lv2Rate;
    }

    public void setLv3Rate(BigDecimal lv3Rate) 
    {
        this.lv3Rate = lv3Rate;
    }

    public BigDecimal getLv3Rate() 
    {
        return lv3Rate;
    }

    public void setLv1Profit(BigDecimal lv1Profit) 
    {
        this.lv1Profit = lv1Profit;
    }

    public BigDecimal getLv1Profit() 
    {
        return lv1Profit;
    }

    public void setLv2Profit(BigDecimal lv2Profit) 
    {
        this.lv2Profit = lv2Profit;
    }

    public BigDecimal getLv2Profit() 
    {
        return lv2Profit;
    }

    public void setLv3Profit(BigDecimal lv3Profit) 
    {
        this.lv3Profit = lv3Profit;
    }

    public BigDecimal getLv3Profit() 
    {
        return lv3Profit;
    }

    public void setLv1PartnerId(Long lv1PartnerId) 
    {
        this.lv1PartnerId = lv1PartnerId;
    }

    public Long getLv1PartnerId() 
    {
        return lv1PartnerId;
    }

    public void setLv2PartnerId(Long lv2PartnerId) 
    {
        this.lv2PartnerId = lv2PartnerId;
    }

    public Long getLv2PartnerId() 
    {
        return lv2PartnerId;
    }

    public void setLv3PartnerId(Long lv3PartnerId) 
    {
        this.lv3PartnerId = lv3PartnerId;
    }

    public Long getLv3PartnerId() 
    {
        return lv3PartnerId;
    }

}
