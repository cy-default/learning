package com.rm13.spring.config;

import com.rm13.spring.domain.entity.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-10
 */
@Configuration
@ComponentScan("com.rm13.spring.ext")
public class MainconfigOfExt {

    @Bean
    public Blue blue(){
        return new Blue();
    }
}
