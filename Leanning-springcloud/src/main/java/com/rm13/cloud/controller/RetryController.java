package com.rm13.cloud.controller;

import com.rm13.cloud.common.annotation.PassLogin;
import com.rm13.cloud.retry.RetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/25
 */
@PassLogin
@RestController
@RequestMapping("/retry")
public class RetryController {

    @Autowired
    private RetryService retryService;

    @GetMapping("demo1")
    public String demo1(){
        Random random = new Random();
        int i = random.nextInt(100);
        String result = retryService.annotationRetryService(String.valueOf(i));
        return result;
    }

    @GetMapping("demo2")
    public String demo2(){
        Random random = new Random();
        int i = random.nextInt(100);
        String result = retryService.custRetryService(String.valueOf(i));
        return result;
    }
}
