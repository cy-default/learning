package com.rm13.spring.config;

import com.rm13.spring.domain.entity.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * IOC容器 Bean的生命周期
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Configuration
@ComponentScan("com.rm13.spring.domain.entity")
public class MainConfigOfLifeCycle {

    @Bean(initMethod="init",destroyMethod = "detory")
    public Car car(){
        return new Car();
    }
}
