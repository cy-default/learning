package com.rm13.spring.ioc.ext;

import org.springframework.context.SmartLifecycle;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/8/24
 */
public class SmartLifeCyclicService implements SmartLifecycle {
    @Override
    public void start() {
        System.out.println("start..");
    }

    @Override
    public void stop() {
        System.out.println("stop..");

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
