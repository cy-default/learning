package com.rm13.mybatis.plugin;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.*;

import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-18
 */
@Slf4j
@Intercepts(@Signature(type = ParameterHandler.class, method = "setParameters", args = PreparedStatement.class))
public class ParameterInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if(invocation.getTarget() instanceof ParameterHandler){
            log.info("ParameterInterceptor...intercept...{}", ((ParameterHandler) invocation.getTarget()).getParameterObject());
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        log.info("ParameterInterceptor...plugin...{}", target);
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        log.info("ParameterInterceptor...setProperties...{}", properties);
    }
}
