package com.ayc.service.api.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Title:
 * @Description: //TODO 支付宝提现相关参数
 * @Author: edward
 * @Date: 2019/2/26 21:47
 */
@Configuration
@ConfigurationProperties(prefix = "aliPay")
public class AliPayCode {

    private String url;//请求地址

    private String appid;//支付宝应用id

    private String privateKey;//支付宝商户秘钥

    private String publicKey;//支付宝公钥

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
