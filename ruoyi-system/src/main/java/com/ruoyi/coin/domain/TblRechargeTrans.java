package com.ruoyi.coin.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 充值记录对象 tbl_recharge_trans
 *
 * @author ruoyi
 * @date 2024-08-01
 */
public class TblRechargeTrans extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 充值ID */
    private Long rtId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long uiId;

    /** 充值金额 */
    @Excel(name = "充值金额")
    private BigDecimal transAmt;

    /** 充值币种 */
    @Excel(name = "充值币种")
    private String transCurr;

    /** 充值汇率 */
    @Excel(name = "充值汇率")
    private BigDecimal transRate;

    /** 转换后金额 */
    @Excel(name = "转换后金额")
    private BigDecimal exchangeTransAmt;

    /** 转换后币种 */
    @Excel(name = "转换后币种")
    private String exchangeCurr;

    /** 交易时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "交易时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date transTime;

    /** 交易状态 */
    @Excel(name = "交易状态")
    private String transStatus;

    /** 代理费用状态 */
    @Excel(name = "代理费用状态")
    private String agentStatus;

    /** 交易Id哈希 */
    @Excel(name = "交易Id哈希")
    private String txId;

    public void setRtId(Long rtId)
    {
        this.rtId = rtId;
    }

    public Long getRtId()
    {
        return rtId;
    }

    public void setUiId(Long uiId)
    {
        this.uiId = uiId;
    }

    public Long getUiId()
    {
        return uiId;
    }

    public void setTransAmt(BigDecimal transAmt)
    {
        this.transAmt = transAmt;
    }

    public BigDecimal getTransAmt()
    {
        return transAmt;
    }

    public void setTransCurr(String transCurr)
    {
        this.transCurr = transCurr;
    }

    public String getTransCurr()
    {
        return transCurr;
    }

    public void setTransRate(BigDecimal transRate)
    {
        this.transRate = transRate;
    }

    public BigDecimal getTransRate()
    {
        return transRate;
    }

    public void setExchangeTransAmt(BigDecimal exchangeTransAmt)
    {
        this.exchangeTransAmt = exchangeTransAmt;
    }

    public BigDecimal getExchangeTransAmt()
    {
        return exchangeTransAmt;
    }

    public void setExchangeCurr(String exchangeCurr)
    {
        this.exchangeCurr = exchangeCurr;
    }

    public String getExchangeCurr()
    {
        return exchangeCurr;
    }

    public void setTransTime(Date transTime)
    {
        this.transTime = transTime;
    }

    public Date getTransTime()
    {
        return transTime;
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

    public void setTxId(String txId)
    {
        this.txId = txId;
    }

    public String getTxId()
    {
        return txId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("rtId", getRtId())
                .append("uiId", getUiId())
                .append("transAmt", getTransAmt())
                .append("transCurr", getTransCurr())
                .append("transRate", getTransRate())
                .append("exchangeTransAmt", getExchangeTransAmt())
                .append("exchangeCurr", getExchangeCurr())
                .append("transTime", getTransTime())
                .append("transStatus", getTransStatus())
                .append("agentStatus", getAgentStatus())
                .append("txId", getTxId())
                .toString();
    }
}
