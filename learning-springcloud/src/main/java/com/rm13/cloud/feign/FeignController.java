package com.rm13.cloud.feign;

import cn.hutool.core.util.IdUtil;
import com.google.common.collect.Maps;
import com.rm13.cloud.login.passlogin.PassLogin;
import com.rm13.cloud.model.po.Order;
import com.rm13.cloud.model.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/12
 */
@Slf4j
@PassLogin
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private FeignProxy feignProxy;

    @GetMapping("/demo1")
    public String demo1(@RequestParam(value = "name", required = false)String name,
                          @RequestParam(value = "age", required = false)Integer age){
        log.info("FeignController.demo={}.{}", name, age);
        return "lovemyrm13".concat("==").concat(IdUtil.simpleUUID());
    }


    @GetMapping("/before1")
    public String before1(@RequestParam("a")String a, @RequestParam("b")String b){
        final User user = new User();
        user.setA(a);
        user.setB(b);
        log.info(feignProxy.getClass().getName());
        return feignProxy.after1(user, a+b);
    }

    @RequestMapping("/after1")
    public String after1(@RequestParam("a")String a, @RequestParam("b")String b, @RequestHeader(value = "auth", required = false)String auth){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a+b+"after1@aliyun.com==>"+auth;
    }

    @GetMapping("/before2")
    public String before2(@RequestParam("a")String a, @RequestParam("b")String b){
        return feignProxy.after2(a, b, a+b);
    }

    @RequestMapping("/after2")
    public String after2(@RequestParam("a")String a, @RequestParam("b")String b){
        return a+b+"after2@aliyun.com";
    }

    @GetMapping("/before3")
    public String before3(@RequestParam("a")String a, @RequestParam("b")String b){
        final HashMap<String, String> map = Maps.newHashMap();
        map.put("a", a);
        map.put("b", b);
        return feignProxy.after3(map, a+b);
    }

    @RequestMapping("/after3")
    public String after3(@RequestParam("a")String a, @RequestParam("b")String b){
        return a+b+"after3@aliyun.com";
    }

    @GetMapping("/before4")
    public String before4(@RequestParam("a")String a, @RequestParam("b")String b){
        Map<String, Object> map = new HashMap<>();
        map.put("a", a);
        map.put("b", b);
        map.put("c",1);
        return feignProxy.after4(map, a+b);
    }

    @RequestMapping("/after4")
    public String after4(@RequestParam("a")String a, @RequestParam("b")String b){
        return a+b+"after3@aliyun.com";
    }

    @GetMapping("/mapTestBefore")
    public String mapTestBefore(){
        User user = new User();
        user.setA("a");
        user.setB("b");
        user.setC(LocalDate.now());
        Map<String, Object> map = new HashMap<>();
        map.put("a", "love");
        map.put("b", Arrays.asList(1,2,3,4));
        map.put("c",user);
        return feignProxy.mapTest(map);
    }

    @ResponseBody
    @RequestMapping("/mapTestAfter")
    public Map<String, Object> mapTestAfter(@RequestBody Map<String, Object> user){
        log.info("feign client user:{}", user);
        return user;
    }

    @GetMapping("/multiJSONBefore")
    public String multiJSONBefore(){
        User user = new User();
        user.setA("a");
        user.setB("b");
        user.setC(LocalDate.now());
        Order order = new Order();
        order.setGoodsId(1000L);
        order.setOrderNo("2000");
        order.setUserId(3000L);
        String rm13 = null;
//        String rm13 = feignProxy.multiJSON("rm13", user, order);
        return rm13;
    }

    @ResponseBody
    @RequestMapping("/multiJSONFeign")
    public String multiJSONFeign(@RequestParam String name, @RequestBody User user){
        log.info("name:{}, user:{}, order:{}", name, user);
        return "test";
    }

}
