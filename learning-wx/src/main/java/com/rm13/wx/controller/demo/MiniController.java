package com.rm13.wx.controller.demo;

import cn.binarywang.wx.miniapp.api.WxMaQrcodeService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import com.rm13.wx.config.WxMaConfiguration;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/10
 */
@RequestMapping("/mini/{appid}")
@RestController
public class MiniController {


    @GetMapping("/qrcode")
    public String mini(@PathVariable("appid") String appid) throws WxErrorException {
        final WxMaService maService = WxMaConfiguration.getMaService(appid);
        final WxMaQrcodeService qrcodeService = maService.getQrcodeService();
        final File qrcode = qrcodeService.createWxaCode("/pages/auth/register");
        System.out.println(qrcode.getAbsolutePath());
        return "qrcode:" + qrcode.getAbsolutePath();
    }
}
