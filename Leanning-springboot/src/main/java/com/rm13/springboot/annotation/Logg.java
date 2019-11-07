package com.rm13.springboot.annotation;

import java.lang.annotation.*;

/**
 * @author lovemyrmb
 * @Description: 记录操作日志(基于注解)
 * @date 2018-10-31 14:15
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Logg {
    String value() default "";
}
