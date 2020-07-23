package com.rm13.date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-26
 */
public class DateTest {

    public static void main(String[] args) {

        LocalDate start = LocalDate.of(2019, 10, 12);
        LocalDate end = LocalDate.of(2020, 11, 13);

        System.out.println(start.toString());
        System.out.println(end.toString());


        // 398
        System.out.println(ChronoUnit.DAYS.between(start, end));
        // 398
        System.out.println((end.toEpochDay() - start.toEpochDay()));


        Period period = Period.between(start, end);
        // 1
        System.out.println(period.getDays());

        // 1
        System.out.println(period.getMonths());

        // 1
        System.out.println(period.getYears());



        String[] result = new String[]{"11","22","33"};
        System.out.println(String.join(",", result));

        System.out.println("===");
        System.out.println(LocalDate.now().getDayOfYear());
        System.out.println(LocalDate.of(2020, 01, 01).getDayOfYear());

    }
}
