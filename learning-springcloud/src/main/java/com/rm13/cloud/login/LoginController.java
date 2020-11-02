package com.rm13.cloud.login;

import com.rm13.cloud.exception.CustomException;
import com.rm13.cloud.login.argsresolver.LoginUserArgumentResolver;
import com.rm13.cloud.login.passlogin.LoginUserInterceptor;
import com.rm13.cloud.login.passlogin.PassLogin;
import com.rm13.cloud.model.dto.user.CurrentUser;
import io.swagger.annotations.*;
import org.springframework.core.NamedThreadLocal;
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

    /**
     * 获取当前登陆用户
     */
    public static class LoginUserHolder {

        /**
         * C端用户账号信息本地变量
         */
        private static final ThreadLocal<CurrentUser> C_ACCOUNT_THREAD_LOCAL = new NamedThreadLocal<>("C_ACCOUNT_THREAD_LOCAL");

        public static void set(CurrentUser currentUser) {
            C_ACCOUNT_THREAD_LOCAL.set(currentUser);
        }

        public static void remove() {
            C_ACCOUNT_THREAD_LOCAL.remove();
        }

        public static CurrentUser get() {
            CurrentUser userInfo = C_ACCOUNT_THREAD_LOCAL.get();
            if (userInfo == null) {
                throw new CustomException(1102,"用户不存在");
            }
            return userInfo;
        }
        private LoginUserHolder() {
        }
    }
}
