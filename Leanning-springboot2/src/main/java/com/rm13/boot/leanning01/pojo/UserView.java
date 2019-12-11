package com.rm13.boot.leanning01.pojo;

import lombok.Data;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-12-11
 */
@Data
public class UserView {

    private Long id;

    private String firstName;

    private String lastName;

    private String city;

    private String state;

    private Long aid;
}
