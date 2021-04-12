package com.rm13.cloud.modelattribute;

import com.rm13.cloud.login.passlogin.PassLogin;
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

    /*
     * 总结： ModelAttribute定义的， 会在controller方法调用前优先执行，
     * 可以根据这一特点， 通过拦截器， 在拦截器中设置request.setAttribute，
     * 再通过在modelAttribute方法在获取用户信息， 并把用户信息以controller参数的形式传递
     */
    @ModelAttribute("modelAttributeTest")
    public Object modelatt(HttpServletRequest request){
        System.out.println("ModelAttributeController:modelAttributeTest:"+request.getAttribute("aaa"));
        return request.getAttribute("aaa");
    }
}
