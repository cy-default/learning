package com.rm13.optional;

import lombok.Data;
import lombok.Value;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-05
 */
@Data
@Value
public class User {

    private String name;
    private String phone;

    private Address address;

}
