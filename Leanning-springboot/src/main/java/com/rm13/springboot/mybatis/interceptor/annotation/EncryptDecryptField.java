package com.rm13.springboot.mybatis.interceptor.annotation;

import java.lang.annotation.*;

/**
 * <p>
 *    加密字典注解
 * <p>
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-09 19:08
 */
@Documented
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EncryptDecryptField {

}
