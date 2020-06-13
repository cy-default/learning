package com.rm13.base;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/12
 */
public class SerializableTest {

    public static void main(String[] args) throws JsonProcessingException {
        Map<String, Long> result = new HashMap<>();
        result.put("11",11L);
        result.put("22",22L);

        String ser = JSON.toJSONString(result);

        Map<String, Long> map = JSON.parseObject(ser, Map.class);

        System.out.println(map.get("11"));

    }
}
