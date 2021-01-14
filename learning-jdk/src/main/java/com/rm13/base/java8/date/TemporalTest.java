package com.rm13.base.java8.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * 时间类的统一接口，定义一些通用的方法操作，如：某时间单位的加减，设置时间域为某一固定值
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2021/1/13
 */
public class TemporalTest {

    public static void main(String[] args) {
//        instantCreate();
//        instantUser();
//        localTimeCreate();
//        localTimeUser();
//        localDateCreate();
//        localDateUser();
        localDateTimeUser();
    }

    /**
     * 时间戳创建
     */
    public static void instantCreate() {
        Instant instant = Instant.now();
        System.out.println(instant);
        instant = Instant.now(Clock.systemDefaultZone());
        System.out.println(instant);
        // 和Date相互转换
        instant = Instant.ofEpochMilli(new Date().getTime());
        System.out.println(instant);
        // 根据字符串生成时间。支持到纳秒级别
        instant = Instant.parse("2021-01-13T08:24:14.796Z");
        System.out.println(instant);
        // 根据秒和偏差的纳秒创建时间戳
        // 2021-01-04T06:25:58.000000001Z
        instant = Instant.ofEpochSecond(1609741558, 1);
        System.out.println(instant);
        // 过去时间和当前时间的相差值，可以指定单位TemporalUnit
        System.out.println(instant.until(Instant.now(), ChronoUnit.DAYS));
    }

    /**
     * instant使用
     */
    public static void instantUser() {
        Instant instant = Instant.now();
        //设置时区为America/El_Salvador(美国)
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("America/El_Salvador"));
        System.out.println(zonedDateTime);
        // 设置时区为偏移-6的时区（美国）
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(-6));
        System.out.println(offsetDateTime);

        final Instant fixInstant = instant.minus(1, ChronoUnit.MINUTES)
                .plus(2, ChronoUnit.DAYS);
        System.out.println(instant);
        System.out.println(fixInstant);
    }

    /**
     * LocalTime是用来操作时分秒的类，外加精确到纳秒级别；无时区概念，转Instant需要先设置时区
     * <p>
     * LocalTime创建
     */
    public static void localTimeCreate() {
        // 1的单位是纳秒
        LocalTime localTime = LocalTime.of(12, 12, 12, 1);
        System.out.println(localTime);

        localTime = LocalTime.ofSecondOfDay(60 * 60 * 12 + 60 * 12);
        System.out.println(localTime);

        localTime = LocalTime.parse("12:12:12", DateTimeFormatter.ISO_TIME);
        System.out.println(localTime);
    }

    /**
     * LocalTime的常用处理方法
     */
    public static void localTimeUser() {
        LocalTime localTime = LocalTime.of(12, 12, 12, 1);
        System.out.println(localTime);
        //拼接日期，生成日期时间
        LocalDateTime localDateTime = localTime.atDate(LocalDate.now());
        System.out.println(localDateTime);

        // 设定时区，时间量不变
        OffsetTime offsetTime = LocalTime.now().atOffset(ZoneOffset.ofHours(-6));
        System.out.println(offsetTime);
    }

    /**
     * LocalDate的创建示例
     */
    public static void localDateCreate() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        localDate = LocalDate.of(2020, 3, 19);
        System.out.println(localDate);
        localDate = LocalDate.parse("20201011", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(localDate);
    }

    /**
     * LocalDate的创建使用
     */
    public static void localDateUser() {
        LocalDate localDate = LocalDate.parse("2020-11-11", DateTimeFormatter.ISO_DATE);
        System.out.println("当前年的第几天:" + localDate.getDayOfYear() + "; 当前月的第几天" + localDate.getDayOfMonth() + "; 当前星期几:" + localDate.getDayOfWeek() + "; 当前星期几:" + localDate.getDayOfWeek());
        localDate = LocalDate.now();
        System.out.println("当前年的第几天:" + localDate.getDayOfYear() + "; 当前月的第几天" + localDate.getDayOfMonth() + "; 当前星期几:" + localDate.getDayOfWeek() + "; 当前星期几:" + (localDate.getDayOfWeek().ordinal() + 1));

        LocalDateTime localDateTime = localDate.atTime(LocalTime.now());
        System.out.println(localDateTime);
    }

    /**
     * LocalDateTime构造示例
     */
    public static void localDateTimeCreate() {
        LocalDateTime dateTime = LocalDateTime.of(2021, 3, 19, 12, 12, 12, 01);
        System.out.println(dateTime);
        dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println(dateTime);
        dateTime = LocalDateTime.parse("2021-03-19 12:12:12", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(dateTime);
    }

    /**
     * LocalDateTime操作示例
     */
    public static void localDateTimeUser() {
        LocalDateTime dateTime = LocalDateTime.now();
        //设置偏移时区为-6
        OffsetDateTime offsetDateTime = dateTime.atOffset(ZoneOffset.ofHours(-6));
        System.out.println(offsetDateTime);
        //设置时区为美国时区
        ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.of("America/El_Salvador"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.toEpochSecond());
        //输出LocalDateTime的时间戳，因为LocalDateTime是不带时区的，需要指定时区
        System.out.println(dateTime.toEpochSecond(ZoneOffset.ofHours(0)));


        System.out.println(dateTime.getDayOfWeek().ordinal() + 1);
        System.out.println(dateTime.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
        System.out.println(dateTime.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
    }


}
