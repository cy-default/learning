package com.rm13.es.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/12/28
 */
@Data
public class User {
    private String name;
    private Integer age;
    private LocalDateTime createTime;
}
