package com.rm13.cloud.result;

import com.rm13.cloud.login.PassLogin;
import com.rm13.cloud.model.po.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 校验args参数
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/18
 */
@PassLogin
@RestController
@RequestMapping("/resp")
public class ResponseBodyController {

    @GetMapping("/demo1")
    public Integer demo1(Integer num){
        return num;
    }

    @GetMapping("/demo2")
    public User demo2(Integer num){
        User result = new User();
        result.setA("A");
        result.setFirstName("lovemyrm13");
        result.setLastName("rm23");
        return result;
    }

}
