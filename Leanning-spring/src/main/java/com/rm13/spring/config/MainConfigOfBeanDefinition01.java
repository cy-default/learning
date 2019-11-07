package com.rm13.spring.config;

import com.rm13.spring.domain.entity.Blue;
import com.rm13.spring.domain.entity.Person;
import com.rm13.spring.domain.entity.Red;
import com.rm13.spring.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;

import java.lang.reflect.AnnotatedType;


/**
 *
 * @ComponentScan  value:指定要扫描的包
 * excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
 * includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
 * FilterType.ANNOTATION：按照注解
 * FilterType.ASSIGNABLE_TYPE：按照给定的类型；
 * FilterType.ASPECTJ：使用ASPECTJ表达式
 * FilterType.REGEX：使用正则指定
 * FilterType.CUSTOM：使用自定义规则
 */

// 配置类==配置文件, 告诉Spring这是一个配置类
@Configuration
@ComponentScans({@ComponentScan(value = "com.rm13.spring", includeFilters = {
        /*
        @Filter(type=FilterType.ANNOTATION, classes = {Controller.class}),
        @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
         */
        @Filter(type = FilterType.CUSTOM, classes ={MyTypeFilter.class} )
}, useDefaultFilters = false)})
public class MainConfigOfBeanDefinition01 {

    /**
     * 给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
     * @return
     */
    @Bean
    public Person person01(){
        return new Person("person01", 20);
    }

    /**
     * 指定bean的名称， 并且标记未首选bean，通过类型获取的是该首选bean
     * @return
     */
    @Primary
    @Bean("person")
    public Person person02(){
        return new Person("person02", 20);
    }
}
