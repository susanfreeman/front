package com.ruoyi.risk.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 TBL_OPERATOR_CARD
 * 
 * @author ruoyi
 * @date 2024-08-16
 */
public class TblOperatorCard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id主键 */
    private Long id;

    /** 卡号 */
    @Excel(name = "卡号")
    private String cardNo;

    /** 操作类型：FZ:冻结 UFZ:解冻 CLO:销卡 */
    @Excel(name = "操作类型：FZ:冻结 UFZ:解冻 CLO:销卡")
    private String operType;

    /** 操作类型：FZ:冻结 UFZ:解冻 CLO:销卡 */
    @Excel(name = "状态 INIT SUCCESS FAIL")
    private String statuss;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operUser;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date operTime;
    /** 操作时间 */

    public void setID(Long ID)
    {
        this.id = ID;
    }

    public Long getID()
    {
        return id;
    }

    public void setCardNo(String cardNo) 
    {
        this.cardNo = cardNo;
    }

    public String getCardNo() 
    {
        return cardNo;
    }

    public void setOperType(String operType) 
    {
        this.operType = operType;
    }

    public String getOperType() 
    {
        return operType;
    }

    public void setOperUser(String operUser) 
    {
        this.operUser = operUser;
    }

    public String getOperUser() 
    {
        return operUser;
    }

    public void setOperTime(Date operTime) 
    {
        this.operTime = operTime;
    }

    public Date getOperTime() 
    {
        return operTime;
    }


    public String getStatuss() {
        return statuss;
    }

    public void setStatuss(String statuss) {
        this.statuss = statuss;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ID", getID())
            .append("cardNo", getCardNo())
            .append("operType", getOperType())
            .append("statuss", getStatuss())
            .append("operUser", getOperUser())
            .append("operTime", getOperTime())
            .toString();
    }
}
