package com.ayc.service.api.configs;

import com.ayc.framework.common.ICode;

/**
 * Author:  wwb
 * Date:  2019/2/2018:16
 * Description:
 */
public enum  AliyunBizCode implements ICode {
    ALISMS_ERROR("910001","阿里云短信官方异常"),
    SMSCODE_ERROR("910002","短信验证码错误"),
    SMSLOSE_ERROR("910003","短信验证码失效"),
    SMSMORE_ERROR("910004","验证码发送过于频繁");
    private final String code;
    private String message;

    AliyunBizCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }}
