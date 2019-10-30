package com.rm13.annotations;

import java.lang.annotation.*;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-04
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AnnotationDemo {
    String value() default "1";
    String name() default "2";
}
