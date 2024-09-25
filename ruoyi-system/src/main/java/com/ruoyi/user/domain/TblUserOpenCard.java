package com.ruoyi.user.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.utils.mask.CommonMask;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户开卡信息对象 tbl_user_open_card
 *
 * @author ruoyi
 * @date 2024-07-22
 */
public class TblUserOpenCard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 交易流水id */
    private Long uocId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long uiId;

    /** 卡号 */
    @Excel(name = "卡号")
    @CommonMask(start = 6,end = 4)
    private String cardNo;

    /** 卡头 */
    @Excel(name = "卡头")
    private String cardHead;

    /** cvv */
    @Excel(name = "cvv")
    @CommonMask(start = 0,end = 0)
    private String cvv;

    /** 有效期 */
    @Excel(name = "有效期")
    @CommonMask(start = 0,end = 0)
    private String expire;

    /** 姓氏 */
    @Excel(name = "姓氏")
    private String firstName;

    /** 名 */
    @Excel(name = "名")
    private String lastName;

    /** 开卡时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "开卡时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date transTime;

    /** 通道id */
    @Excel(name = "通道id")
    private Long ciId;

    /** 通道卡编号 */
    @Excel(name = "通道卡编号")
    private String cardId;

    /** 卡状态 */
    @Excel(name = "卡状态")
    private String cardStatus;

    /** 卡 */
    private String balance;

    private String oldStatus;

    /** 卡bin表id */
    @Excel(name = "卡bin表id")
    private Long cbId;

    /** 卡币种 */
    @Excel(name = "卡币种")
    private String cardCurr;

    private Long code2fa;

    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Long getCode2fa() {
        return code2fa;
    }

    public void setCode2fa(Long code2fa) {
        this.code2fa = code2fa;
    }

    public void setUocId(Long uocId)
    {
        this.uocId = uocId;
    }

    public Long getUocId()
    {
        return uocId;
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

    public void setCardHead(String cardHead)
    {
        this.cardHead = cardHead;
    }

    public String getCardHead()
    {
        return cardHead;
    }

    public void setCvv(String cvv)
    {
        this.cvv = cvv;
    }

    public String getCvv()
    {
        return cvv;
    }

    public void setExpire(String expire)
    {
        this.expire = expire;
    }

    public String getExpire()
    {
        return expire;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getLastName()
    {
        return lastName;
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

    public void setCardId(String cardId)
    {
        this.cardId = cardId;
    }

    public String getCardId()
    {
        return cardId;
    }

    public void setCardStatus(String cardStatus)
    {
        this.cardStatus = cardStatus;
    }

    public String getCardStatus()
    {
        return cardStatus;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(String oldStatus) {
        this.oldStatus = oldStatus;
    }

    public void setCbId(Long cbId)
    {
        this.cbId = cbId;
    }

    public Long getCbId()
    {
        return cbId;
    }

    public void setCardCurr(String cardCurr)
    {
        this.cardCurr = cardCurr;
    }

    public String getCardCurr()
    {
        return cardCurr;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("uocId", getUocId())
            .append("uiId", getUiId())
            .append("cardNo", getCardNo())
            .append("cardHead", getCardHead())
            .append("cvv", getCvv())
            .append("expire", getExpire())
            .append("firstName", getFirstName())
            .append("lastName", getLastName())
            .append("transTime", getTransTime())
            .append("ciId", getCiId())
            .append("cardId", getCardId())
            .append("cardStatus", getCardStatus())
            .append("cbId", getCbId())
            .append("cardCurr", getCardCurr())
            .toString();
    }
}
