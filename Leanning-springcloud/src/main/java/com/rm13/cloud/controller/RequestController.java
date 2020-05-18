package com.rm13.cloud.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/14
 */
@Slf4j
@RestController
@RequestMapping("/req")
public class RequestController {

    @RequestMapping("/demo")
    public String req(HttpServletRequest request){
        final Object snmt = request.getAttribute("snmt");
        final String requestURI = request.getRequestURI();
        log.info("requestURI:"+requestURI);
        final String requestURL = request.getRequestURL().toString();
        log.info("requestURL:"+requestURL);
        return "ok";
    }

    @RequestMapping("/json/body")
    public String req(@RequestBody String body){
        log.info("body:{}", body);
        return body;
    }

    @RequestMapping("/json/object")
    public String req(@RequestBody JSONObject body){
        log.info("body:{}", body);
        return body.toJSONString();
    }

    @RequestMapping("/json/map")
    public String req(@RequestBody Map body){
        log.info("body:{}", body);
        return body.toString();
    }
}
