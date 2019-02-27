package com.ayc.service.api.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.ayc.service.api.dto.SmsDto;

/**
 * Author:  wwb
 * Date:  2019/2/2014:02
 * Description:阿里云短信服务
 */
public interface AliyunSmsService {

    SendSmsResponse sendSms(SmsDto smsDto) throws ClientException;
}
