package com.ruoyi.risk.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 TBL_RISK_LIMIT_CONFIG
 * 
 * @author ruoyi
 * @date 2024-08-16
 */
public class TblRiskLimitConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id主键 */
    private Long id;

    /** 限制元素类型 01:卡号 */
    @Excel(name = "限制元素类型 01:卡号")
    private String limitElement;

    /** 限制元素值 [限制元素类型为01时，该字段存的是具体卡号（ALL:为全局限制）] */
    @Excel(name = "限制元素值 [限制元素类型为01时，该字段存的是具体卡号", readConverterExp = "A=LL:为全局限制")
    private String limitValue;

    /** 单笔限额 */
    @Excel(name = "单笔限额")
    private BigDecimal preAmtLimit;

    /** 日限额 */
    @Excel(name = "日限额")
    private BigDecimal dayAmtLimit;

    /** 日限次数 */
    @Excel(name = "日限次数")
    private BigDecimal dayCntLimit;

    /** 月限额 */
    @Excel(name = "月限额")
    private BigDecimal monthAmtLimit;

    /** 月限次数 */
    @Excel(name = "月限次数")
    private BigDecimal monthCntLimit;

    /** 年累计次数 */
    @Excel(name = "年累计次数")
    private BigDecimal yearCntLimit;

    /** 年累计金额 */
    @Excel(name = "年累计金额")
    private BigDecimal yearAmtLimit;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updateUser;

    public void setId(Long ID)
    {
        this.id = ID;
    }

    public Long getId()
    {
        return id;
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

    public void setPreAmtLimit(BigDecimal preAmtLimit) 
    {
        this.preAmtLimit = preAmtLimit;
    }

    public BigDecimal getPreAmtLimit() 
    {
        return preAmtLimit;
    }

    public void setDayAmtLimit(BigDecimal dayAmtLimit) 
    {
        this.dayAmtLimit = dayAmtLimit;
    }

    public BigDecimal getDayAmtLimit() 
    {
        return dayAmtLimit;
    }

    public void setDayCntLimit(BigDecimal dayCntLimit) 
    {
        this.dayCntLimit = dayCntLimit;
    }

    public BigDecimal getDayCntLimit() 
    {
        return dayCntLimit;
    }

    public void setMonthAmtLimit(BigDecimal monthAmtLimit) 
    {
        this.monthAmtLimit = monthAmtLimit;
    }

    public BigDecimal getMonthAmtLimit() 
    {
        return monthAmtLimit;
    }

    public void setMonthCntLimit(BigDecimal monthCntLimit) 
    {
        this.monthCntLimit = monthCntLimit;
    }

    public BigDecimal getMonthCntLimit() 
    {
        return monthCntLimit;
    }

    public void setYearCntLimit(BigDecimal yearCntLimit) 
    {
        this.yearCntLimit = yearCntLimit;
    }

    public BigDecimal getYearCntLimit() 
    {
        return yearCntLimit;
    }

    public void setYearAmtLimit(BigDecimal yearAmtLimit) 
    {
        this.yearAmtLimit = yearAmtLimit;
    }

    public BigDecimal getYearAmtLimit() 
    {
        return yearAmtLimit;
    }

    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }

    public void setUpdateUser(String updateUser) 
    {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() 
    {
        return updateUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ID", getId())
            .append("limitElement", getLimitElement())
            .append("limitValue", getLimitValue())
            .append("preAmtLimit", getPreAmtLimit())
            .append("dayAmtLimit", getDayAmtLimit())
            .append("dayCntLimit", getDayCntLimit())
            .append("monthAmtLimit", getMonthAmtLimit())
            .append("monthCntLimit", getMonthCntLimit())
            .append("yearCntLimit", getYearCntLimit())
            .append("yearAmtLimit", getYearAmtLimit())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createUser", getCreateUser())
            .append("updateUser", getUpdateUser())
            .toString();
    }
}
