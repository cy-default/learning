package com.rm13.cloud.lock;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * redisLock redis分布式锁
 * aop处理程序
 *
 * @author yuan.chen
 * @see RedisLockedAspect
 * 返回结果
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RedisLocked {
    /**
     * 加锁失败消息
     */
    String value() default "其他用户正在操作，请稍后重试";

    /**
     * 锁键名 支持SPEL
     * 可直接使用方法参数名 如{@code #argName}
     */
    String key() default "lock";

    /**
     * 锁超时时长，单位 毫秒
     */
    long expire() default 30000;

    /**
     * 等待时长，单位 毫秒
     */
    long timeout() default 10000;

    /**
     * 等待时长，单位 毫秒
     */
    long sleep() default 100;

    /**
     * 当获取锁失败，是继续等待还是放弃
     */
    boolean isWait() default false;
}
