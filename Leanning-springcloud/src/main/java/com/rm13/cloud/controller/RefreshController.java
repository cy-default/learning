package com.rm13.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

/**
 * 通过设置响应头实现定时请求服务的功能
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/18
 */
@RestController
@RequestMapping("/refresh")
public class RefreshController {

    @GetMapping("")
    public void refresh(HttpServletResponse resp) throws IOException {
        final String result = LocalTime.now().toString();

        resp.getWriter().write(result);
        // 5:单位是秒；URL后面请求的对应刷新的地址
        // URL:刷新请求的地址，
        resp.setHeader("Refresh","5;URL=http://localhost:8080/refresh");
    }


    @GetMapping("/json")
    public String json() throws IOException {
        final String result = LocalTime.now().toString();
        return result;
    }
}
