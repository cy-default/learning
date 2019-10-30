package com.rm13.systemenv;

import java.io.InputStream;
import java.util.*;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-19
 */
public class SystemEnv {

    private static final String CLASS_PATH = "java.class.path";


    public static void main(String[] args) {

        env1();
        System.out.println("============================");
        env2();
        System.out.println("============================");
        env3();
        System.out.println("============================");
        joiner();
    }


    public static void env3(){
        System.out.println(SystemEnv.class.getResource("").getPath());
    }


    public static void env1(){
        System.out.println(System.getProperties());
        Properties properties = System.getProperties();
        System.out.println(System.getenv());
        Properties properties1 = Optional.ofNullable(System.getProperties()).orElseThrow(() -> new RuntimeException());
        joiner();
    }

    public static void env2(){
        Properties properties = System.getProperties();
        Iterator<Map.Entry<Object, Object>> iterator = properties.entrySet().iterator();
        while(iterator.hasNext()){
            final Map.Entry<Object, Object> next = iterator.next();
            if (CLASS_PATH.equals(next.getKey())){
                final String value = ((String) next.getValue());
                System.out.println(CLASS_PATH+"=");
                String[] split = value.split(":");
                for (String sp: split){
                    System.out.println("    "+sp);
                }
                continue;
            }
            System.out.println(next);

        }

    }


    public static void joiner(){
        StringJoiner stringJoiner = new StringJoiner(",","'","'");

        System.out.println(String.join("','", "1", "1", "1", "1", "1", "1"));

    }
}
