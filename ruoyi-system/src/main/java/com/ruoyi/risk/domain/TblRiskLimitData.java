package com.ruoyi.risk.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 TBL_RISK_LIMIT_DATA
 * 
 * @author ruoyi
 * @date 2024-08-16
 */
public class TblRiskLimitData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id主键 */
    private Long ID;

    /** 日期yyyymmdd */
    @Excel(name = "日期yyyymmdd")
    private String limitDate;

    /** 限制元素类型 01:卡号 */
    @Excel(name = "限制元素类型 01:卡号")
    private String limitElement;

    /** 限制元素值 */
    @Excel(name = "限制元素值")
    private String limitValue;

    /** 当日累计金额 */
    @Excel(name = "当日累计金额")
    private BigDecimal dayAmt;

    /** 当日累计次数 */
    @Excel(name = "当日累计次数")
    private BigDecimal dayCnt;

    /** 当月累计金额 */
    @Excel(name = "当月累计金额")
    private BigDecimal monthAmt;

    /** 当月累计次数 */
    @Excel(name = "当月累计次数")
    private BigDecimal monthCnt;

    /** 年累计金额 */
    @Excel(name = "年累计金额")
    private BigDecimal yearAmt;

    /** 年累计次数 */
    @Excel(name = "年累计次数")
    private BigDecimal yearCnt;

    public void setID(Long ID) 
    {
        this.ID = ID;
    }

    public Long getID() 
    {
        return ID;
    }

    public void setLimitDate(String limitDate) 
    {
        this.limitDate = limitDate;
    }

    public String getLimitDate() 
    {
        return limitDate;
    }

    public void setLimitElement(String limitElement) 
    {
        this.limitElement = limitElement;
    }

    public String getLimitElement() 
    {
        return limitElement;
    }

    public void setLimitValue(String limitValue) 
    {
        this.limitValue = limitValue;
    }

    public String getLimitValue() 
    {
        return limitValue;
    }

    public void setDayAmt(BigDecimal dayAmt) 
    {
        this.dayAmt = dayAmt;
    }

    public BigDecimal getDayAmt() 
    {
        return dayAmt;
    }

    public void setDayCnt(BigDecimal dayCnt) 
    {
        this.dayCnt = dayCnt;
    }

    public BigDecimal getDayCnt() 
    {
        return dayCnt;
    }

    public void setMonthAmt(BigDecimal monthAmt) 
    {
        this.monthAmt = monthAmt;
    }

    public BigDecimal getMonthAmt() 
    {
        return monthAmt;
    }

    public void setMonthCnt(BigDecimal monthCnt) 
    {
        this.monthCnt = monthCnt;
    }

    public BigDecimal getMonthCnt() 
    {
        return monthCnt;
    }

    public void setYearAmt(BigDecimal yearAmt) 
    {
        this.yearAmt = yearAmt;
    }

    public BigDecimal getYearAmt() 
    {
        return yearAmt;
    }

    public void setYearCnt(BigDecimal yearCnt) 
    {
        this.yearCnt = yearCnt;
    }

    public BigDecimal getYearCnt() 
    {
        return yearCnt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ID", getID())
            .append("limitDate", getLimitDate())
            .append("limitElement", getLimitElement())
            .append("limitValue", getLimitValue())
            .append("dayAmt", getDayAmt())
            .append("dayCnt", getDayCnt())
            .append("monthAmt", getMonthAmt())
            .append("monthCnt", getMonthCnt())
            .append("yearAmt", getYearAmt())
            .append("yearCnt", getYearCnt())
            .toString();
    }
}
