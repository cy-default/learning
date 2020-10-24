package com.rm13.cloud.mdc;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author yuan.chen
 * @Mdc 注解拦截器
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/10/24
 */
@Order(-1)
@Aspect
@Component
public class MdcAspect {
    private final static String TRACE_ID = "trxId";
    private static Logger log = LoggerFactory.getLogger(MdcAspect.class);

    @Pointcut("@annotation(com.rm13.cloud.mdc.Mdc)")
    public void pointCut() {
        // do nothings
    }

    @Around(value = "pointCut()")
    public Object invoke(ProceedingJoinPoint point) throws Throwable {
        Object result;
        try {
            setTraceId();
            result = point.proceed(point.getArgs());
            removeTraceId();
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            removeTraceId();
        }
        return result;
    }

    /**
     * 设置traceId
     */
    public static void setTraceId() {
        try {
            final String trxid = TRACE_ID.concat(UUID.randomUUID().toString().replace("-", ""));
            MDC.put(TRACE_ID, trxid);
        } catch (Exception e) {
            log.error("set log no exception", e);
        }
    }

    /**
     * remove traceId
     */
    public static void removeTraceId() {
        try {
            MDC.remove(TRACE_ID);
        } catch (Exception e) {
            log.error("remove log no exception", e);
        }
    }
}
