package com.rm13.cloud.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/25
 */
@Slf4j
@Service
public class RetryServiceImpl implements RetryService {

    @Autowired
    private RetryTemplate retryTemplate;

    /**
     * 第一种 基于注解方式的重试
     * @param sql
     * @return
     */
    @Retryable(
            value = {Exception.class },
            maxAttempts = 2,
            backoff = @Backoff(delay = 5000))
    @Override
    public String annotationRetryService(String sql) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        log.info("retryService:{},{},{}", Thread.currentThread().getName(),uuid, sql);
        if(true){
            throw new RuntimeException(uuid);
        }
        return uuid;
    }


    /**
     * 第二种,用户自定义重试机制
     * @param sql
     * @return
     */
    @Override
    public String custRetryService(String sql) {

        String result = retryTemplate.execute(context -> {
            // 这里写我们的业务代码
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            log.info("custRetryService.RetryCallback:{},{}", uuid, sql);
            // 模拟抛出异常
            if (true) {
                throw new RuntimeException("异常");
            }
            return uuid;
        }, context -> {
            log.error("custRetryService.recover:{}", context.getLastThrowable().getMessage());
            return "recover".concat(sql);
        });
        return result;
    }


    /**
     *
     * @param e 第一个参数对应retryService抛出的异常
     * @param sql 第二个参数对应retryService的方法参数
     */
    @Recover
    @Override
    public String recover(Exception e, String sql) {
        log.error("recover:{},{}",Thread.currentThread().getName(), e.getMessage());
        return "recover".concat(sql);
    }
}
