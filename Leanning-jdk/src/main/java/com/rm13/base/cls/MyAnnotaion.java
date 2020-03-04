package com.rm13.base.cls;

import java.lang.annotation.*;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/1/10
 */
@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyAnnotaion {
    String value();
}
