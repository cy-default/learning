package com.rm13.spring.ioc;

import com.rm13.spring.aop.MathCalculator;
import com.rm13.spring.config.MainConfigOfAOP;
import com.rm13.spring.config.MainconfigOfExt;
import com.rm13.spring.ext.MyApplicationEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-10
 */
@Slf4j
public class IOCTestOfExt {

    @Test
    public void test() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainconfigOfExt.class);

        //发布事件；
        applicationContext.publishEvent(new MyApplicationEvent(new String("我发布的时间")) {
        });

        applicationContext.close();
    }
}