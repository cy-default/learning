package com.rm13.cloud.controller;

import com.rm13.cloud.common.annotation.PassLogin;
import com.rm13.cloud.domain.dto.user.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * 校验用户登陆逻辑
 *
 * 为了实现解耦，
 * 需要把当前登陆的用户信息 从controll层一直传递下去
 *
 * @see com.rm13.cloud.login.LoginUserArgumentResolver
 * @see com.rm13.cloud.login.LoginUserInterceptor
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/18
 */
@RestController
@RequestMapping("/auth")
public class LoginController {


    @GetMapping("/user1")
    public UserDTO business1(@RequestParam(value = "name", required = false)String name, UserDTO userDTO){
        userDTO.setCurrentTime(LocalDateTime.now());
        return userDTO;
    }

    @PassLogin
    @GetMapping("/user2")
    public UserDTO business2(@RequestParam("name")String name, UserDTO userDTO){
        userDTO.setCurrentTime(LocalDateTime.now());
        return userDTO;
    }
}
