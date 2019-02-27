package com.ayc.service.api.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.ayc.framework.common.AjaxResult;
import com.ayc.service.api.constants.AliPayCode;
import com.ayc.service.api.dto.AliPayDto;
import com.ayc.service.api.service.AliPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title:
 * @Description: //TODO 支付宝提现实现类
 * @Author: edward
 * @Date: 2019/2/26 21:48
 */
@Service("AliPayService")
public class AliPayServiceImpl implements AliPayService {
    @Autowired
    private AliPayCode aliPayCode;

    Logger logger  = LoggerFactory.getLogger(AliPayServiceImpl.class);


    /**
     * @Title:
     * @Description: //TODO 支付宝提现逻辑(前台把要转账的支付宝用户和转账金额发过来，后台发起请求，同步返回结果)
     * @Author: edward
     * @Date: 2019/2/26 21:48
     */
    @Override
    public AlipayFundTransToaccountTransferResponse withdraw(AliPayDto aliPayDto,String outBizNo) {
        AlipayFundTransToaccountTransferResponse response = null;
        String URL = aliPayCode.getUrl();//请求地址
        String APPID = aliPayCode.getAppid();//支付宝应用id，必填
        String PUBLIC_KEY = aliPayCode.getPublicKey();//支付宝公钥
        String PRIVATE_KEY = aliPayCode.getPrivateKey();//支付宝商户私钥
        logger.info("method:withdraw\t支付宝提现开始!");
        long startTime = System.currentTimeMillis();
        try{
            //以下为公共请求参数
            AlipayClient alipayClient = new DefaultAlipayClient(URL,APPID,PRIVATE_KEY,"json","utf-8",PUBLIC_KEY,"RSA2");
            AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
            //以下为请求参数（*唯一转账订单号out_biz_no，*收款方账户类型payee_type，*收款方账户payee_account，*转账金额amount=====这四项为必填
            //              付款方姓名payer_show_name，收款方真实姓名payee_real_name，转账备注remark=====这三项为选填）
            String out_biz_no = outBizNo;//流水号
            String payee_type = "ALIPAY_LOGONID";//验证方式
            String payee_account = aliPayDto.getAliPayUser();//用户支付宝号，支持登录号，手机号和邮箱格式
            String amount = String.valueOf(aliPayDto.getCash());//金额
            String payer_show_name = "爱原创";//支付商户名称
            //String payee_real_name = "程亚磊";真实姓名，可不填，如果填了会校验支付宝的实名认证
            String remark = "爱原创提现";//备注，如果传了会显示在用户的账单中
            request.setBizContent("{" +
                    " \"out_biz_no\":\""+out_biz_no+"\"," +
                    " \"payee_type\":\""+payee_type+"\"," +
                    " \"payee_account\":\""+payee_account+"\"," +
                    " \"amount\":\""+amount+"\"," +
                    " \"payer_show_name\":\""+payer_show_name+"\"," +
                    /* " \"payee_real_name\":\""+payee_real_name+"\"," +*/
                    " \"remark\":\""+remark+"\"," +
                    " }");
            response = alipayClient.execute(request);
            return response;
        }catch (Exception e){
            e.printStackTrace();
            return response;
        }
    }
}
