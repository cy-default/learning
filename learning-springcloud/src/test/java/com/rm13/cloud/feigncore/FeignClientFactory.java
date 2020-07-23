package com.rm13.cloud.feigncore;

import feign.Feign;
import feign.Logger;
import feign.Retryer;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/19
 */
public abstract class FeignClientFactory {

    static <T> T create(Class<T> clazz) {
        return Feign.builder()
                .logger(new Logger.ErrorLogger()).logLevel(Logger.Level.FULL) // 输出日志到控制台
                .retryer(Retryer.NEVER_RETRY) // 关闭重试
                .decode404() // 把404也解码 -> 这样就不会以一场形式抛出，中断程序喽，方便我测试嘛
                .target(clazz, "http://localhost:8080");
    }
}
