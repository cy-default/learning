package com.rm13.controller;

import com.rm13.domain.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-26
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam String name,
                        User user,
                        Map<String, String> param){
        System.out.println(name);
        System.out.println(user.toString());
        System.out.println(param.toString());
        return "hello";
    }

    @RequestMapping("/hello1")
    public String hello1(User user){
        System.out.println(user.toString());
        return "hello";
    }

    @RequestMapping(value = "/hello2", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String hello2(@RequestBody User user){
        System.out.println(user.toString());
        return "hello";
    }

    @ResponseBody
    @RequestMapping(value = "/hello3")
    public String hello3(@RequestBody String info){
        System.out.println(info);
        return "hello";
    }

    @ResponseBody
    @RequestMapping(value = "/hello4")
    public String hello3(@RequestBody User user){
        System.out.println(user);
        return "hello";
    }
}
