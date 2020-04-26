package com.rm13.spring.ioc;

import com.rm13.spring.aop.MathCalculator;
import com.rm13.spring.config.MainConfigOfAOP;
import com.rm13.spring.config.MainConfigOfAutowired;
import com.rm13.spring.dao.BookDao;
import com.rm13.spring.domain.entity.Boss;
import com.rm13.spring.domain.entity.Car;
import com.rm13.spring.domain.entity.Color;
import com.rm13.spring.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * AOP
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
public class IOCTestOfAOP {

    /**
     * 执行顺序： before -》 executor -》 after -》 afterRetruning/afterThrowing
     */
    @Test
    public void test01(){
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        final MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        final int div = mathCalculator.div(1, 1);
        applicationContext.close();

    }
}
