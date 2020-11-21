package com.rm13.shardingsphere.controller.user;

import com.rm13.shardingsphere.model.po.User;
import com.rm13.shardingsphere.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> listUser() {
        List<User> users = userService.listUser();
        return users;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        final User user = userService.getUser(id);
        return user;
    }
}
