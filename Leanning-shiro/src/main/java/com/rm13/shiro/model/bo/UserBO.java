package com.rm13.shiro.model.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/23
 */
@Data
public class UserBO implements Serializable {

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
