package com.rm13.spring.ext;

import com.rm13.spring.aop.service.ValueService;
import com.rm13.spring.ioc.config.MainConfigOfAutowired;
import com.rm13.spring.ioc.dao.BookDao;
import com.rm13.spring.ioc.entity.Boss;
import com.rm13.spring.ioc.entity.Car;
import com.rm13.spring.ioc.entity.Color;
import com.rm13.spring.ioc.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * IOC容器bean依赖注入
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
public class ValueTest {



    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ValueService.class);
        // 构造函数 依赖注入
        ValueService valueService = applicationContext.getBean(ValueService.class);
        log.info("boss:{}", valueService);
        applicationContext.close();

    }
}
