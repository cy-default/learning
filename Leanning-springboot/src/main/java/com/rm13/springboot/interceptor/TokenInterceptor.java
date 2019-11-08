package com.rm13.springboot.interceptor;

import com.rm13.springboot.security.UserSecurity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆状态拦截器
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-07
 */
@Slf4j
@RequiredArgsConstructor
public class TokenInterceptor extends HandlerInterceptorAdapter {


    @Value("${secret:}")
    private String secret;

    private final StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1.打印访问路径
        String url = request.getRequestURI();
        log.info("url:{}", url);

        // 2.拦截处理
        String token = request.getHeader("leanning_token");
        log.info("authorization:{}", token);

        // 3.登陆状态校验
        String unionId = redisTemplate.opsForValue().get(token);
        log.info("session:{}");
        if(StringUtils.isNotBlank(unionId)){
            UserSecurity.unionId.set(unionId);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserSecurity.unionId.remove();
        UserSecurity.user.remove();
    }
}
