package com.rm13.springboot.exception;

import lombok.Data;

/**
 * 业务类异常，不记录带有栈追踪信息的Exception；（fillInStackTrace性能慢50倍）
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-06-25
 */
@Data
public class BusinessException extends RuntimeException {

    private Integer code;

    private String message;

    /**
     * 仅包含message, 没有cause, 也不记录栈异常, 性能最高
     *
     * @param message
     */
    public BusinessException(Integer code, String message) {
        this(code, message, false);
    }

    /**
     * 包含message, 可指定是否记录异常
     *
     * @param message
     * @param recordStackTrace
     */
    public BusinessException(Integer code, String message, boolean recordStackTrace) {
        super(message, null, false, recordStackTrace);
        this.code = code;
        this.message = message;
    }


    /**
     * 包含message和cause, 会记录栈异常
     *
     * @param msg
     * @param cause
     */
    public BusinessException(String msg, Throwable cause) {
        super(msg, cause, false, true);
    }
}

