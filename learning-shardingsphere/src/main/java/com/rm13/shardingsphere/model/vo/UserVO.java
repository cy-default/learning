package com.rm13.shardingsphere.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/21
 */
@Data
public class UserVO implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private String name;

    private String nickName;

    private Integer age;

    private String address;

    private String createBy;

    private LocalDateTime createTime;

    private String modifyBy;

    private LocalDateTime modifyTime;

    private Integer deleteFlag;
}
