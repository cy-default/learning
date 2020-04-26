package com.rm13.cloud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * Redirect重定向可以请求在多个服务器中，是2个请求， 第一个请求status=302，请求头中location对应转发的请求地址。
 *
 * 说明： 使用resttemplate/httpclient请求工具请求接口时， 不用考虑接口是否有重定向， 返回的数据永远是重定向后接口处理的数据
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/26
 */
@Slf4j
@Controller
@RequestMapping("/redirect")
public class RedirectController {

    @Autowired
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper=new ObjectMapper();

    @RequestMapping("/request1")
    public String req(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("request1"+Thread.currentThread().getName()+":"+Thread.currentThread().getId());
        Cookie cookie = new Cookie("snmt-req-token", UUID.randomUUID().toString().replace("-",""));
        resp.addCookie(cookie);
        return "redirect:/redirect/redirect";
    }

    @ResponseBody
    @RequestMapping("/redirect")
    public String forward(HttpServletRequest req, HttpServletResponse resp){
        log.info("redirect"+Thread.currentThread().getName()+":"+Thread.currentThread().getId());
        return "redirect:redirect:redirect";
    }

    @RequestMapping("/request2")
    public void req2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("request2"+Thread.currentThread().getName()+":"+Thread.currentThread().getId());
        Cookie cookie = new Cookie("snmt-req2-token", UUID.randomUUID().toString().replace("-",""));
        resp.addCookie(cookie);
        resp.sendRedirect("/redirect/request1");
    }


    @ResponseBody
    @RequestMapping("/request3")
    public String req3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("request3"+Thread.currentThread().getName()+":"+Thread.currentThread().getId());
        Cookie cookie = new Cookie("snmt-req2-token", UUID.randomUUID().toString().replace("-",""));
        // 请求链路 request2->redirect:request1->redirect:redirect->具体响应数据
        final ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8080/redirect/request2", String.class);
        log.info("result:{}", objectMapper.writeValueAsString(forEntity));
        return "request3";
    }
}
