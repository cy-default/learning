package com.rm13.wx.service;

import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/2
 */
@Service
public class UserServiceImpl {

    @Autowired
    private WxMpService wxMpService;
}
