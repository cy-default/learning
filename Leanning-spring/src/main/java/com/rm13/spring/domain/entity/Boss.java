package com.rm13.spring.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Getter
@Setter
@ToString
@Component
public class Boss {

    /**
     * @Autowired
     * 	标注在方法，Spring容器创建当前对象，就会调用方法，完成赋值；
     * 	方法使用的参数，自定义类型的值从ioc容器中获取
     */
    private Car car;

    /**
     * 构造器要用的组件，都是从容器中获取
     * @param car1
     * @param car2
     * @param car3
     */
    public Boss(Car car1, Car car2, Car car3){
        System.out.println("Boss init:"+car1+","+car1+","+car1);
        this.car = car1;
        System.out.println("Boss...有参构造器");
    }
}
