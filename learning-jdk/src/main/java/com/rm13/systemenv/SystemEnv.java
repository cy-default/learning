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
        // 类所在的目录
        // /Users/chenyuan/Documents/project/collect/Leanning/Leanning-jdk/target/classes/com/rm13/systemenv/
        System.out.println(SystemEnv.class.getResource("").getPath());
        // 根目录
        // /Users/chenyuan/Documents/project/collect/Leanning/Leanning-jdk/target/classes/
        System.out.println(SystemEnv.class.getResource("/").getPath());

    }


    public static void env1(){
        System.out.println(System.getProperties());
        System.out.println("1.env1111111111111111111");
        Properties properties = System.getProperties();
        System.out.println(properties.get("ccc"));
        System.out.println(System.getenv());
        System.out.println("2.env1111111111111111111");
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
