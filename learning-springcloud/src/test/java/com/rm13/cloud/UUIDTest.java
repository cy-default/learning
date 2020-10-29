package com.rm13.cloud;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.rm13.cloud.model.po.User;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/23
 */
public class UUIDTest {
    public static void main(String[] args) {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final String result = IdUtil.simpleUUID();
        System.out.println(result);
        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
        stopWatch.stop();

        final User user = new User();
        user.setFirstName("love");
        System.out.println(JSON.toJSONString(user));


        final ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        System.out.println(list.size());
        System.out.println(list.subList(1, list.size()));

        System.out.println("====");


        Collections.reverse(list);
        System.out.println(list);

    }
}
