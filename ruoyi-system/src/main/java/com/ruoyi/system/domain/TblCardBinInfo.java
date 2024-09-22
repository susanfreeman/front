package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 卡bin信息对象 tbl_card_bin_info
 *
 * @author ruoyi
 * @date 2024-08-04
 */
public class TblCardBinInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 卡bin表Id */
    private Long cbId;

    /** 账户级别 */
    @Excel(name = "账户级别")
    private String level;

    /** 卡bin */
    @Excel(name = "卡bin")
    private String cardBin;

    /** 卡类型（0:预付费，1.借记） */
    @Excel(name = "卡类型", readConverterExp = "0=:预付费，1.借记")
    private String cardType;

    /** 卡片币种 */
    @Excel(name = "卡片币种")
    private String cardCurr;

    /** 发卡国家 */
    @Excel(name = "发卡国家")
    private String cardCountry;

    /** 月费 */
    @Excel(name = "月费")
    private BigDecimal cardMonthFee;

    /** 充值限额/月 */
    @Excel(name = "充值限额/月")
    private BigDecimal cardMonthLimit;

    /** 充值手续费 */
    @Excel(name = "充值手续费")
    private BigDecimal cardRechargeFee;

    /** 消费手续费 */
    @Excel(name = "消费手续费")
    private BigDecimal cardConsumFee;

    /** 是否需要KYC */
    @Excel(name = "是否需要KYC")
    private String needKyc;

    /** 是否可用 */
    @Excel(name = "是否可用")
    private String isEnable;

    /** 开卡手续费 */
    @Excel(name = "开卡手续费")
    private BigDecimal cardOpenFee;

    /** 最低充值金额 */
    @Excel(name = "最低充值金额")
    private BigDecimal cardRechargeMin;

    public void setCbId(Long cbId)
    {
        this.cbId = cbId;
    }

    public Long getCbId()
    {
        return cbId;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

    public String getLevel()
    {
        return level;
    }

    public void setCardBin(String cardBin)
    {
        this.cardBin = cardBin;
    }

    public String getCardBin()
    {
        return cardBin;
    }

    public void setCardType(String cardType)
    {
        this.cardType = cardType;
    }

    public String getCardType()
    {
        return cardType;
    }

    public void setCardCurr(String cardCurr)
    {
        this.cardCurr = cardCurr;
    }

    public String getCardCurr()
    {
        return cardCurr;
    }

    public void setCardCountry(String cardCountry)
    {
        this.cardCountry = cardCountry;
    }

    public String getCardCountry()
    {
        return cardCountry;
    }

    public void setCardMonthFee(BigDecimal cardMonthFee)
    {
        this.cardMonthFee = cardMonthFee;
    }

    public BigDecimal getCardMonthFee()
    {
        return cardMonthFee;
    }

    public void setCardMonthLimit(BigDecimal cardMonthLimit)
    {
        this.cardMonthLimit = cardMonthLimit;
    }

    public BigDecimal getCardMonthLimit()
    {
        return cardMonthLimit;
    }

    public void setCardRechargeFee(BigDecimal cardRechargeFee)
    {
        this.cardRechargeFee = cardRechargeFee;
    }

    public BigDecimal getCardRechargeFee()
    {
        return cardRechargeFee;
    }

    public void setCardConsumFee(BigDecimal cardConsumFee)
    {
        this.cardConsumFee = cardConsumFee;
    }

    public BigDecimal getCardConsumFee()
    {
        return cardConsumFee;
    }

    public void setNeedKyc(String needKyc)
    {
        this.needKyc = needKyc;
    }

    public String getNeedKyc()
    {
        return needKyc;
    }

    public void setIsEnable(String isEnable)
    {
        this.isEnable = isEnable;
    }

    public String getIsEnable()
    {
        return isEnable;
    }

    public void setCardOpenFee(BigDecimal cardOpenFee)
    {
        this.cardOpenFee = cardOpenFee;
    }

    public BigDecimal getCardOpenFee()
    {
        return cardOpenFee;
    }

    public void setCardRechargeMin(BigDecimal cardRechargeMin)
    {
        this.cardRechargeMin = cardRechargeMin;
    }

    public BigDecimal getCardRechargeMin()
    {
        return cardRechargeMin;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cbId", getCbId())
            .append("level", getLevel())
            .append("cardBin", getCardBin())
            .append("cardType", getCardType())
            .append("cardCurr", getCardCurr())
            .append("cardCountry", getCardCountry())
            .append("cardMonthFee", getCardMonthFee())
            .append("cardMonthLimit", getCardMonthLimit())
            .append("cardRechargeFee", getCardRechargeFee())
            .append("cardConsumFee", getCardConsumFee())
            .append("needKyc", getNeedKyc())
            .append("remark", getRemark())
            .append("isEnable", getIsEnable())
            .append("cardOpenFee", getCardOpenFee())
            .append("cardRechargeMin", getCardRechargeMin())
            .toString();
    }
}
