package com.ruoyi.route.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 路由信息对象 tbl_route_info
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
public class TblRouteInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 路由id */
    private Long riId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long uiId;

    /** 卡头 */
    @Excel(name = "卡头")
    private String cardHead;

    /** 通道id */
    @Excel(name = "通道id")
    private Long ciId;

    public void setRiId(Long riId) 
    {
        this.riId = riId;
    }

    public Long getRiId() 
    {
        return riId;
    }

    public void setUiId(Long uiId) 
    {
        this.uiId = uiId;
    }

    public Long getUiId() 
    {
        return uiId;
    }

    public void setCardHead(String cardHead) 
    {
        this.cardHead = cardHead;
    }

    public String getCardHead() 
    {
        return cardHead;
    }

    public void setCiId(Long ciId) 
    {
        this.ciId = ciId;
    }

    public Long getCiId() 
    {
        return ciId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("riId", getRiId())
            .append("uiId", getUiId())
            .append("cardHead", getCardHead())
            .append("ciId", getCiId())
            .toString();
    }
}
