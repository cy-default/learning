package com.rm13.cloud.login;

import java.lang.annotation.*;

/**
 * 无需登陆
 *
 * @author roamer
 * @version v1.0
 * @date 2019/12/26 14:22
 * @see com.rm13.cloud.login.LoginUserInterceptor
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
@Documented
public @interface PassLogin {
}
