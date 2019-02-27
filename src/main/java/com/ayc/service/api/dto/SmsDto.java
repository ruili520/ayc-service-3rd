package com.ayc.service.api.dto;

/**
 * Author:  wwb
 * Date:  2019/2/2015:31
 * Description:短信验证码传参实体类
 */
public class SmsDto {
    /**
     * 手机号
     */
    private String mobile;

    /**
     * 验证码类型
     */
    private Integer type;

    /**
     * 验证码
     */
    private String smsCode;

    /**
     * 获取次数
     */
    private Integer times;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String verCode) {
        this.smsCode = verCode;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}
