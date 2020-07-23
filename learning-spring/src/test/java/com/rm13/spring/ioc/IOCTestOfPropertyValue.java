package com.rm13.spring.ioc;

import com.alibaba.fastjson.JSON;
import com.rm13.spring.ioc.config.MainConfigOfPropertyValues;
import com.rm13.spring.ioc.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * IOC容器属性值设置
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
public class IOCTestOfPropertyValue {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
        printBeanDefinitionName(applicationContext);

        Person person = applicationContext.getBean(Person.class);
        log.info("person:{}", JSON.toJSONString(person));

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        log.info("property.person.nickName={}", property);
        applicationContext.close();

    }

    private void printBeanDefinitionName(AnnotationConfigApplicationContext applicationContext){
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            log.info("beanDefinitionName:{}", beanDefinitionName);
        }
    }
}
