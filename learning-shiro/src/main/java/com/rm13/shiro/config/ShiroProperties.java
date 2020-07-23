package com.rm13.shiro.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/23
 */
@Data
@ConfigurationProperties(prefix = "shiro.config")
public class ShiroProperties {

    /**
     * 会话超时时间
     */
    private int sessionTimeout;

    /**
     * 登陆url
     */
    private String loginUrl;

    /**
     * 登录成功后跳转的 url
     */
    private String successUrl;

    /**
     * 未授权 url
     */
    private String unauthorizedUrl;

    /**
     * 登出 url
     */
    private String logoutUrl;

    /**
     * 匿名url
     */
    private Map<String, String> anons;

}
