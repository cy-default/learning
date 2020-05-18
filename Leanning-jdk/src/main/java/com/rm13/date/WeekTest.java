package com.rm13.date;

import java.time.LocalDate;
import java.time.temporal.WeekFields;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/14
 */
public class WeekTest {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate beg = now.minusDays(now.getDayOfWeek().getValue()).plusDays(1);
        LocalDate end = now.minusDays(now.getDayOfWeek().getValue()).plusDays(7);

        int weekOfYear = beg.get(WeekFields.ISO.weekOfYear());
        System.out.println(weekOfYear);
        System.out.println(now.get(WeekFields.ISO.weekOfYear()));
        System.out.println(end);
        System.out.println(end.get(WeekFields.ISO.weekOfYear()));
    }
}
