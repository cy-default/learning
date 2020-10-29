package com.rm13.cloud.login;

import com.rm13.cloud.model.dto.user.CurrentUser;
import io.swagger.annotations.*;
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
 * @see LoginUserArgumentResolver
 * @see LoginUserInterceptor
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/18
 */
@Api(value = "LoginController", tags = "校验用户登陆逻辑")
@RestController
@RequestMapping("/auth")
public class LoginController {


    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "用户接口user1", notes = "用户接口user1")
    @GetMapping("/user1")
    public CurrentUser business1(@ApiParam("用户名") @RequestParam(value = "name", required = false)String name, CurrentUser currentUser){
        currentUser.setCurrentTime(LocalDateTime.now());
        return currentUser;
    }


    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "用户接口user2", notes = "用户接口user2")
    @PassLogin
    @GetMapping("/user2")
    public CurrentUser business2(@RequestParam("name")String name, CurrentUser currentUser){
        currentUser.setCurrentTime(LocalDateTime.now());
        return currentUser;
    }
}
