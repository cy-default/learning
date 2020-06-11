package com.rm13.spring.ioc;

import com.rm13.spring.ioc.config.MainConfigOfLifeCycle;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * IOC容器Bean的生命周期
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
public class IOCTestOfLifeCycle {

    @Test
    public void test01(){
        // 1。创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        log.info("applicationContext容器创建完成。。。");
        // 2。关闭容器
        applicationContext.close();
    }
}
