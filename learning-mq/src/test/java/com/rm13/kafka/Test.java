package com.rm13.kafka;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/26
 */
public class Test {

    public static void main(String[] args) {
        final LocalDate now = LocalDate.now();
        System.out.println(now.getDayOfYear());

        String MSG_PREFIX = "snmt:task:msg:%s:%s";

        System.out.println(String.format(MSG_PREFIX, 12, 300));


        final Duration between = Duration.between(LocalDateTime.parse("2020-11-30 22:11:11", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), LocalDateTime.now());
        System.out.println(between.toDays());

    }
}
