package com.rm13.base.reflect;

import com.rm13.optional.User;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/8
 */
public class ReflectTest {

    public static void main(String[] args) throws IllegalAccessException {
        Object ob = new User("张三", "17606119881");

        final Field[] declaredFields = ob.getClass().getDeclaredFields();
        Map<String,Field> names = new HashMap<>();
        for (Field declaredField : declaredFields) {
            names.put(declaredField.getName(), declaredField);
        }

        final Field phone = names.get("phone");
        phone.setAccessible(true);
        final Object value = phone.get(ob);
        System.out.println(value);
        phone.set(ob, "2122");
        System.out.println(ob);


    }
}
