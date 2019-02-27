package com.ayc.service.api.enums;

import com.ayc.framework.common.BizCode;
import com.ayc.framework.common.BizException;

/**
 * Author:  wwb
 * Date:  2019/2/2014:09
 * Description:阿里云短信模板枚举类
 */
public enum TemplateEnum {
    LOGIN(1, "VER_CODE_LOGIN_", "SMS_148690198"),
    SIGN_IN(2, "VER_CODE_SIGN_IN_", "SMS_148690196"),
    BIND_MOBILE(3, "VER_CODE_BIND_MOBILE_", "SMS_148690194"),
    SET_PWD(4, "VER_CODE_SET_PWD_", "SMS_148690195");

    /**
     * 类型编号
     */
    private Integer type;

    /**
     * redis存储前缀
     */
    private String key;

    /**
     * 短信模板
     */
    private String templateCode;

    TemplateEnum(Integer type, String key, String templateCode) {
        this.type = type;
        this.key = key;
        this.templateCode = templateCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public static String getKeyByType(Integer type){
        if (isVerCodeType(type)){
            for (TemplateEnum verCodeType : TemplateEnum.values()) {
                if (type == verCodeType.getType()){
                    return verCodeType.getKey();
                }
            }
        }
        throw new BizException(BizCode.BUSI_ERROR);
    }

    public static String getTemplateCodeByType(Integer type){
        if (isVerCodeType(type)){
            for (TemplateEnum verCodeType : TemplateEnum.values()) {
                if (type == verCodeType.getType()){
                    return verCodeType.getTemplateCode();
                }
            }
        }
        throw new BizException(BizCode.BUSI_ERROR);
    }

    private static boolean isVerCodeType(Integer type) {
        for (TemplateEnum verCodeType : TemplateEnum.values()) {
            if (type == verCodeType.getType()){
                return true;
            }
        }
        return false;
    }

}
