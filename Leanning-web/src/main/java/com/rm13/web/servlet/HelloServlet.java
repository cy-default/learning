package com.rm13.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/3/16
 */
public class HelloServlet extends HttpServlet {

    public HelloServlet() {
        System.out.println("HelloServlet...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        final String[] hellos = req.getParameterValues("hello");
        System.out.println(Arrays.toString(hellos));
        System.out.println("你好");
        resp.getWriter().write(Arrays.toString(hellos));
    }
}
