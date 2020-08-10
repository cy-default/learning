package com.rm13.cloud.exception;

import lombok.Data;

/**
 * 业务类异常，不记录带有栈追踪信息的Exception；（fillInStackTrace性能慢50倍）/ 可以重写fillInStackTrace
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-06-25
 */
@Data
public class CustomException extends RuntimeException {

    private Integer code;
    private String message;

    /**
     * 仅包含message, 没有cause, 也不记录栈异常, 性能最高
     *
     * @param message
     */
    public CustomException(Integer code, String message) {
        this(code, message, false);
    }

    /**
     * 包含message, 可指定是否记录异常
     *
     * @param msg
     * @param recordStackTrace
     */
    public CustomException(Integer code, String msg, boolean recordStackTrace) {
        super(msg, null, false, recordStackTrace);
        this.code = code;
        this.message = msg;
    }


    /**
     * 包含message和cause, 会记录栈异常
     *
     * @param msg
     * @param cause
     */
    public CustomException(Integer code, String msg, Throwable cause) {
        super(msg, cause, false, true);
    }


    /**
     * 重写fillInStackTrace
     * 避免对异常进行昂贵且无用的堆栈跟踪
     *
     * @return
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
