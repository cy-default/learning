package com.rm13.cloud.controller;

import com.rm13.cloud.common.annotation.PassLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Forward转发仅限在服务器内部转发， 同一个请求， 同一个线程处理。请求体内容没变
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/26
 */
@PassLogin
@Slf4j
@RestController
@RequestMapping("/forward")
public class ForwardController {

    @RequestMapping("/request")
    public String req(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/forward/forward").forward(req, resp);
        log.info("forward:"+Thread.currentThread().getName()+":"+Thread.currentThread().getId());
        return "lovemyrm13:requestForwardBefore";
    }

    @RequestMapping("/forward")
    public String forward(HttpServletRequest req, HttpServletResponse resp){
        log.info("forward:"+Thread.currentThread().getName()+":"+Thread.currentThread().getId());
        return "lovemyrm13:requestForwardAfter";
    }
}
