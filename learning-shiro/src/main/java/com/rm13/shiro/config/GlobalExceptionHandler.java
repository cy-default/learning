package com.rm13.shiro.config;

import com.rm13.shiro.common.ResponseMsg;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/28
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 处理"基于注解"的shiro权限管理(配合shiroFilterFactoryBean一起使用)
     * RequiresPermissions/RequiresRoles
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(AuthorizationException.class)
    public ResponseMsg authorizationException(AuthenticationException e) {
        log.error("AuthenticationException:{}", e);
        return ResponseMsg.error("没有权限", 403);
    }
}

