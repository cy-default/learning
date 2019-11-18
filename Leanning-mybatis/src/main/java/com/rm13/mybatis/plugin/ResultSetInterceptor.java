package com.rm13.mybatis.plugin;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Properties;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-18
 */
@Slf4j
@Intercepts(@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = Statement.class))
public class ResultSetInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        final Object proceed = invocation.proceed();
        if(invocation.getTarget() instanceof ResultSetHandler){
            log.info("ResultSetInterceptor...intercept...{}", proceed);
        }
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        log.info("ResultSetInterceptor...plugin...{}", target);
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        log.info("ResultSetInterceptor...setProperties...{}", properties);
    }
}
