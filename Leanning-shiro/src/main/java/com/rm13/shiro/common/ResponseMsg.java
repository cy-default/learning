package com.rm13.shiro.common;

import lombok.Data;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/23
 */
@Data
public class ResponseMsg<T> {
    private T data;
    private String msg;
    private int status;

    public static ResponseMsg success(){
        ResponseMsg result = new ResponseMsg();
        result.setStatus(200);
        return result;
    }

    public static <T> ResponseMsg success(T data){
        ResponseMsg result = new ResponseMsg();
        result.setData(data);
        result.setStatus(200);
        return result;
    }

    public static <T> ResponseMsg error(String msg){
        ResponseMsg result = new ResponseMsg();
        result.setStatus(500);
        result.setMsg(msg);
        return result;
    }

    public static <T> ResponseMsg error(String msg, int status){
        ResponseMsg result = new ResponseMsg();
        result.setStatus(status);
        result.setMsg(msg);
        return result;
    }
}
