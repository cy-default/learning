package com.rm13.shiro.config;

import com.alibaba.fastjson.JSON;
import com.rm13.shiro.model.generator.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/25
 */
@Slf4j
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        log.info("LoginHandlerInterceptor.preHandle");
        if(user!=null){
            log.info("LoginHandlerInterceptor.preHandle=={}", JSON.toJSONString(user));
            LoginAuthtication.setAuthenticatedUser(user);
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("LoginHandlerInterceptor.afterCompletion");
        LoginAuthtication.clear();
        super.afterCompletion(request, response, handler, ex);
    }
}
