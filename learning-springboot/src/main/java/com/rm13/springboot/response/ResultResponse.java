package com.rm13.springboot.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author lovemyrmb
 * @Description: 统一异常处理
 * code: -1 代表系统错误, 0 代表正确, 正整数代表具体的错误
 * @date 2018-11-02 17:32
 */
@Data
public class ResultResponse<T> implements Serializable {
    private int code;
    private String msg;
    private T data;


    public static ResultResponse error(int code, String message) {
        ResultResponse ResultResponse = new ResultResponse();
        ResultResponse.setCode(code);
        ResultResponse.setMsg(message);
        return ResultResponse;
    }

    public static ResultResponse success() {
        ResultResponse ResultResponse = new ResultResponse();
        ResultResponse.setCode(0);
        ResultResponse.setMsg("success");
        return ResultResponse;
    }

    public static <T> ResultResponse<T> success(T data) {
        ResultResponse ResultResponse = new ResultResponse();
        ResultResponse.setCode(0);
        ResultResponse.setMsg("success");
        ResultResponse.setData(data);
        return ResultResponse;
    }
}
