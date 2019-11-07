package com.rm13.springboot.aop;

import com.alibaba.fastjson.JSON;
import com.rm13.springboot.annotation.Logg;
import com.rm13.springboot.domain.ActionLog;
import com.rm13.springboot.util.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.lang.reflect.Method;

/**
 * @author lovemyrmb
 * @Description: 记录操作日志(基于注解)
 * @date 2018-10-31 14:17
 */
@Slf4j
@Component
@Aspect
public class AnnotationLogAspect {


    @Pointcut("@annotation(com.rm13.springboot.annotation.Logg)")
    public void logPointCut(){
    }

    @AfterReturning("logPointCut()")
    public void saveLog(JoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();

        ActionLog actionLog = new ActionLog();
        Logg lg = method.getAnnotation(Logg.class);
        if(lg!=null){
            actionLog.setDescription(lg.value());
        }
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        actionLog.setMethod(className.concat(".").concat(methodName));
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = RequestUtil.getIp(request);
        actionLog.setIp(ip);
        actionLog.setParams(JSON.toJSONString(joinPoint.getArgs()));
        log.info("loggg:{}", JSON.toJSONString(actionLog));
    }
}
