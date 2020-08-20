package com.rm13.spring.ext;

import com.alibaba.fastjson.JSON;
import com.rm13.spring.ioc.config.ExpandRunConfig;
import com.rm13.spring.ioc.config.MainConfigOfBeanDefinition01;
import com.rm13.spring.ioc.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * configuration 详解
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
public class ConfigurationTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExpandRunConfig.class);
        ExpandRunConfig runConfig = applicationContext.getBean(ExpandRunConfig.class);
        System.out.println(runConfig.getClass());


    }
}
