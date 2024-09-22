package com.ruoyi.route.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 通道信息对象 tbl_channel_info
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
public class TblChannelInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 通道id */
    private Long ciId;

    /** 通道实现标识 */
    @Excel(name = "通道实现标识")
    private String ciAopName;

    /** 通道请求地址 */
    @Excel(name = "通道请求地址")
    private String ciUri;

    /** appid */
    @Excel(name = "appid")
    private String appId;

    /** secret */
    @Excel(name = "secret")
    private String secretKey;

    /** 通道号 */
    @Excel(name = "通道号")
    private String ciNo;

    /** 通道名 */
    @Excel(name = "通道名")
    private String ciName;

    /** 通道私钥 */
    @Excel(name = "通道私钥")
    private String ciPrivateKey;

    /** 通道公钥 */
    @Excel(name = "通道公钥")
    private String ciPublicKey;

    public void setCiId(Long ciId)
    {
        this.ciId = ciId;
    }

    public Long getCiId() 
    {
        return ciId;
    }

    public void setCiAopName(String ciAopName) 
    {
        this.ciAopName = ciAopName;
    }

    public String getCiAopName() 
    {
        return ciAopName;
    }

    public void setCiUri(String ciUri) 
    {
        this.ciUri = ciUri;
    }

    public String getCiUri() 
    {
        return ciUri;
    }

    public void setAppId(String appId) 
    {
        this.appId = appId;
    }

    public String getAppId() 
    {
        return appId;
    }

    public void setSecretKey(String secretKey) 
    {
        this.secretKey = secretKey;
    }

    public String getSecretKey() 
    {
        return secretKey;
    }

    public void setCiNo(String ciNo) 
    {
        this.ciNo = ciNo;
    }

    public String getCiNo() 
    {
        return ciNo;
    }

    public void setCiName(String ciName) 
    {
        this.ciName = ciName;
    }

    public String getCiName() 
    {
        return ciName;
    }

    public void setCiPrivateKey(String ciPrivateKey)
    {
        this.ciPrivateKey = ciPrivateKey;
    }

    public String getCiPrivateKey()
    {
        return ciPrivateKey;
    }

    public void setCiPublicKey(String ciPublicKey)
    {
        this.ciPublicKey = ciPublicKey;
    }

    public String getCiPublicKey()
    {
        return ciPublicKey;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ciId", getCiId())
            .append("ciAopName", getCiAopName())
            .append("ciUri", getCiUri())
            .append("appId", getAppId())
            .append("secretKey", getSecretKey())
            .append("ciNo", getCiNo())
            .append("ciName", getCiName())
            .append("ciPrivateKey", getCiPrivateKey())
            .append("ciPublicKey", getCiPublicKey())
            .toString();
    }
}
