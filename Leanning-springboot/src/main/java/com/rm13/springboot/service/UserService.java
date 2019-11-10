package com.rm13.springboot.service;

import com.rm13.springboot.domain.User;
import com.rm13.springboot.exception.AuthenticationException;
import com.rm13.springboot.exception.BusinessException;
import com.rm13.springboot.security.UserSecurity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-08
 */
@Service
public class UserService {

    public User currentUser(String unionId){
        if(StringUtils.isBlank(unionId)){
            throw new AuthenticationException();
        }
        User user = new User();
        user.setId(1L);
        user.setName("lovemyrm13");
        user.setOpenId("ofI3owGOlf6L2xuP4vrD4fSJzqcc");
        user.setUnionId("ofI3owGOlf6L2xuP4vrD4fSJzqcc");
        return user;
    }
}
