package com.rm13.util;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-30
 */
public class IOTest {

    private static final String CLASS_PATH = "java.class.path";

    public static void main(String[] args) {
        printClasspath(System.getProperties());
    }

    @Test
    public void defaultIOPath(){
        System.out.println(System.getProperties().get("java.io.tmpdir"));
        System.out.println(System.getenv().get("java.io.tmpdir"));
        System.out.println(System.getProperties().get("file.encoding"));
        System.out.println(System.getenv());
        System.out.println(System.getProperties());
    }

    private static void printClasspath(Properties properties){
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
}
