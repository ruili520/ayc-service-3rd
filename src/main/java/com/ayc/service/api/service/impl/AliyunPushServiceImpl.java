
package com.ayc.service.api.service.impl;

import com.ayc.service.api.constants.AliyunPushCode;
import com.ayc.service.api.service.AliyunPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author:  ysj
 * Date:  2019/2/18 14:50
 * Description:
 */
@Service("aliyunPushService")
public class AliyunPushServiceImpl implements AliyunPushService{
    @Autowired
    private AliyunPushCode aliyunPushCode;

    @Override
    public void test() {
        System.out.println(aliyunPushCode.getAccessKeySecret());
    }
}