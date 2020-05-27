package com.rm13.cloud.config;

import com.rm13.cloud.login.LoginUserArgumentResolver;
import com.rm13.cloud.login.LoginUserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/18
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 添加参数解析器
     *
     * @param resolvers 参数解析器集合
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginUserArgumentResolver());
    }

    /**
     * 添加请求拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginUserInterceptor()).excludePathPatterns("/swagger-*/**", "/webjars/**", "/v2/api-docs/**");
    }
}
