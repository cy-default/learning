package com.rm13.mybatis.entity;

import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-16
 */
@Builder
@Data
public class Employee {

    private Long id;
    private String lastName;
    private String gender;
    private String email;
}
