package com.rm13.shiro.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/24
 */
@Getter
public enum ResultCode {
    C200(200, "操作成功"),
    C401(401, "未授权"),
    C403(403, "访问受限"),
    C404(404, "资源未找到"),
    C400(400, "参数列表错误"),
    C500(500, "系统内部错误"),
    C301(301, "资源已被移除"),
    C303(303, "重定向"),
    C501(501, "接口未实现"),
    C429(429, "请求过多被限制"),
    C9999(9999, "业务异常"),
    C415(415, "不支持的数据（媒体类型）");

    private int code;
    private String desc;

    ResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ResultCode getEnum(int code){
        for (ResultCode result : values()){
            if(result.code==code){
                return result;
            }
        }
        return C200;
    }

    public static String getDesc(int code){
        for (ResultCode result : values()){
            if(result.code==code){
                return result.getDesc();
            }
        }
        return "";
    }
}

