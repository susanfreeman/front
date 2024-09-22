package com.ruoyi.trans.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 余额变动对象 tbl_balance_trans
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
public class TblBalanceTrans extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 余额变动id */
    private Long btId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long uiId;

    /** 变动类型 */
    @Excel(name = "变动类型")
    private String ubType;

    /** 交易流水号 */
    @Excel(name = "交易流水号")
    private Long transId;

    /** 变动前金额 */
    @Excel(name = "变动前金额")
    private BigDecimal transBeforeAmt;

    /** 变动金额 */
    @Excel(name = "变动金额")
    private BigDecimal transAmt;

    /** 变动后金额 */
    @Excel(name = "变动后金额")
    private BigDecimal transAfterAmt;

    /** 交易时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "交易时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date transTime;

    /** 交易币种 */
    @Excel(name = "交易币种")
    private String transCurr;

    public void setBtId(Long btId)
    {
        this.btId = btId;
    }

    public Long getBtId() 
    {
        return btId;
    }

    public void setUiId(Long uiId) 
    {
        this.uiId = uiId;
    }

    public Long getUiId() 
    {
        return uiId;
    }

    public void setUbType(String ubType) 
    {
        this.ubType = ubType;
    }

    public String getUbType() 
    {
        return ubType;
    }

    public void setTransId(Long transId) 
    {
        this.transId = transId;
    }

    public Long getTransId() 
    {
        return transId;
    }

    public void setTransBeforeAmt(BigDecimal transBeforeAmt) 
    {
        this.transBeforeAmt = transBeforeAmt;
    }

    public BigDecimal getTransBeforeAmt() 
    {
        return transBeforeAmt;
    }

    public void setTransAmt(BigDecimal transAmt) 
    {
        this.transAmt = transAmt;
    }

    public BigDecimal getTransAmt() 
    {
        return transAmt;
    }

    public void setTransAfterAmt(BigDecimal transAfterAmt) 
    {
        this.transAfterAmt = transAfterAmt;
    }

    public BigDecimal getTransAfterAmt() 
    {
        return transAfterAmt;
    }

    public void setTransTime(Date transTime) 
    {
        this.transTime = transTime;
    }

    public Date getTransTime() 
    {
        return transTime;
    }

    public void setTransCurr(String transCurr)
    {
        this.transCurr = transCurr;
    }

    public String getTransCurr()
    {
        return transCurr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("btId", getBtId())
            .append("uiId", getUiId())
            .append("ubType", getUbType())
            .append("transId", getTransId())
            .append("transBeforeAmt", getTransBeforeAmt())
            .append("transAmt", getTransAmt())
            .append("transAfterAmt", getTransAfterAmt())
            .append("transTime", getTransTime())
            .append("transCurr", getTransCurr())
            .append("remark", getRemark())
            .toString();
    }
}
