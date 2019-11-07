package com.rm13.spring.config;

import com.rm13.spring.domain.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中;
 * 加载完外部的配置文件以后使用${}取出配置文件的值
 */
@Slf4j
@PropertySource(value={"classpath:/person.properties"}, ignoreResourceNotFound = true)
@Configuration
public class MainConfigOfPropertyValues {

    @Bean
    public Person person(){
        return new Person();
    }
}
