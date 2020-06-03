package com.rm13.cloud.result;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/18
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultResponse<T> implements Serializable {
    private static final long serialVersionUID = -4696898674758059398L;
    private int code;
    private String message;
    private T data;
    private boolean ok = true;

    public ResultResponse(int code, String message, T data) {
        this.code = code;
        this.ok = code == 200;
        this.message = message;
        if (null != data) {
            this.data = data;
        }

    }

    public ResultResponse(int code, T data) {
        this.code = code;
        this.ok = code == 200;
        this.data = data;
    }

    public ResultResponse(T data) {
        this.data = data;
    }

    public ResultResponse() {
    }

    public static <T> ResultResponse<T> success() {
        return new ResultResponse(200, (String)null, (Object)null);
    }

    public static <T> ResultResponse<T> success(T data) {
        return new ResultResponse(200, data);
    }

    public static <T> ResultResponse<T> success(T data, String message) {
        return new ResultResponse(200, message, data);
    }

    public static <T> ResultResponse<T> error(String message) {
        return new ResultResponse(500, message, (Object)null);
    }

    public static <T> ResultResponse<T> error(int code, String message) {
        ResultResponse<T> resultResponse = new ResultResponse();
        resultResponse.setOk(Boolean.FALSE);
        resultResponse.setCode(code);
        resultResponse.setMessage(message);
        return resultResponse;
    }

    public static <T> ResultResponse<T> bizError(String message) {
        return new ResultResponse(9999, message, (Object)null);
    }

    public static <T> ResultResponse<T> custom(int code, String message) {
        return new ResultResponse(code, message, (Object)null);
    }

    public static <T> ResultResponse<T> custom(int code, String message, T data) {
        return new ResultResponse(code, message, data);
    }
}
