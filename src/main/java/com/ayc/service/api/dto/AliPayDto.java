package com.ayc.service.api.dto;

import java.math.BigDecimal;

/**
 * 支付宝提现前台需要传的数据封装类
 */
public class AliPayDto {

    private BigDecimal cash;//提现金额

    private BigDecimal nowBalance;//用户当前的余额

    private String aliPayUser;//提现的支付宝号

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public BigDecimal getNowBalance() {
        return nowBalance;
    }

    public void setNowBalance(BigDecimal nowBalance) {
        this.nowBalance = nowBalance;
    }

    public String getAliPayUser() {
        return aliPayUser;
    }

    public void setAliPayUser(String aliPayUser) {
        this.aliPayUser = aliPayUser;
    }
}
