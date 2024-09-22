package com.ruoyi.coin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 冷钱包地址对象 tbl_cold_coin_address
 * 
 * @author ruoyi
 * @date 2024-07-28
 */
public class TblColdCoinAddress extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 货币id */
    private Long coinId;

    /** 币种类型 */
    @Excel(name = "币种类型")
    private String coinType;

    /** 已被使用 */
    @Excel(name = "已被使用")
    private String used;

    /** 用户id */
    @Excel(name = "用户id")
    private Long usedby;

    /** 货币地址 */
    @Excel(name = "货币地址")
    private String cryCoinAddress;

    private String privateKey;

    private int genNum;


    public void setCoinId(Long coinId) 
    {
        this.coinId = coinId;
    }

    public Long getCoinId() 
    {
        return coinId;
    }

    public void setCoinType(String coinType) 
    {
        this.coinType = coinType;
    }

    public String getCoinType() 
    {
        return coinType;
    }

    public void setUsed(String used) 
    {
        this.used = used;
    }

    public String getUsed() 
    {
        return used;
    }

    public void setUsedby(Long usedby) 
    {
        this.usedby = usedby;
    }

    public Long getUsedby() 
    {
        return usedby;
    }

    public void setCryCoinAddress(String cryCoinAddress) 
    {
        this.cryCoinAddress = cryCoinAddress;
    }

    public String getCryCoinAddress() 
    {
        return cryCoinAddress;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public int getGenNum() {
        return genNum;
    }

    public void setGenNum(int genNum) {
        this.genNum = genNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("coinId", getCoinId())
            .append("coinType", getCoinType())
            .append("used", getUsed())
            .append("usedby", getUsedby())
            .append("cryCoinAddress", getCryCoinAddress())
            .toString();
    }
}
