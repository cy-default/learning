package com.rm13.spring.ioc;

import com.rm13.spring.ioc.config.MainConfigOfExt;
import com.rm13.spring.ioc.ext.MyApplicationEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 发布事件
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
public class IOCTestOfExt {


    /**
     * 发布事件有两种监听方式
     * 1：实现Listener，并加入到容器
     *      class MyApplicationListener implements ApplicationListener<MyApplicationEvent>
     * 2：在Bean中方法上添加注解
     *      @EventListener(classes={MyApplicationEvent.class})
     */
    @Test
    public void test01(){
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfExt.class);
        applicationContext.publishEvent(new MyApplicationEvent("myapplicationEvent"));

        applicationContext.close();
    }
}
