package com.rm13.cloud.feigncore;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/19
 */
@Slf4j
public class FeignTest {

    @Test
    public void fun1(){
        RequestLineClient client = FeignClientFactory.create(RequestLineClient.class);
        client.testRequestLine("lovemyrm13");
        System.err.println(" ------------------ ");

        client.testRequestLine2("YourBatman2");
        System.err.println(" ------------------ ");

        // 使用Map一次传多个请求参数
        Map<String, Object> map = new HashMap<>();
        map.put("name", "lovemyrm13");
        map.put("age", Arrays.asList(1,2,3));
        client.testRequestLine3(map);
        System.err.println(" ------------------ ");

        try{
            client.testRequestLine4("YourBatman4");
        }catch (Exception e){
        }
        System.err.println(" ------------------ ");

        try {
            client.testRequestLine5("YourBatman4");
        } catch (Exception e) {
        }
        System.err.println(" ------------------ ");

        try {
            client.testRequestLine8("YourBatman4", 18);
        } catch (Exception e) {
        }
    }
}
