package com.remotes.design;

import org.junit.Test;

import java.io.File;
import java.sql.SQLOutput;
import java.time.*;
import java.util.HashMap;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-20
 */
public class IoTest {


    @Test
    public void fileTest(){
        File file = new File("/Users/chenyuan/Documents/project/myself/java-design-patterns/src/test/java/com/remotes/design/ficcle");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.mkdirs());
        System.out.println(file.exists());
    }

    @Test
    public void t2(){
        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }


    @Test
    public void t3(){
        Byte bt = new Byte("1");
        System.out.println(Cc.WAITING.getCode().equals(bt));

        System.out.println("好".length());

        System.out.println("XLSX".equalsIgnoreCase("Xlsx"));
    }

    @Test
    public void t4(){
        LocalDateTime tomorrow = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(0,0));
        LocalDateTime today = LocalDateTime.now();
        Duration du = Duration.between(today,tomorrow);
        System.out.println(du.getSeconds());
    }

}
