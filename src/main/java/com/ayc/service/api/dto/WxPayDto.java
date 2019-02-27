package com.ayc.service.api.dto;

/**
 * Author:  wwb
 * Date:  2019/2/2517:00
 * Description:微信支付打赏参数传递
 */
public class WxPayDto {
     private String openid;

     private String amount;


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
