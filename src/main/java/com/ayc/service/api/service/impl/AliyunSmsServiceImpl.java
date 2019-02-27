package com.ayc.service.api.service.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.ayc.service.api.constants.AliyunSmsCode;
import com.ayc.service.api.dto.SmsDto;
import com.ayc.service.api.enums.TemplateEnum;
import com.ayc.service.api.service.AliyunSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author:  wwb
 * Date:  2019/2/2014:03
 * Description:阿里云短信服务
 */
@Service("aliyunSmsService")
public class AliyunSmsServiceImpl implements AliyunSmsService {

    @Autowired
    private AliyunSmsCode aliyunSmsCode;

    @Override
    public SendSmsResponse sendSms(SmsDto smsDto) throws ClientException{
        // 可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        // 初始化acsClient,暂不支持region化
//        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<accessKeyId>", "<accessSecret>");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", aliyunSmsCode.getAccessKeyId(), aliyunSmsCode.getAccessKeySecret());
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", aliyunSmsCode.getProduct(),aliyunSmsCode.getDomain());
        IAcsClient acsClient = new DefaultAcsClient(profile);
        // 组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        // 必填:待发送手机号
        request.setPhoneNumbers(smsDto.getMobile());
        // 必填:短信签名-可在短信控制台中找到
        request.setSignName("爱原创"); // TODO 改这里
        // 必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(TemplateEnum.getTemplateCodeByType(smsDto.getType()));  // TODO 改这里
        // 可选:模板中的变量替换JSON串,如模板内容为"亲爱的用户,您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"code\":\"" + smsDto.getSmsCode() + "\"}");
        // 选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        // request.setSmsUpExtendCode("90997");
        // 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");
        // hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            System.out.println("短信发送成功！");
        } else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }
}
