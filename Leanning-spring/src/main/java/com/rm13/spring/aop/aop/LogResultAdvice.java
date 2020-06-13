package com.rm13.spring.aop.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Advice: 通知（拦截器）， （拦截器的力度只控制到了类的级别）
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/11
 */
public class LogResultAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("LogResultAdvice: 方法返回: " + returnValue);
    }
}
