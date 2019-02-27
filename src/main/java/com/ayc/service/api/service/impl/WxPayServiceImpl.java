package com.ayc.service.api.service.impl;

import com.ayc.service.api.constants.WxPayCode;
import com.ayc.service.api.dto.WxPayDto;
import com.ayc.service.api.service.WxPayService;
import com.ayc.service.api.wxpayuntil.AuthUtil;
import com.ayc.service.api.wxpayuntil.CertHttpUtil;
import com.ayc.service.api.wxpayuntil.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Author:  wwb
 * Date:  2019/2/2520:20
 * Description:
 */
@Service("wxPayService")
public class WxPayServiceImpl implements WxPayService {

    @Autowired
    private WxPayCode wxPayCode;

    @Override
    public String transfer(HttpServletRequest request, HttpServletResponse response, WxPayDto wxPayDto) {
        // 1.0 拼凑企业支付需要的参数
        String appid = wxPayCode.getAppid(); // 微信公众号的appid
        String mch_id = wxPayCode.getMchid(); // 商户号
        String nonce_str = WXPayUtil.generateNonceStr(); // 生成随机数
        String partner_trade_no = WXPayUtil.generateNonceStr(); // 生成商户订单号
        String openid = wxPayDto.getOpenid(); // 支付给用户openid
        String check_name = "NO_CHECK"; // 是否验证真实姓名呢
        String re_user_name = "KOLO"; // 收款用户姓名(非必须)
        String amount = wxPayDto.getAmount(); // 企业付款金额，最少为100，单位为分
        String desc = "提现申请！"; // 企业付款操作说明信息。必填。
        String spbill_create_ip = AuthUtil.getRequestIp(request); // 用户的ip地址

        // 2.0 生成map集合
        SortedMap<String, String> packageParams = new TreeMap<String, String>();
        packageParams.put("mch_appid", appid); // 微信公众号的appid
        packageParams.put("mchid", mch_id); // 商务号
        packageParams.put("nonce_str", nonce_str); // 随机生成后数字，保证安全性

        packageParams.put("partner_trade_no", partner_trade_no); // 生成商户订单号
        packageParams.put("openid", openid); // 支付给用户openid
        packageParams.put("check_name", check_name); // 是否验证真实姓名呢
        packageParams.put("re_user_name", re_user_name);// 收款用户姓名
        packageParams.put("amount", amount); // 企业付款金额，单位为分
        packageParams.put("desc", desc); // 企业付款操作说明信息。必填。
        packageParams.put("spbill_create_ip", spbill_create_ip); // 调用接口的机器Ip地址

        try {
            // 3.0 利用上面的参数，先去生成自己的签名
            String sign = WXPayUtil.generateSignature(packageParams, wxPayCode.getPaternerkey());

            // 4.0 将签名再放回map中，它也是一个参数
            packageParams.put("sign", sign);

            // 5.0将当前的map结合转化成xml格式
            String xml = WXPayUtil.mapToXml(packageParams);

            // 6.0获取需要发送的url地址
            String wxUrl = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers"; // 获取退款的api接口


            System.out.println("发送前的xml为：" + xml);

            // 7,向微信发送请求转账请求
            String returnXml = CertHttpUtil.postData(wxUrl, xml, wxPayCode);

            System.out.println("返回的returnXml为:" + returnXml);

            // 8，将微信返回的xml结果转成map格式
            Map<String, String> returnMap = WXPayUtil.xmlToMap(returnXml);

            if (returnMap.get("return_code").equals("SUCCESS")) {
                // 付款成功
                System.out.println("returnMap为:" + returnMap);
            }
            return returnXml;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "error";
    }
}
