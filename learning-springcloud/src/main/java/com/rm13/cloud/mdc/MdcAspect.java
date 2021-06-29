package com.rm13.cloud.mdc;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

/**
 * 废弃⚠️；
 * 不通过aop切面的形式植入trace_id；
 * 通过mvc请求判断是否有traceId， 没有的话则植入traceid
 *
 * @author yuan.chen
 * @Mdc 注解拦截器
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/10/24
 */
@Slf4j
@Deprecated
@Order(-1)
@Aspect
public class MdcAspect {

    @Pointcut("@annotation(com.rm13.cloud.mdc.Mdc)")
    public void pointCut() {
        // do nothings
    }

    @Around(value = "pointCut()")
    public Object invoke(ProceedingJoinPoint point) throws Throwable {
        Object result;
        try {
            MdcUtil.setTraceId(null);
            result = point.proceed(point.getArgs());
            MdcUtil.removeTraceId();
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            MdcUtil.removeTraceId();
        }
        return result;
    }
}
