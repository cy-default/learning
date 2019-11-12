package com.rm13.optional;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-05
 */
public class OptionalTest {

    public static void main(String[] args) {

        demo2();
    }

    /**
     * 利用Optional进行多级判断
     */
    public void multilevel(){
        User user = new User();
        // old
        if(user!=null){
            if(user.getAddress()!=null){
                // ....
            }
        }
        // new
        boolean present = Optional.ofNullable(user).map(User::getAddress).map(Address::getEmail).isPresent();

    }

    /**
     * 判断对象中的list
     */
    public void checkObjectList(){
        Optional.ofNullable(new User()).map(User::getTags).map(tags->tags.stream().map(Country::getCity).collect(Collectors.toList())).ifPresent(t-> System.out.println(t));
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
