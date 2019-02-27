
package com.ayc.service.api.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Author:  ysj
 * Date:  2019/2/18 14:28
 * Description:
 */
@Configuration
@ConfigurationProperties(prefix = "aliyunPush")
public class AliyunPushCode {
    private String accessKeyId;
    private String accessKeySecret;
    private String appKey;

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

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
}