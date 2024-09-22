package com.ruoyi.agent.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 代理信息对象 tbl_agent_info
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
public class TblAgentInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 代理商id */
    private Long aiId;

    /** 上级代理商id */
    @Excel(name = "上级代理商id")
    private Long parentAiId;

    /** 登录用户di */
    @Excel(name = "登录用户di")
    private Long userId;

    /** 余额 */
    @Excel(name = "余额")
    private BigDecimal balance;

    /** 冻结余额 */
    @Excel(name = "冻结余额")
    private BigDecimal balanceForze;

    /** 代理成本 */
    @Excel(name = "代理成本")
    private String feeRate;

    /** 代理计算方式 */
    @Excel(name = "代理计算方式")
    private String feeType;

    /** 推广链接 */
    @Excel(name = "推广链接")
    private String inviteUri;

    /** 代理级别 */
    @Excel(name = "代理级别")
    private String level;

    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public void setAiId(Long aiId) 
    {
        this.aiId = aiId;
    }

    public Long getAiId() 
    {
        return aiId;
    }

    public void setParentAiId(Long parentAiId) 
    {
        this.parentAiId = parentAiId;
    }

    public Long getParentAiId() 
    {
        return parentAiId;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setBalance(BigDecimal balance) 
    {
        this.balance = balance;
    }

    public BigDecimal getBalance() 
    {
        return balance;
    }

    public void setBalanceForze(BigDecimal balanceForze)
    {
        this.balanceForze = balanceForze;
    }

    public BigDecimal getBalanceForze()
    {
        return balanceForze;
    }

    public void setFeeRate(String feeRate) 
    {
        this.feeRate = feeRate;
    }

    public String getFeeRate() 
    {
        return feeRate;
    }

    public void setFeeType(String feeType) 
    {
        this.feeType = feeType;
    }

    public String getFeeType() 
    {
        return feeType;
    }

    public void setInviteUri(String inviteUri) 
    {
        this.inviteUri = inviteUri;
    }

    public String getInviteUri() 
    {
        return inviteUri;
    }

    public void setLevel(String level) 
    {
        this.level = level;
    }

    public String getLevel() 
    {
        return level;
    }

    @Override
    public String toString() {
        return "TblAgentInfo{" +
                "aiId=" + aiId +
                ", parentAiId=" + parentAiId +
                ", userId=" + userId +
                ", balance=" + balance +
                ", balanceForze=" + balanceForze +
                ", feeRate='" + feeRate + '\'' +
                ", feeType='" + feeType + '\'' +
                ", inviteUri='" + inviteUri + '\'' +
                ", level='" + level + '\'' +
                ", LoginName='" + loginName + '\'' +
                '}';
    }
}
