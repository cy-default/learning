package com.rm13.shiro.controller;

import com.rm13.shiro.common.ResponseMsg;
import com.rm13.shiro.common.ResultCode;
import com.rm13.shiro.convertor.AbstractUserConvertor;
import com.rm13.shiro.model.bo.UserBO;
import com.rm13.shiro.model.generator.User;
import com.rm13.shiro.model.vo.UserVO;
import com.rm13.shiro.service.UserService;
import com.rm13.shiro.util.ShiroUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/23
 */
@Slf4j
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private AbstractUserConvertor userConvertor;


    @GetMapping("/login")
    public ResponseMsg<String> login() {
        log.info("GetMapping==login");
        User user = ShiroUtil.getPrincipal();
        if (user != null) {
            return ResponseMsg.success("已登录");
        }
        return ResponseMsg.error("用户未登录", ResultCode.C401.getCode());
    }

    @GetMapping("/logout")
    public ResponseMsg<String> redirectIndex() {
        log.info("GetMapping==logout");
        final Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResponseMsg.success("已登出");
    }

    @GetMapping("/index")
    public ResponseMsg<String> index() {
        log.info("GetMapping==index");
        User user = ShiroUtil.getPrincipal();
        if (user != null) {
            return ResponseMsg.success("已登录");
        }
        return ResponseMsg.error("用户未登录", ResultCode.C401.getCode());
    }

    @RequestMapping("/403")
    public ResponseMsg<String> unauth() {
        log.info("GetMapping==unauth");
        return ResponseMsg.error("未授权", ResultCode.C403.getCode());
    }


    @PostMapping(value = "/login")
    public ResponseMsg login(@RequestParam("username") String username,
                             @RequestParam("password") String password){
        log.info("login====================");
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(username);
        token.setPassword(password.toCharArray());


        final Subject subject = SecurityUtils.getSubject();
        /*
        if(subject.getPrincipal()!=null){
            return ResponseMsg.success("已登录");
        }
         */
        try {
            subject.login(token);
            return ResponseMsg.success("已登录");
        } catch (UnknownAccountException e) {
            return ResponseMsg.error("账号密码不正确", ResultCode.C401.getCode());
        } catch (IncorrectCredentialsException e) {
            return ResponseMsg.error("账号密码不正确", ResultCode.C401.getCode());
        } catch (LockedAccountException e) {
            return ResponseMsg.error("账号被锁定", ResultCode.C401.getCode());
        } catch (AuthenticationException e) {
            return ResponseMsg.error("账号认证失败", ResultCode.C401.getCode());
        }
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    @RequiresPermissions("api:user:info")
    public ResponseMsg<UserVO> info(@PathVariable("id")Integer id){
        final UserBO userBO = userService.selectByPrimaryKey(id);
        final UserVO userVO = userConvertor.boToVo(userBO);
        return ResponseMsg.success(userVO);
    }

    @RequiresPermissions("api:user:list")
    @GetMapping(value = "/user/list")
    public ResponseMsg<List<UserVO>> list(){
        final List<UserBO> userBOS = userService.selectAll();
        final List<UserVO> userVOS = userConvertor.bosToVos(userBOS);
        return ResponseMsg.success(userVOS);
    }
}
