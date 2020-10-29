package com.rm13.cloud.model.po;

import lombok.Data;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/3/20
 */
@Data
public class UserInfo {
    private String username;
    private String password;
    private List<RoleInfo> roleinfoList;
    private List<String> cc;
}
