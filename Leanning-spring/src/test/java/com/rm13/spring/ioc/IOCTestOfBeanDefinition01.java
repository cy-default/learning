package com.rm13.spring.ioc;

import com.alibaba.fastjson.JSON;
import com.rm13.spring.config.MainConfigOfBeanDefinition01;
import com.rm13.spring.domain.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * IOC容器bean定义01
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
public class IOCTestOfBeanDefinition01 {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfBeanDefinition01.class);
        Person bean = applicationContext.getBean(Person.class);
        log.info("Person:{}",JSON.toJSONString(bean));
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : beanNamesForType) {
            log.info("Person:{}",name);
        }

        log.info("=============================");
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            log.info("beanDefinitionName:{}; bean:{}", beanDefinitionName, JSON.toJSONString(applicationContext.getBean(beanDefinitionName)));
        }
    }
}
