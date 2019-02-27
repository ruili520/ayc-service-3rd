package com.ayc.service.api.service;

import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.ayc.service.api.dto.AliPayDto;

/**
 * @Title:
 * @Description: //TODO 支付宝提现逻辑层
 * @Author: edward
 * @Date: 2019/2/26 21:48
 */
public interface AliPayService {

    /**
     * 提现方法
     * @param aliPayDto
     * @return
     */
    AlipayFundTransToaccountTransferResponse withdraw(AliPayDto aliPayDto,String outNo);
}
