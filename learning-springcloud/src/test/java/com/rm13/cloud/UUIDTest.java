package com.rm13.cloud;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import org.springframework.util.StopWatch;

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
    }
}
