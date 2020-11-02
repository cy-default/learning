package com.rm13.cloud.exception;

import com.rm13.cloud.login.passlogin.PassLogin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/4
 */
@PassLogin
@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("")
    public String demo(){
        if(true){
            int num = 1/0;
        }
        return "exception";
    }

    @GetMapping("/biz")
    public String biz(){
        if(true){
            throw new ServiceException(2300);
        }
        return "exception";
    }
}
