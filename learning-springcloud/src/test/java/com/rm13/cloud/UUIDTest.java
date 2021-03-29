package com.rm13.cloud;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.rm13.cloud.model.po.User;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/23
 */
public class UUIDTest {
    public static void main(String[] args) throws InterruptedException {
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
