package com.rm13.boot.leanning01.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/3/20
 */
@Data
public class UserInfoDTO {
    private String username;
    private String password;
    private List<RoleInfoDTO> roleInfoDTOList;
    private List<String> cc;
}
