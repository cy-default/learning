package com.rm13.cloud.mybatis.plugin;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/8/12
 */
@Data
public class UserInfo implements Serializable {
    private Long userId;
    @Sensitive(strategy = SensitiveStrategy.USERNAME)
    private String name;
    private Integer age;
}
