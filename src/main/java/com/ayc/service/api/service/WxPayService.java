package com.ayc.service.api.service;

import com.ayc.service.api.dto.WxPayDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author:  wwb
 * Date:  2019/2/2520:19
 * Description:
 */
public interface WxPayService {
    String transfer(HttpServletRequest request, HttpServletResponse response, WxPayDto wxPayDto);
}
