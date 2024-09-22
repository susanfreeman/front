package com.ruoyi.common.core.domain.model;

public class ExchangeBody {
    private String sourceCurr;
    private String targetCurr;
    private double sourceAmount;

    public String getSourceCurr() {
        return sourceCurr;
    }

    public void setSourceCurr(String sourceCurr) {
        this.sourceCurr = sourceCurr;
    }

    public String getTargetCurr() {
        return targetCurr;
    }

    public void setTargetCurr(String targetCurr) {
        this.targetCurr = targetCurr;
    }

    public double getSourceAmount() {
        return sourceAmount;
    }

    public void setSourceAmount(double sourceAmount) {
        this.sourceAmount = sourceAmount;
    }
}
