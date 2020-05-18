package com.rm13.cloud.login;

import com.alibaba.fastjson.JSON;
import com.rm13.cloud.common.LoginUserHolder;
import com.rm13.cloud.common.annotation.PassLogin;
import com.rm13.cloud.domain.dto.user.UserDTO;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * 登陆校验拦截器
 * 从redis中读取用户信息，并把用户信息存入threadLocal中
 * @see com.rm13.cloud.config.WebConfig
 * @see com.rm13.cloud.controller.LoginController
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/18
 */
public class LoginUserInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1.不需要登陆校验
        if(isPassLogin(handler)){
            return true;
        }

        // 2.需要登陆校验
        String token = request.getHeader("snmt_mini_token");
        // 校验不通过，登陆失败，返回未登录
        if (token == null) {
            authrizationFailed(response);
            return false;
        }
        /**
         * TODO
         * 1：通过redis查询用户信息
         *  1.1：若redis查询不到， 则抛出authrizationFailed(response);
         *  1.2：若redis查询到数据
         *      1.2.1：把用户信息存入threadLocal中
         *      1.2.2：通过HandlerMethodResolve把用户信息植入controller请求参数中
         */
        // Demo实例
        String user = "{\"nickName\":\"cy\",\"password\":\"sb!@#$%^\",\"phone\":\"17606119876\",\"username\":\"lovemyrm13\"}";
        UserDTO userDTO = JSON.parseObject(user, UserDTO.class);
        LoginUserHolder.set(userDTO);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 移除threadLocal中的值，必须
        LoginUserHolder.remove();
    }

    public void authrizationFailed(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        // 通过一个头"Content-type"告知客户端使用何种码表
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("用户未登录");
        writer.flush();
        writer.close();
    }

    /**
     * 是否无需授权
     *
     * @param handler {@link HandlerMethod}
     * @return {@code true} 无需登陆
     */
    private boolean isPassLogin(Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 获取方法上的注解
            PassLogin passLogin = handlerMethod.getMethod().getAnnotation(PassLogin.class);
            // 如果方法上的注解为空 则获取类的注解
            if (Objects.isNull(passLogin)) {
                passLogin = handlerMethod.getMethod().getDeclaringClass().getAnnotation(PassLogin.class);
            }

            if(passLogin != null){
                return true;
            }
        }
        return false;
    }

}
