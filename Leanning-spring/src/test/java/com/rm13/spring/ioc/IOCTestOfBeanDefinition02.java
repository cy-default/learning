package com.rm13.spring.ioc;

import com.alibaba.fastjson.JSON;
import com.rm13.spring.config.MainConfigOfBeanDefinition02;
import com.rm13.spring.domain.entity.Blue;
import com.rm13.spring.domain.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * IOC容器bean定义02
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
public class IOCTestOfBeanDefinition02 {


    /**
     * 查看bean的beanDefinition
     */
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfBeanDefinition02.class);
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            log.info("beanDefinitionName:{}",beanDefinitionName);
        }
    }


    /**
     * Bean实例作用域
     *  singleton: 每次获取就是直接从容器（map.get()）中拿.
     *  prototype: 每次获取的时候会调用方法创建对象；
     */
    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfBeanDefinition02.class);
        // 单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。以后每次获取就是直接从容器（map.get()）中拿.
        Person person1 = (Person)applicationContext.getBean("singleton");
        Person person2 = (Person)applicationContext.getBean("singleton");
        log.info("person 单例模式:{},{},{}", person1==person2, person1, person2);

        // 多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。每次获取的时候才会调用方法创建对象；
        Person person01 = (Person)applicationContext.getBean("prototype");
        Person person02 = (Person)applicationContext.getBean("prototype");
        log.info("person 原型模式:{},{},{}", person01==person02, person01, person02);

    }

    /**
     * Condtional 条件bean加载判定
     * 仅加载 MacCondition装饰的类型， 和默认的类
     */
    @Test
    public void test03(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfBeanDefinition02.class);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String properties = environment.getProperty("os.name");
        log.info("os.name:{}", properties);
        for (String name : beanNamesForType) {
            log.info("beanNamesForType:{}", name);
        }
        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        log.info("beansOfType:{}", JSON.toJSONString(beansOfType));
    }

    /**
     * testImport
     * 给容器中注册组件
     */
    @Test
    public void test04(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfBeanDefinition02.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            log.info("beanDefinitionName:{}",name);
        }
        Blue blue = applicationContext.getBean(Blue.class);
        log.info("blue:{}", blue);

        //工厂Bean获取的是调用getObject创建的对象
        Object colorFactoryBean01 = applicationContext.getBean("colorFactoryBean");
        Object colorFactoryBean02 = applicationContext.getBean("colorFactoryBean");
        log.info("bean的类型:{}", colorFactoryBean01.getClass());
        log.info("colorFactoryBean01==colorFactoryBean02:{}",colorFactoryBean01==colorFactoryBean02);

        //工厂Bean获取
        Object bean4 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(bean4.getClass());
    }
}
