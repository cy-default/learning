package com.rm13.cloud;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson.JSON;
import com.rm13.cloud.model.po.User;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/23
 */
public class UUIDTest {
    public static void main(String[] args) throws InterruptedException {

        User user = new User();
        user.setFirstName("love");
        List<User> rm = Arrays.asList(user).stream().peek(t -> t.setFirstName("rm")).collect(Collectors.toList());
        for (User user1 : rm) {
            System.out.println(user1.getFirstName());
        }

        System.out.println(user);


        System.out.println(NumberUtils.isCreatable("0000.11232"));
        String traceId = UUID.randomUUID().toString();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("count(*)查询耗时");
        Thread.sleep(2000);

        stopWatch.stop();

        stopWatch.start("insert插入数据耗时");
        Thread.sleep(1000);
        stopWatch.stop();

        System.out.println("traceId:"+traceId+"---\n"+stopWatch.prettyPrint());


    }
}
