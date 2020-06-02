package com.rm13.wx.service;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.impl.WxMpServiceHttpClientImpl;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/2
 */
public class WxMpExtServiceImpl extends WxMpServiceHttpClientImpl {


    @Override
    public String getAccessToken() throws WxErrorException {
        return super.getAccessToken();
    }
}
