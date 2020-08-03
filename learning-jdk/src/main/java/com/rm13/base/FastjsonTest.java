package com.rm13.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rm13.optional.User;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用fastjson在做map转换的时候，在对数据做反序列化后，通过map.get(xxx)获取到的值 做类型转换的时候可能会存在类型转换异常
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/30
 */
public class FastjsonTest {

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();
        final String name = "name";
        final String id = "id";
        map.put(name, "张三");
        map.put(id, 20L);

        String fastJsonString = JSON.toJSONString(map);
        // 模拟拿到服务B的数据

        Map<String, Object> mapFastJson = JSON.parseObject(fastJsonString, map.getClass());
        // 转成强类型属性的对象而不是使用map 单个取值
        User user = new JSONObject(mapFastJson).toJavaObject(User.class);

        // 报错！！！！java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.Long
        System.out.println((Long) mapFastJson.get(id));

        // 正确
        System.out.println(map.get(name).equals(user.getName()));
        // 正确
        System.out.println(map.get(id).equals(user.getId()));

    }


}
