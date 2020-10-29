package com.rm13.cloud.model.base;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/18
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -4696898674758059398L;
    private int code;
    private String message;
    private T data;
    private boolean ok = true;

    public Result(int code, String message, T data) {
        this.code = code;
        this.ok = code == 200;
        this.message = message;
        if (null != data) {
            this.data = data;
        }

    }

    public Result(int code, T data) {
        this.code = code;
        this.ok = code == 200;
        this.data = data;
    }

    public Result(T data) {
        this.data = data;
    }

    public Result() {
    }

    public static <T> Result<T> success() {
        return new Result(200, (String)null, (Object)null);
    }

    public static <T> Result<T> success(T data) {
        return new Result(200, data);
    }

    public static <T> Result<T> success(T data, String message) {
        return new Result(200, message, data);
    }

    public static <T> Result<T> error(String message) {
        return new Result(500, message, (Object)null);
    }

    public static <T> Result<T> error(int code, String message) {
        Result<T> resultResponse = new Result();
        resultResponse.setOk(Boolean.FALSE);
        resultResponse.setCode(code);
        resultResponse.setMessage(message);
        return resultResponse;
    }

    public static <T> Result<T> bizError(String message) {
        return new Result(9999, message, (Object)null);
    }

    public static <T> Result<T> custom(int code, String message) {
        return new Result(code, message, (Object)null);
    }

    public static <T> Result<T> custom(int code, String message, T data) {
        return new Result(code, message, data);
    }
}
