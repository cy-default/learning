package com.rm13.cloud.controller;

import com.rm13.cloud.pojo.po.Account;
import com.rm13.cloud.login.PassLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Spring MVC 配置接收 String 参数时自动去除前后空格
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/21
 */
@Slf4j
@PassLogin
@RestController
@RequestMapping("/trim")
public class StringTrimController {

    @GetMapping("/url")
    public String urlParam(String name) {
        log.info("=="+name);
        return name;
    }

    @PostMapping("/form")
    public Account formParam(Account u) {
        return u;
    }

    @PostMapping(value = "/body")
    public Account bodyParam(@RequestBody Account u) {
        return u;
    }
}
