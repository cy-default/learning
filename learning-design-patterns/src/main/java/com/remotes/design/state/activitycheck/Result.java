package com.remotes.design.state.activitycheck;

import lombok.Data;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/24
 */
@Data
public class Result {
    private String code;
    private String message;

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
