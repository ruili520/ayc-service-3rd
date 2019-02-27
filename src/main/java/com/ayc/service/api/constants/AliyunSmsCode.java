package com.ayc.service.api.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * Author:  wwb
 * Date:  2019/2/1815:47
 * Description:
 */
@Configuration
@ConfigurationProperties(prefix = "aliyunsms")
public class AliyunSmsCode {
    // 产品名称:云通信短信API产品
    private String product;
    // 产品域名,开发者无需替换
    private String domain;
    private String accessKeyId;
    private String accessKeySecret;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }
}
