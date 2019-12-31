package com.rm13.shiro.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/23
 */
@Data
public class UserVO implements Serializable {
    /**
     *
     */
    private String name;

    /**
     *
     */
    private String nickName;

    /**
     *
     */
    private Integer age;

    /**
     *
     */
    private String address;
}
