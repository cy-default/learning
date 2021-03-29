package com.rm13.cloud.exception;

import javax.annotation.Nullable;

/**
 * 断言（封装判断逻辑）
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/18
 */
public interface AssertUtil {


    /**
     * 创建异常
     *
     * @param args
     * @return
     */
    ServiceException newException(Object... args);

    /**
     * 创建异常
     *
     * @param t
     * @param args
     * @return
     */
    ServiceException newException(Throwable t, Object... args);


    /**
     * <p>断言对象<code>obj</code>非空。如果对象<code>obj</code>为空，则抛出异常
     *
     * @param obj 待判断对象
     */
    default void notNull(Object obj) {
        if (obj == null) {
            throw newException(obj);
        }
    }

    /**
     * <p>断言对象<code>obj</code>非空。如果对象<code>obj</code>为空，则抛出异常
     * <p>异常信息<code>message</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param obj 待判断对象
     * @param args message占位符对应的参数列表
     */
    default void notNull(Object obj, Object... args) {
        if (obj == null) {
            throw newException(args);
        }
    }


    /**
     * 参数不能为空
     *
     * @param object
     * @param message
     */
    public static void notNull(@Nullable Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
