package com.rm13.cloud.domain.dto.user;

import com.rm13.cloud.domain.dto.role.RoleInfoDTO;
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
