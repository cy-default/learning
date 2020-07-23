package com.rm13.cloud.controller;

import com.rm13.cloud.login.PassLogin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/21
 */
@PassLogin
@RestController
public class ModelAttributeController {


    @RequestMapping("/model/get")
    public String modeAttributeTest(@ModelAttribute("modelAttributeTest")Object mtest,
                                    @RequestParam(value = "a", required = false)String a){
        String result =  "a="+a+";modelAttributeTest="+mtest;
        System.out.println("/model/get:"+result);
        return result;
    }

    @RequestMapping("/model/set")
    public String setmodeAttributeTest(
                            @RequestParam(value = "parm", required = false) String parm,
                            HttpServletRequest req){
        System.out.println("/model/set:"+parm);

        req.setAttribute("aaa", parm);
        return parm;
    }

    @ModelAttribute("modelAttributeTest")
    public Object modelAttributeTest(HttpServletRequest request){
        System.out.println("ModelAttributeController:modelAttributeTest:"+request.getAttribute("aaa"));
        return request.getAttribute("aaa");
    }
}
