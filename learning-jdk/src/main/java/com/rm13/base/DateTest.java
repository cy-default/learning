package com.rm13.base;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/10/14
 */
public class DateTest {

    public static void main(String[] args) {
        LocalDateTime beg = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()).atTime(LocalTime.MIN);
        LocalDateTime end = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).atTime(LocalTime.MAX);

        System.out.println(beg);
        System.out.println(end);

        final LocalDate now = LocalDate.now();
        System.out.println(now.toEpochDay());
        final LocalDate begDate = LocalDate.of(1970, 1, 1);
        System.out.println(begDate.toEpochDay());


        System.out.println("-------");
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));

    }
}
