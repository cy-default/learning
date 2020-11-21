package com.rm13.cloud.controller;

import com.rm13.cloud.login.passlogin.PassLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/17
 */
@PassLogin
@RestController
@RequestMapping("/hello")
public class EnvironmentController implements EnvironmentAware {

    @Value("${hello:}")
    private String hello;

    private Environment environment;

    @GetMapping("")
    public String hello(){
        return hello;
    }

    @GetMapping("/env/{name}")
    public String hello(@PathVariable("name")String name){
        String value = environment.getProperty(name);
        return value;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
