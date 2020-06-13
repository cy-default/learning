package com.rm13.spring.aop.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/11
 */
public class DebugInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("DebugInterceptor: before: ["+invocation+ "]");
        // 执行 真实 '实现类' 的方法
        Object proceed = invocation.proceed();
        System.out.println("DebugInterceptor: after: invocation returned");
        return proceed;
    }
}
