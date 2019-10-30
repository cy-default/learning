package com.rm13.optional;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-05
 */
public class OptionalTest {

    public static void main(String[] args) {

        demo2();
    }

    public static void demo2(){
        User user = null;
        Optional.ofNullable(user).map(u->u.getName()).filter(StringUtils::isNotBlank).orElseGet(()->{
            System.out.println("hhhh");
            return null;
        });

    }


    public static void demo1(){
        Demo demo1 = null;

        Optional<Demo> optional1 = Optional.ofNullable(demo1);
        optional1.ifPresent(t-> System.out.println(t));
        System.out.println(optional1.orElse(new Demo("dd")));

        System.out.println(optional1.map(t -> t.getName()).orElse("lovemyrmb@aliyun.com"));

        demo1 = new Demo("cc");
        optional1 = Optional.ofNullable(demo1);
        optional1.ifPresent(t-> System.out.println(t));

        System.out.println(optional1.orElse(new Demo("dd")));
    }
}
