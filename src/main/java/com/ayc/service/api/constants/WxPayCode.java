package com.ayc.service.api.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Author:  wwb
 * Date:  2019/2/2519:30
 * Description:微信支付相关参数
 */
@Configuration
@ConfigurationProperties(prefix = "wxpay")
public class WxPayCode {

    public  String appid;
    public  String appsecret;
    public  String mchid;
    public  String paternerkey;
    public  String certpath;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getPaternerkey() {
        return paternerkey;
    }

    public void setPaternerkey(String paternerkey) {
        this.paternerkey = paternerkey;
    }

    public String getCertpath() {
        return certpath;
    }

    public void setCertpath(String certpath) {
        this.certpath = certpath;
    }
}
