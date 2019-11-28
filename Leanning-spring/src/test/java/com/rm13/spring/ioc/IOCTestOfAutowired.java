package com.rm13.spring.ioc;

import com.alibaba.fastjson.JSON;
import com.rm13.spring.config.MainConfigOfAutowired;
import com.rm13.spring.config.MainConfigOfBeanDefinition01;
import com.rm13.spring.dao.BookDao;
import com.rm13.spring.domain.entity.Boss;
import com.rm13.spring.domain.entity.Car;
import com.rm13.spring.domain.entity.Color;
import com.rm13.spring.domain.entity.Person;
import com.rm13.spring.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * IOC容器bean依赖注入
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
public class IOCTestOfAutowired {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        BookService bookService = applicationContext.getBean(BookService.class);
        log.info("BookService:{}", bookService);

        // primary 校验
        BookDao bookDao1 = applicationContext.getBean(BookDao.class);
        log.info("BookDao:{}", bookDao1);
        Object bookDao2 = applicationContext.getBean("bookDao");
        log.info("BookDao:{}", bookDao2);


        // 构造函数 依赖注入
        Boss boss = applicationContext.getBean(Boss.class);
        log.info("boss:{}", boss);
        Car car = applicationContext.getBean(Car.class);
        log.info("car:{}", car);
        log.info("boss.car==car:{}", boss.getCar()==car);

        // @Bean 方法依赖注入
        Color color = applicationContext.getBean(Color.class);
        log.info("color:{}", color);
        log.info("color.car==car:{}", color.getCar()==car);
        applicationContext.close();

    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        // 构造函数 依赖注入
        Boss boss = applicationContext.getBean(Boss.class);
        log.info("boss:{}", boss);
        Car car = applicationContext.getBean(Car.class);
        log.info("car:{}", car);
        log.info("boss.car==car:{}", boss.getCar()==car);

        // @Bean 方法依赖注入
        Color color = applicationContext.getBean(Color.class);
        log.info("color:{}", color);
        log.info("color.car==car:{}", color.getCar()==car);
        applicationContext.close();
    }
}
