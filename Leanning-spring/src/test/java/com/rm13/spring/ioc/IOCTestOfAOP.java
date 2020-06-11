package com.rm13.spring.ioc;

import com.rm13.spring.ioc.aop.MathCalculator;
import com.rm13.spring.ioc.config.MainConfigOfAOP;
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
