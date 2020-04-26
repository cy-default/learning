package com.rm13.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private String phone;

    private Address address;

    public List<Country> tags;

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
