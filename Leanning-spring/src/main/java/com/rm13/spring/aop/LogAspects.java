package com.rm13.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 切面类
 * @Aspect 告诉Spring当前类是一个切面类
 */
@Slf4j
@Aspect
public class LogAspects {

    /**
     * 抽取公共的切入点表达式
     * 1、本类引用
     * 2、其他的切面引用
     */
    @Pointcut("execution(public int com.rm13.spring.aop.MathCalculator.*(..)))")
    public void pointCut(){};

    @Before("pointCut()")
    public void logBeg(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        log.info("@Before..method:{}..args:{}", joinPoint.getSignature().getName(), args);
    }

    /**
     * 无论方法正常结束还是异常结束
     * @param joinPoint
     */
    @After("com.rm13.spring.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint){
        log.info("@After..method:{}..", joinPoint.getSignature().getName());
    }

    /**
     * JoinPoint一定要出现在参数表的第一位
     * 方法正常结束
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "com.rm13.spring.aop.LogAspects.pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result){
        log.info("@AfterReturning..method:{}..result:{}", joinPoint.getSignature().getName(), result);
    }

    /**
     * 方法异常结束
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(value="pointCut()",throwing="exception")
    public void logException(JoinPoint joinPoint, Exception exception){
        log.info("@AfterThrowing..method:{}..exception:{}", joinPoint.getSignature().getName(), exception.getMessage());
    }
}
