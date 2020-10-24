package com.rm13.cloud.mdc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;

import java.util.concurrent.TimeUnit;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/10/24
 */
@Configuration
public class MdcConfiguration {

    @Bean
    public AsyncTaskExecutor taskExecutor() {
        final MdcThreadPoolTaskExecutor executor = MdcThreadPoolTaskExecutor.newWithInheritedMdc(8, 32, 1, TimeUnit.MINUTES, 1000);
        executor.setThreadNamePrefix("anno-executor");
        executor.initialize();
        return executor;
    }
}
