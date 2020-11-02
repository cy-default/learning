package com.rm13.cloud.controller;

import com.rm13.cloud.async.AsyncService;
import com.rm13.cloud.login.passlogin.PassLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/17
 */
@PassLogin
@RestController
@RequestMapping("/arthas")
public class ArthasController {

    @Autowired
    AsyncService asyncService;

    @RequestMapping("/t1")
    public String arthas() throws InterruptedException {
        asyncService.endlessLoop();
        return "arthas t1 test";
    }
}
