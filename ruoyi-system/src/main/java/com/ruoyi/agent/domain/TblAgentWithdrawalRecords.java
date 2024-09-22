package com.ruoyi.agent.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 代理商提现对象 tbl_agent_withdrawal_records
 * 
 * @author ruoyi
 * @date 2024-08-23
 */
public class TblAgentWithdrawalRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表id */
    private Long id;

    /** 代理商id */
    @Excel(name = "代理商id")
    private Long aiId;

    /** 提现金额 */
    @Excel(name = "提现金额")
    private BigDecimal withdrawalAmt;

    /** 提现日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "提现日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date withdrawalDate;

    /** 打款标识 */
    @Excel(name = "打款标识")
    private String withdrawalFlag;

    /** 状态【初始化，审核中，审核通过，审核拒绝】 */
    @Excel(name = "状态【初始化，审核中，审核通过，审核拒绝】")
    private String status;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createdBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updatedBy;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setAiId(Long aiId) 
    {
        this.aiId = aiId;
    }

    public Long getAiId() 
    {
        return aiId;
    }

    public void setWithdrawalAmt(BigDecimal withdrawalAmt) 
    {
        this.withdrawalAmt = withdrawalAmt;
    }

    public BigDecimal getWithdrawalAmt() 
    {
        return withdrawalAmt;
    }

    public void setWithdrawalDate(Date withdrawalDate) 
    {
        this.withdrawalDate = withdrawalDate;
    }

    public Date getWithdrawalDate() 
    {
        return withdrawalDate;
    }

    public void setWithdrawalFlag(String withdrawalFlag) 
    {
        this.withdrawalFlag = withdrawalFlag;
    }

    public String getWithdrawalFlag() 
    {
        return withdrawalFlag;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setCreatedBy(String createdBy) 
    {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() 
    {
        return createdBy;
    }

    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }

    public void setUpdatedBy(String updatedBy) 
    {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() 
    {
        return updatedBy;
    }

    public void setUpdatedAt(Date updatedAt) 
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() 
    {
        return updatedAt;
    }

    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("aiId", getAiId())
            .append("withdrawalAmt", getWithdrawalAmt())
            .append("withdrawalDate", getWithdrawalDate())
            .append("withdrawalFlag", getWithdrawalFlag())
            .append("status", getStatus())
            .append("createdBy", getCreatedBy())
            .append("createdAt", getCreatedAt())
            .append("updatedBy", getUpdatedBy())
            .append("updatedAt", getUpdatedAt())
            .append("remarks", getRemarks())
            .toString();
    }
}
