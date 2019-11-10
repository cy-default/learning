package com.rm13.springboot.mybatis.interceptor.annotation;

import java.lang.annotation.*;

/**
 * <p>
 *    需要加解密的类注解
 * <p>
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-09 19:08
 */
@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EncryptDecryptClass {
}
