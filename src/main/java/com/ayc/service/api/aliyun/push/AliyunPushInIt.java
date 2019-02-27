
package com.ayc.service.api.aliyun.push;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.push.model.v20160801.PushRequest;

/**
 * Author:  ysj
 * Date:  2019/2/18 14:14
 * Description:阿里云移动推送组件初始化
 */
public class AliyunPushInIt {
    public static DefaultAcsClient getClient(String accessKeyId,String accessKeySecret){
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        if(profile == null){
            //异常处理
        }
        DefaultAcsClient client = new DefaultAcsClient(profile);
        if(client == null){
            //异常处理
        }
        return client;
    }
    public PushRequest getPushRequest(String appKey){
        PushRequest pushRequest = new PushRequest();

        return pushRequest;
    }
}