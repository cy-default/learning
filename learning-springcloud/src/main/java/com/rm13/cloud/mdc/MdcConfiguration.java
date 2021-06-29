package com.rm13.cloud.mdc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/10/24
 */
@Configuration
public class MdcConfiguration implements WebMvcConfigurer {

    @Bean
    public AsyncTaskExecutor taskExecutor() {
        final MdcThreadPoolTaskExecutor executor = MdcThreadPoolTaskExecutor.newWithInheritedMdc(8, 32, 1, TimeUnit.MINUTES, 1000);
        executor.setThreadNamePrefix("anno-executor");
        executor.initialize();
        return executor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                String header = request.getHeader(MdcUtil.TRACE_ID);
                MdcUtil.setTraceId(header);
                return true;
            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
                MdcUtil.removeTraceId();
            }
        });
    }
}
