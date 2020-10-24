package com.rm13.base;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    }
}
