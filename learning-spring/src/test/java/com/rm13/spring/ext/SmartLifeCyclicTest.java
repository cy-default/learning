package com.rm13.spring.ext;

import com.rm13.spring.ioc.config.ExpandRunConfig;
import com.rm13.spring.ioc.ext.SmartLifeCyclicService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/8/24
 */
public class SmartLifeCyclicTest {

    @Test
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SmartLifeCyclicService.class);
        SmartLifeCyclicService service = applicationContext.getBean(SmartLifeCyclicService.class);
        System.out.println(service.getClass());

    }
}
