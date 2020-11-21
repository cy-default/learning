package com.rm13.shardingsphere.model.query;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/21
 */
@Data
public class UserQuery implements Serializable {

    private String username;
}
