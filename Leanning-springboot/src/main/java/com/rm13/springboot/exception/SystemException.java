package com.rm13.springboot.exception;

/**
 * 业务类异常，不记录带有栈追踪信息的Exception；（fillInStackTrace性能慢50倍）
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-06-25
 */
public class SystemException extends RuntimeException {

    /**
     * 仅包含message, 没有cause, 也不记录栈异常, 性能最高
     * @param message
     */
    public SystemException(String message) {
        this(message, false);
    }

    /**
     * 包含message, 可指定是否记录异常
     * @param msg
     * @param recordStackTrace
     */
    public SystemException(String msg, boolean recordStackTrace) {
        super(msg, null, false, recordStackTrace);
    }


    /**
     * 包含message和cause, 会记录栈异常
     * @param msg
     * @param cause
     */
    public SystemException(String msg, Throwable cause) {
        super(msg, cause, false, true);
    }
}

