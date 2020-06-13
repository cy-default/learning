package com.rm13.spring.aop.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Advice: 通知（拦截器）， （拦截器的力度只控制到了类的级别）
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/11
 */
public class LogArgsAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("LogArgsAdvice: 准备执行方法" + method.getName() + ", 参数列表: " + Arrays.asList(args));
    }
}
