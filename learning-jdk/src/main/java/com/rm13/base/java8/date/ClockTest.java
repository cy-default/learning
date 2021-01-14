package com.rm13.base.java8.date;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2021/1/11
 */
public class ClockTest {

    public static void main(String[] args) throws Exception {
        // systemClock();
        // offsetClock();
        // tickDuration();
        fixedInstant();
    }

    /**
     * 1: 系统默认本地时钟SystemClock
     */
    public static void systemClock() {
        final Clock clock = Clock.systemDefaultZone();
        // 获取时区
        System.out.println(clock.getZone());
        // Asia/Shanghai

        final Instant instant = clock.instant();
        // 获取时间戳
        System.out.println(instant);
        // 2021-01-11T02:10:12.537Z

        System.out.println(instant.toEpochMilli());
        // 1610331187132
    }

    /**
     * 2: 偏移时钟OffsetClock
     */
    public static void offsetClock() {
        final Clock clock = Clock.systemDefaultZone();
        final Clock pastClock = Clock.offset(clock, Duration.ofMillis(-10000));

        System.out.println(pastClock.getZone());
        System.out.println(clock.millis() - pastClock.millis());
    }

    /**
     * 3: 周期计时的TickDuration，截取时间到最接近的上个周期或下个周期的时间。
     * 注意：TickDuration不会把当前时间点作为周期的起始时间
     * @throws InterruptedException
     */
    public static void tickDuration() throws InterruptedException {
        Clock clock = Clock.systemDefaultZone();
        Clock nearestHourClock = Clock.tick(clock, Duration.ofMillis(10));
        //当前时间是2021-01-03T05:36:54.088Z，周期是10毫秒，TickDuration自动
        //选择2021-01-03T05:36:54.090Z作为起始时间
        System.out.println(clock.instant());
        System.out.println(nearestHourClock.instant());
        Thread.sleep(10);
        System.out.println(clock.instant());
        System.out.println(nearestHourClock.instant());
    }

    /**
     * 时间不变的fixedInstant
     * @throws InterruptedException
     */
    public static void fixedInstant() throws InterruptedException {
        final Clock clock = Clock.systemDefaultZone();
        final Clock fixedClock = Clock.fixed(clock.instant(), ZoneId.systemDefault());
        System.out.println(fixedClock.instant());
        Thread.sleep(1000);
        System.out.println(fixedClock.instant());
    }


}
