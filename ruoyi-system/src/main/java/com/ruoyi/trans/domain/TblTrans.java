package com.ruoyi.trans.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.utils.mask.CommonMask;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 交易流水对象 tbl_trans
 *
 * @author ruoyi
 * @date 2024-07-28
 */
public class TblTrans extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 交易流水id */
    private Long ttId;

    /** 用户表id */
    @Excel(name = "用户表id")
    private Long uiId;

    /** 卡号 */
    @Excel(name = "卡号")
    @CommonMask(start = 6,end = 4)
    private String cardNo;

    /** 交易金额 */
    @Excel(name = "交易金额")
    private BigDecimal transAmt;

    /** 手续费 */
    @Excel(name = "手续费")
    private BigDecimal transFee;

    /** 交易类型(O:开卡/R:充值) */
    @Excel(name = "交易类型(O:开卡/R:充值)")
    private String transType;

    /** 交易币种 */
    @Excel(name = "交易币种")
    private String transCurr;

    /** 交易时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "交易时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date transTime;

    /** 通道id */
    @Excel(name = "通道id")
    private Long ciId;

    /** 交易状态 */
    @Excel(name = "交易状态")
    private String transStatus;

    /** 分润状态 */
    @Excel(name = "分润状态")
    private String agentStatus;

    /** 用户开卡信息表ID */
    @Excel(name = "用户开卡信息表ID")
    private Long uocId;

    /** 通道成本 */
    @Excel(name = "通道成本")
    private BigDecimal transCost;

    public void setTtId(Long ttId)
    {
        this.ttId = ttId;
    }

    public Long getTtId()
    {
        return ttId;
    }

    public void setUiId(Long uiId)
    {
        this.uiId = uiId;
    }

    public Long getUiId()
    {
        return uiId;
    }

    public void setCardNo(String cardNo)
    {
        this.cardNo = cardNo;
    }

    public String getCardNo()
    {
        return cardNo;
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

    public void setTransType(String transType)
    {
        this.transType = transType;
    }

    public String getTransType()
    {
        return transType;
    }

    public void setTransCurr(String transCurr)
    {
        this.transCurr = transCurr;
    }

    public String getTransCurr()
    {
        return transCurr;
    }

    public void setTransTime(Date transTime)
    {
        this.transTime = transTime;
    }

    public Date getTransTime()
    {
        return transTime;
    }

    public void setCiId(Long ciId)
    {
        this.ciId = ciId;
    }

    public Long getCiId()
    {
        return ciId;
    }

    public void setTransStatus(String transStatus)
    {
        this.transStatus = transStatus;
    }

    public String getTransStatus()
    {
        return transStatus;
    }

    public void setAgentStatus(String agentStatus)
    {
        this.agentStatus = agentStatus;
    }

    public String getAgentStatus()
    {
        return agentStatus;
    }

    public void setUocId(Long uocId)
    {
        this.uocId = uocId;
    }

    public Long getUocId()
    {
        return uocId;
    }

    public void setTransCost(BigDecimal transCost)
    {
        this.transCost = transCost;
    }

    public BigDecimal getTransCost()
    {
        return transCost;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ttId", getTtId())
            .append("uiId", getUiId())
            .append("cardNo", getCardNo())
            .append("transAmt", getTransAmt())
            .append("transFee", getTransFee())
            .append("transType", getTransType())
            .append("transCurr", getTransCurr())
            .append("transTime", getTransTime())
            .append("ciId", getCiId())
            .append("transStatus", getTransStatus())
            .append("agentStatus", getAgentStatus())
            .append("uocId", getUocId())
            .append("transCost", getTransCost())
            .toString();
    }
}
