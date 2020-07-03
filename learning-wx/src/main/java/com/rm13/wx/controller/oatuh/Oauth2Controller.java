package com.rm13.wx.controller.oatuh;

import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rm13.wx.entity.bo.WxUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.http.URIUtil;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/29
 */

@CrossOrigin("*")
@Slf4j
@RestController
@RequestMapping("/oauth2/{appid}")
public class Oauth2Controller {


    @Value("${server.domain:}")
    private String domain;

    @Autowired
    private WxMpService wxService;

    public static void main(String[] args) {
        System.out.println(URIUtil.encodeURIComponent("http://localhost:8080/demo/cc#sadf#"));
    }


    @GetMapping("/target")
    public String target(@RequestParam(value = "openid", required = false) String openid) {

        return openid;
    }

    /**
     * 静默授权
     */
    @GetMapping("/base")
    public void oauth2Base(@PathVariable(value = "appid", required = false) String appid,
                           @RequestParam(value = "url", required = false) String url,
                           HttpServletRequest req,
                           HttpServletResponse resp) throws IOException {

        String redirectUri = domain + "oauth2/" + appid + "/callback?jumpUrl=".concat(url);
        wxService.switchover(appid);
        final String wxurl = wxService.oauth2buildAuthorizationUrl(redirectUri, "snsapi_base", "STATE");
        log.info("base:" + wxurl);
        resp.sendRedirect(wxurl);
    }

    /**
     * 用户授权
     */
    @GetMapping("/userinfo")
    public void oauth2UserInfo(@PathVariable(value = "appid", required = false) String appid,
                               @RequestParam(value = "url", required = false) String url,
                               HttpServletRequest req,
                               HttpServletResponse resp) throws IOException {
        String callback = domain + "oauth2/" + appid + "/callback?jumpUrl=".concat(url);
        wxService.switchover(appid);
        final String wxurl = wxService.oauth2buildAuthorizationUrl(callback, "snsapi_userinfo", "STATE");
        log.info("userinfo:" + wxurl);
        resp.sendRedirect(wxurl);
    }


    /**
     * 授权后回调地址
     *
     * @param code
     * @param state
     * @param jumpUrl
     * @param appid
     * @param req
     * @return
     * @throws WxErrorException
     * @throws JsonProcessingException
     */
    @GetMapping("/callback")
    public void callback(@RequestParam(value = "code", required = false) String code,
                         @RequestParam(value = "state", required = false) String state,
                         @RequestParam(value = "jumpUrl", required = false) String jumpUrl,
                         @PathVariable(value = "appid", required = false) String appid,
                         HttpServletRequest req,
                         HttpServletResponse resp) throws WxErrorException, IOException {
        wxService.switchover(appid);
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxService.oauth2getAccessToken(code);
        log.info("callback:".concat(jumpUrl).concat("accessToken=").concat(new ObjectMapper().writeValueAsString(wxMpOAuth2AccessToken)));
        WxMpUser wxMpUser = wxService.getUserService().userInfo(wxMpOAuth2AccessToken.getOpenId(), "zh-cn");
        log.info("wxMpUser:{}", wxMpUser);

        UrlBuilder builder = UrlBuilder.ofHttp(jumpUrl, CharsetUtil.CHARSET_UTF_8);

        // fuck 不同域cookie不能共享。
        Cookie cookie = new Cookie("wxUser1", URLEncoder.encode(JSONUtil.toJsonStr(wxMpUser),"UTF-8"));
        cookie.setMaxAge(60*60);
        // 必须是 同域才能共享cookie
        cookie.setDomain(".idcfengye.com");
        cookie.setPath("/");
        resp.addCookie(cookie);

        resp.sendRedirect(jumpUrl.concat("?openid=").concat(wxMpOAuth2AccessToken.getOpenId()).concat("&nickname=").concat(wxMpUser.getNickname()));
    }
}
