package com.rm13.cloud.logger;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通过mdc 植入traceId，
 * mdc本质也是采用threadLocal的方式实现的。所以对于异步方式记录的日志无法追踪
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/18
 */
@Slf4j
@Order(1)
@Configuration
public class LoggerConfig implements WebMvcConfigurer {

    private final String traceId = "traceId";

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                MDC.put(traceId, IdUtil.simpleUUID());
                log.info("LoggerInterceptor.preHandle");
                return true;
            }
            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
                log.info("LoggerInterceptor.afterCompletion");
                MDC.remove(traceId);
            }
        });
    }
}
