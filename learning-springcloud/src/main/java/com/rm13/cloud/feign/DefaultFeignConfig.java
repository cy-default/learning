package com.rm13.cloud.feign;


import feign.Logger;
import feign.Request;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;
/**
 * feign配置类
 * @author cy
 * @date 2021-06-29 15:41:44
 **/
public class DefaultFeignConfig {

    @Value("${default.feign.config.connect.timeout:10}")
    public int connectTimeOutMillis;
    @Value("${default.feign.config.read.timeout:50}")
    public int readTimeOutMillis;
    @Value("${default.feign.config.retryer.period:100}")
    public int retryerPeriod;
    @Value("${default.feign.config.retryer.period.max:1000}")
    public int retryerMaxPeriod;
    @Value("${default.feign.config.retryer.attempts.max:3}")
    public int retryerMaxAttempts;

    /**
     * 超时
     *
     * @return
     */
    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeOutMillis, TimeUnit.SECONDS, readTimeOutMillis, TimeUnit.SECONDS, true);
    }


    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    /**
     * 参数编码
     *
     * @return
     */
    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }

    /**
     * 重试次数
     *
     * @return
     */
//    @Bean
//    public Retryer feignRetryer() {
//        Retryer retryer = new Retryer.Default(retryerPeriod, retryerMaxPeriod, retryerMaxAttempts);
//        return retryer;
//    }
}
