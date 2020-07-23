package com.rm13.cloud.retry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * spring整合重试机制
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/25
 * @see https://www.baeldung.com/spring-retry
 */
@EnableRetry
@Configuration
public class RetryConfig {

    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();

        // 每次回退固定的时间
        // FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        // fixedBackOffPolicy.setBackOffPeriod(2000L);
        // retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

        // 指数回退，第一次回退0.2s，第二次回退0.4s
        ExponentialBackOffPolicy exponentialBackOffPolicy = new ExponentialBackOffPolicy();
        exponentialBackOffPolicy.setInitialInterval(1000L);
        exponentialBackOffPolicy.setMultiplier(2);
        retryTemplate.setBackOffPolicy(exponentialBackOffPolicy);


        // 重试策略,有多种重试策略
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(3);
        retryTemplate.setRetryPolicy(retryPolicy);

        retryTemplate.setThrowLastExceptionOnExhausted(false);

        return retryTemplate;
    }
}
