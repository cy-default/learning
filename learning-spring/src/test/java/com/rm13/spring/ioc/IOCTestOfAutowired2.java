package com.rm13.spring.ioc;

import com.rm13.spring.ioc.autowired.Config;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;

/**
 * 1： @Order注解定义的bean的执行顺序，而非加载顺序，加载是根据扫描到的类来加载的
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/8/5
 */
@Slf4j
public class IOCTestOfAutowired2 {

    /**
     *  @Order注解定义的bean的执行顺序，而非加载顺序，加载是根据扫描到的类来加载的
     */
    @Test
    public void test(){

        final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);
        final String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            final Object bean = annotationConfigApplicationContext.getBean(beanDefinitionName);
            System.out.println(bean.getClass());
            System.out.println(bean.toString());
            System.out.println("=============");
        }
    }

    /**
     * order 对 beanpostprocessor / lisenter 在执行的时候是有效的。通过AnnotationAwareOrderComparator.sort来排序
     */
    @Test
    public void test2(){

        final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);
        final ApplicationEventMulticaster bean = annotationConfigApplicationContext.getBean(ApplicationEventMulticaster.class);
        final ApplicationEvent applicationEvent = new ApplicationEvent("111") {
            @Override
            public Object getSource() {
                return super.getSource();
            }

            @Override
            public String toString() {
                return super.toString();
            }
        };
        bean.multicastEvent(applicationEvent);
    }
}
