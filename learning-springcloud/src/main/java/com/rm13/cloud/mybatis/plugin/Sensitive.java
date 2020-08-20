package com.rm13.cloud.mybatis.plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/8/12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Sensitive {
    SensitiveStrategy strategy();
}
