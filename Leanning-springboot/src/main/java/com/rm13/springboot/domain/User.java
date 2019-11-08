package com.rm13.springboot.domain;

import lombok.Data;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-07
 */
@Data
public class User {
    private Long id;
    private String name;
    private String address;
    private String openId;
    private String unionId;
}
