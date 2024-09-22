package com.ruoyi.notify.trans.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 交易通知对象 tbl_notify_trans
 * 
 * @author ruoyi
 * @date 2024-08-15
 */
public class TblNotifyTrans extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表id */
    private Long id;

    /** 渠道编号 */
    @Excel(name = "渠道编号")
    private String channelNo;

    /** 卡号 */
    @Excel(name = "卡号")
    private String cardNo;

    /** 渠道订单号 */
    @Excel(name = "渠道订单号")
    private String channelTransId;

    /** 交易时间 */
    @Excel(name = "交易时间")
    private String transTime;

    /** 交易时间 */
    @Excel(name = "交易时间")
    private String orderCreatedAt;

    /** 订单币种 */
    @Excel(name = "订单币种")
    private String transCurrency;

    /** 订单交易金额 */
    @Excel(name = "订单交易金额")
    private BigDecimal transAmt;

    /** 交易账单币种 */
    @Excel(name = "交易账单币种")
    private String billingCurrency;

    /** 交易账单金额 */
    @Excel(name = "交易账单金额")
    private BigDecimal billingAmt;

    /** 交易账单金额0：本土交易；1：跨境交易。
 */
    @Excel(name = "交易账单金额0：本土交易；1：跨境交易。 ")
    private String crossType;

    /** 授权码 */
    @Excel(name = "授权码")
    private String authCode;

    /** 商户行业编码 */
    @Excel(name = "商户行业编码")
    private String merchantCode;

    /** 商户名称 */
    @Excel(name = "商户名称")
    private String merchantName;

    /** AuthorizationQuery：授权查询； Authorization：交易授权；Reversal：授权撤销；AuthorizationRefund：退款授权；AuthorizationRefundReversal：退款授权撤销。 */
    @Excel(name = "AuthorizationQuery：授权查询； Authorization：交易授权；Reversal：授权撤销；AuthorizationRefund：退款授权；AuthorizationRefundReversal：退款授权撤销。")
    private String transType;

    /** 开卡状态 */
    @Excel(name = "开卡状态")
    private String status;

    /** 清分标识 */
    @Excel(name = "清分标识")
    private String clearingFlag;

    /** 渠道返回交易状态 */
    @Excel(name = "渠道返回交易状态")
    private String respTransStatus;

    /** 渠道返回交易描述 */
    @Excel(name = "渠道返回交易描述")
    private String respTransMsg;

    /** 手续费 */
    @Excel(name = "手续费")
    private BigDecimal channelFee;

    /** 渠道返回日期 */
    @Excel(name = "渠道返回日期")
    private String respDate;

    /** 渠道返回时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "渠道返回时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date respTime;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 备用字段 */
    @Excel(name = "备用字段")
    private String rsv1;

    /** 备用字段 */
    @Excel(name = "备用字段")
    private String rsv2;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setChannelNo(String channelNo)
    {
        this.channelNo = channelNo;
    }

    public String getChannelNo()
    {
        return channelNo;
    }

    public void setCardNo(String cardNo) 
    {
        this.cardNo = cardNo;
    }

    public String getCardNo() 
    {
        return cardNo;
    }

    public void setChannelTransId(String channelTransId) 
    {
        this.channelTransId = channelTransId;
    }

    public String getChannelTransId() 
    {
        return channelTransId;
    }

    public void setTransTime(String transTime) 
    {
        this.transTime = transTime;
    }

    public String getTransTime() 
    {
        return transTime;
    }

    public void setOrderCreatedAt(String orderCreatedAt) 
    {
        this.orderCreatedAt = orderCreatedAt;
    }

    public String getOrderCreatedAt() 
    {
        return orderCreatedAt;
    }

    public void setTransCurrency(String transCurrency) 
    {
        this.transCurrency = transCurrency;
    }

    public String getTransCurrency() 
    {
        return transCurrency;
    }

    public void setTransAmt(BigDecimal transAmt) 
    {
        this.transAmt = transAmt;
    }

    public BigDecimal getTransAmt() 
    {
        return transAmt;
    }

    public void setBillingCurrency(String billingCurrency) 
    {
        this.billingCurrency = billingCurrency;
    }

    public String getBillingCurrency() 
    {
        return billingCurrency;
    }

    public void setBillingAmt(BigDecimal billingAmt) 
    {
        this.billingAmt = billingAmt;
    }

    public BigDecimal getBillingAmt() 
    {
        return billingAmt;
    }

    public void setCrossType(String crossType) 
    {
        this.crossType = crossType;
    }

    public String getCrossType() 
    {
        return crossType;
    }

    public void setAuthCode(String authCode) 
    {
        this.authCode = authCode;
    }

    public String getAuthCode() 
    {
        return authCode;
    }

    public void setMerchantCode(String merchantCode) 
    {
        this.merchantCode = merchantCode;
    }

    public String getMerchantCode() 
    {
        return merchantCode;
    }

    public void setMerchantName(String merchantName) 
    {
        this.merchantName = merchantName;
    }

    public String getMerchantName() 
    {
        return merchantName;
    }

    public void setTransType(String transType) 
    {
        this.transType = transType;
    }

    public String getTransType() 
    {
        return transType;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setRespTransStatus(String respTransStatus) 
    {
        this.respTransStatus = respTransStatus;
    }

    public String getRespTransStatus() 
    {
        return respTransStatus;
    }

    public void setRespTransMsg(String respTransMsg) 
    {
        this.respTransMsg = respTransMsg;
    }

    public String getRespTransMsg() 
    {
        return respTransMsg;
    }

    public void setChannelFee(BigDecimal channelFee) 
    {
        this.channelFee = channelFee;
    }

    public BigDecimal getChannelFee() 
    {
        return channelFee;
    }

    public void setRespDate(String respDate) 
    {
        this.respDate = respDate;
    }

    public String getRespDate() 
    {
        return respDate;
    }

    public void setRespTime(Date respTime) 
    {
        this.respTime = respTime;
    }

    public Date getRespTime() 
    {
        return respTime;
    }

    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }

    public void setRsv1(String rsv1) 
    {
        this.rsv1 = rsv1;
    }

    public String getRsv1() 
    {
        return rsv1;
    }

    public void setRsv2(String rsv2) 
    {
        this.rsv2 = rsv2;
    }

    public String getRsv2() 
    {
        return rsv2;
    }


    public String getClearingFlag() {
        return clearingFlag;
    }

    public void setClearingFlag(String clearingFlag) {
        this.clearingFlag = clearingFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("channelNo", getChannelNo())
            .append("cardNo", getCardNo())
            .append("channelTransId", getChannelTransId())
            .append("transTime", getTransTime())
            .append("orderCreatedAt", getOrderCreatedAt())
            .append("transCurrency", getTransCurrency())
            .append("transAmt", getTransAmt())
            .append("billingCurrency", getBillingCurrency())
            .append("billingAmt", getBillingAmt())
            .append("crossType", getCrossType())
            .append("authCode", getAuthCode())
            .append("merchantCode", getMerchantCode())
            .append("merchantName", getMerchantName())
            .append("transType", getTransType())
            .append("status", getStatus())
            .append("clearingFlag", getClearingFlag())
            .append("respTransStatus", getRespTransStatus())
            .append("respTransMsg", getRespTransMsg())
            .append("channelFee", getChannelFee())
            .append("respDate", getRespDate())
            .append("respTime", getRespTime())
            .append("createdAt", getCreatedAt())
            .append("rsv1", getRsv1())
            .append("rsv2", getRsv2())
            .toString();
    }
}
