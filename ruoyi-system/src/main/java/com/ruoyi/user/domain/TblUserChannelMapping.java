package com.ruoyi.user.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户通道映射对象 tbl_user_channel_mapping
 * 
 * @author ruoyi
 * @date 2024-07-21
 */
public class TblUserChannelMapping extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户通道映射id */
    private Long ucmId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long uiId;

    /** 通道id */
    @Excel(name = "通道id")
    private Long ciId;

    /** 通道返回用户id */
    @Excel(name = "通道返回用户id")
    private String ucmNo;

    public void setUcmId(Long ucmId) 
    {
        this.ucmId = ucmId;
    }

    public Long getUcmId() 
    {
        return ucmId;
    }

    public void setUiId(Long uiId) 
    {
        this.uiId = uiId;
    }

    public Long getUiId() 
    {
        return uiId;
    }

    public void setCiId(Long ciId) 
    {
        this.ciId = ciId;
    }

    public Long getCiId() 
    {
        return ciId;
    }

    public void setUcmNo(String ucmNo) 
    {
        this.ucmNo = ucmNo;
    }

    public String getUcmNo() 
    {
        return ucmNo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ucmId", getUcmId())
            .append("uiId", getUiId())
            .append("ciId", getCiId())
            .append("ucmNo", getUcmNo())
            .toString();
    }
}
