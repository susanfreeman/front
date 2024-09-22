package com.ruoyi.user.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户信息对象 tbl_user_info
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
public class TblUserInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private Long uiId;

    /** 登录用户id */
    @Excel(name = "登录用户id")
    private Long userId;

    /** 币种 */
    @Excel(name = "币种")
    private String curr;

    /** 姓氏 */
    @Excel(name = "姓氏")
    private String firstName;

    /** 名 */
    @Excel(name = "名")
    private String lastName;

    /** 邮编 */
    @Excel(name = "邮编")
    private String postCode;

    /** 国家 */
    @Excel(name = "国家")
    private String country;

    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 等级 */
    @Excel(name = "等级")
    private String level;

    /** 余额(USD) */
    @Excel(name = "余额(USD)")
    private BigDecimal balance;

    /** 冻结余额 */
    @Excel(name = "冻结余额")
    private BigDecimal balanceFroze;

    /** 最后更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "最后更新时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateTime;

    /** 二次验证码 */
    @Excel(name = "二次验证码")
    private String code2fa;

    /** 代理id */
    @Excel(name = "代理id")
    private Long aiId;

    /** kyc标志 */
    @Excel(name = "kyc标志")
    private String kycFlag;

    /** 证件类型 */
    @Excel(name = "证件类型")
    private String idType;

    /** 证件号码 */
    @Excel(name = "证件号码")
    private String idNo;

    /** 护照图片地址 */
    @Excel(name = "护照图片地址")
    private String passportImg;

    /** 手持证件照 */
    @Excel(name = "手持证件照")
    private String faceImg;

    /** 生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** tron链充值地址 */
    @Excel(name = "tron链充值地址")
    private String tronAddr;

    /** usdc充值地址 */
    @Excel(name = "usdc充值地址")
    private String usdcAddr;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String mobile;

    /** 手机号前缀 */
    @Excel(name = "手机号前缀")
    private String mobilePrefix;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 用户邀请码 */
    @Excel(name = "用户邀请码")
    private String inviteUri;

    /** 余额(USDT) */
    @Excel(name = "余额(USDT)")
    private BigDecimal balanceUsdt;

    /** 余额(GBP) */
    @Excel(name = "余额(GBP)")
    private BigDecimal balanceGbp;

    /** 被推荐用户ui_id */
    @Excel(name = "被推荐用户ui_id")
    private Long inviteUiId;

    /** 余额(EUR) */
    @Excel(name = "余额(EUR)")
    private BigDecimal balanceEur;

    public void setUiId(Long uiId)
    {
        this.uiId = uiId;
    }

    public Long getUiId() 
    {
        return uiId;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setCurr(String curr) 
    {
        this.curr = curr;
    }

    public String getCurr() 
    {
        return curr;
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

    public void setPostCode(String postCode) 
    {
        this.postCode = postCode;
    }

    public String getPostCode() 
    {
        return postCode;
    }

    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getCountry() 
    {
        return country;
    }

    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setLevel(String level) 
    {
        this.level = level;
    }

    public String getLevel() 
    {
        return level;
    }

    public void setBalance(BigDecimal balance) 
    {
        this.balance = balance;
    }

    public BigDecimal getBalance() 
    {
        return balance;
    }

    public void setBalanceFroze(BigDecimal balanceFroze) 
    {
        this.balanceFroze = balanceFroze;
    }

    public BigDecimal getBalanceFroze() 
    {
        return balanceFroze;
    }

    public void setLastUpdateTime(Date lastUpdateTime) 
    {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getLastUpdateTime() 
    {
        return lastUpdateTime;
    }

    public void setCode2fa(String code2fa) 
    {
        this.code2fa = code2fa;
    }

    public String getCode2fa() 
    {
        return code2fa;
    }

    public void setAiId(Long aiId) 
    {
        this.aiId = aiId;
    }

    public Long getAiId() 
    {
        return aiId;
    }

    public void setKycFlag(String kycFlag) 
    {
        this.kycFlag = kycFlag;
    }

    public String getKycFlag() 
    {
        return kycFlag;
    }

    public void setIdType(String idType) 
    {
        this.idType = idType;
    }

    public String getIdType() 
    {
        return idType;
    }

    public void setIdNo(String idNo) 
    {
        this.idNo = idNo;
    }

    public String getIdNo() 
    {
        return idNo;
    }

    public void setPassportImg(String passportImg) 
    {
        this.passportImg = passportImg;
    }

    public String getPassportImg() 
    {
        return passportImg;
    }

    public void setFaceImg(String faceImg) 
    {
        this.faceImg = faceImg;
    }

    public String getFaceImg() 
    {
        return faceImg;
    }

    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }

    public void setTronAddr(String tronAddr) 
    {
        this.tronAddr = tronAddr;
    }

    public String getTronAddr() 
    {
        return tronAddr;
    }

    public void setUsdcAddr(String usdcAddr) 
    {
        this.usdcAddr = usdcAddr;
    }

    public String getUsdcAddr() 
    {
        return usdcAddr;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobilePrefix(String mobilePrefix)
    {
        this.mobilePrefix = mobilePrefix;
    }

    public String getMobilePrefix()
    {
        return mobilePrefix;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }

    public void setInviteUri(String inviteUri)
    {
        this.inviteUri = inviteUri;
    }

    public String getInviteUri()
    {
        return inviteUri;
    }

    public void setBalanceUsdt(BigDecimal balanceUsdt)
    {
        this.balanceUsdt = balanceUsdt;
    }

    public BigDecimal getBalanceUsdt()
    {
        return balanceUsdt;
    }

    public void setBalanceGbp(BigDecimal balanceGbp)
    {
        this.balanceGbp = balanceGbp;
    }

    public BigDecimal getBalanceGbp()
    {
        return balanceGbp;
    }

    public void setInviteUiId(Long inviteUiId)
    {
        this.inviteUiId = inviteUiId;
    }

    public Long getInviteUiId()
    {
        return inviteUiId;
    }

    public void setBalanceEur(BigDecimal balanceEur)
    {
        this.balanceEur = balanceEur;
    }

    public BigDecimal getBalanceEur()
    {
        return balanceEur;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("uiId", getUiId())
            .append("userId", getUserId())
            .append("curr", getCurr())
            .append("firstName", getFirstName())
            .append("lastName", getLastName())
            .append("postCode", getPostCode())
            .append("country", getCountry())
            .append("province", getProvince())
            .append("city", getCity())
            .append("email", getEmail())
            .append("level", getLevel())
            .append("balance", getBalance())
            .append("balanceFroze", getBalanceFroze())
            .append("createTime", getCreateTime())
            .append("lastUpdateTime", getLastUpdateTime())
            .append("code2fa", getCode2fa())
            .append("aiId", getAiId())
            .append("kycFlag", getKycFlag())
            .append("idType", getIdType())
            .append("idNo", getIdNo())
            .append("passportImg", getPassportImg())
            .append("faceImg", getFaceImg())
            .append("birthday", getBirthday())
            .append("tronAddr", getTronAddr())
            .append("usdcAddr", getUsdcAddr())
            .append("mobile", getMobile())
            .append("mobilePrefix", getMobilePrefix())
            .append("address", getAddress())
            .append("inviteUri", getInviteUri())
            .append("balanceUsdt", getBalanceUsdt())
            .append("balanceGbp", getBalanceGbp())
            .append("inviteUiId", getInviteUiId())
            .append("balanceEur", getBalanceEur())
            .toString();
    }
}
