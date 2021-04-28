package com.rm13.cloud.feign;

import com.alibaba.fastjson.JSON;
import com.rm13.cloud.model.po.Order;
import com.rm13.cloud.model.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/12
 */
@Slf4j
@Component
public class FeignProxyFallBack implements FeignProxy {


    @Override
    public String after1(User user, String ab) {
        log.error("FeignProxyFallBack.after1");
        return "after1";
    }

    @Override
    public String after2(String a, String b, String ab) {
        log.error("FeignProxyFallBack.after2");
        return "after2";
    }

    @Override
    public String after3(Map<String, String> param, String ab) {
        log.error("FeignProxyFallBack.after3");
        return "after3";
    }

    @Override
    public String mapTest(Map<String, Object> user) {
        log.error("mapTestmapTestmapTestmapTestmapTest");

        return null;
    }

//    @Override
//    public String multiJSON(@RequestParam String name,@RequestBody User user, Order order) {
//        log.error("multiJSONmultiJSONmultiJSONmultiJSONmultiJSON");
//        String result = JSON.toJSONString(user).concat("----->").concat(name);
//        return result;
//    }

    @Override
    public String after4(Map<String, ?> user, String ab) {
        log.error("FeignProxyFallBack.after4");
        return "after4";
    }

    @Override
    public String parent() {
        log.error("FeignProxyFallBack.parent");
        return null;
    }

    @Override
    public String arrayProcessTest(String username,String[] ids) {
        return null;
    }

    @Override
    public String multiJSON(String name, User user) {
        return null;
    }
}
