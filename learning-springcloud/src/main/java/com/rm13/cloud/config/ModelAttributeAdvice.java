package com.rm13.cloud.config;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * 总结： ModelAttribute定义的， 会在controller方法调用前优先执行，
 * 可以根据这一特点， 通过拦截器， 在拦截器中设置request.setAttribute，
 * 再通过在modelAttribute方法在获取用户信息， 并把用户信息以controller参数的形式传递
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/21
 */
// @ControllerAdvice
public class ModelAttributeAdvice {

    @ModelAttribute("modelAttributeTest")
    public Object modelAttributeTest(HttpServletRequest request) {
        System.out.println("ModelAttributeAdvice:modelAttributeTest:" + request.getAttribute("aaa"));
        return request.getAttribute("aaa");
    }
}
