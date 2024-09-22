package com.ruoyi.blacklist.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 黑名单列对象 tbl_user_blacklist
 * 
 * @author ruoyi
 * @date 2024-08-21
 */
public class TblUserBlacklist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表id */
    private String id;

    /** 黑名单类型 */
    @Excel(name = "黑名单类型")
    private String blacklistType;

    /** 黑名单值 */
    @Excel(name = "黑名单值")
    private String blacklistValue;

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

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public void setBlacklistType(String blacklistType) 
    {
        this.blacklistType = blacklistType;
    }

    public String getBlacklistType() 
    {
        return blacklistType;
    }

    public void setBlacklistValue(String blacklistValue) 
    {
        this.blacklistValue = blacklistValue;
    }

    public String getBlacklistValue() 
    {
        return blacklistValue;
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
            .append("blacklistType", getBlacklistType())
            .append("blacklistValue", getBlacklistValue())
            .append("createdBy", getCreatedBy())
            .append("createdAt", getCreatedAt())
            .append("updatedBy", getUpdatedBy())
            .append("updatedAt", getUpdatedAt())
            .append("remarks", getRemarks())
            .toString();
    }
}
