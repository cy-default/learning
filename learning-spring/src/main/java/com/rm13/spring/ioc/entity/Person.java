package com.rm13.spring.ioc.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;


/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Getter
@Setter
public class Person {

    //使用@Value赋值；
    //1、基本数值
    //2、可以写SpEL； #{}
    //3、可以写${}；取出配置文件【properties】中的值（在运行环境变量里面的值）

    @Value("张三")
    private String name;
    @Value("#{20-2}")
    private Integer age;
    @Value("${person.nickName}")
    private String nickName;

    public Person() {
    }
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
