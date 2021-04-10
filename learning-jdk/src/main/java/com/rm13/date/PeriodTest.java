package com.rm13.date;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;

/**
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/19
 */
public class PeriodTest {

    /**
     * https://blog.csdn.net/hspingcc/article/details/73332526
     * 在Java8中，我们可以使用以下类来计算日期时间差异：
     * 1.Period : 计算日期
     * 2.Duration : 计算时间
     * 3.ChronoUnit : 指定单位内测量一段时间
     * @param args
     */

    public static void main(String[] args) {


        final LocalDate beg = LocalDate.of(2018, 05, 29);
        final LocalDate now = LocalDate.now();

        // Period类方法getYears（），getMonths（）和getDays（）来计算.
        final Period between = Period.between(beg, now);
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());

        //提供了使用基于时间的值（如秒，纳秒）测量时间量的方法。
        Instant inst1 = Instant.now();
        System.out.println("Inst1 : " + inst1);
        Instant inst2 = inst1.plus(Duration.ofSeconds(10));
        System.out.println("Inst2 : " + inst2);
        System.out.println("Difference in milliseconds : " + Duration.between(inst1, inst2).toMillis());
        System.out.println("Difference in seconds : " + Duration.between(inst1, inst2).getSeconds());

        //###### 优先使用下面这个！！！
        //ChronoUnit类可用于在单个时间单位内测量一段时间，例如天数或秒。
        System.out.println("开始时间  : " + beg);
        System.out.println("结束时间 : " + now);
        System.out.println("年："+ChronoUnit.YEARS.between(beg, now));
        System.out.println("月："+ChronoUnit.MONTHS.between(beg, now));
        System.out.println("周："+ChronoUnit.WEEKS.between(beg, now));
        System.out.println("天："+ChronoUnit.DAYS.between(beg, now));


        // 获取今年的第一天
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfYear()));
        // 获取今年的最后一天
        System.out.println(LocalDate.now().with(TemporalAdjusters.lastDayOfYear()));

        System.out.println("-----");
        LocalDateTime end1 = LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth()).atTime(LocalTime.MAX);
        LocalDateTime beg1 = LocalDate.now().minusMonths(12).with(TemporalAdjusters.firstDayOfMonth()).atTime(LocalTime.MIN);
        System.out.println(end1);
        System.out.println(beg1);

    }
}
