package com.remotes.design.handler.demo4;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2021/1/9
 */
public class HandlerB extends Handler {
    @Override
    public void handle() {
        boolean handled = false;
        System.out.println("HandlerB handle");
        // ...

        // 若想让所有处理链都处理；则屏蔽handled判断逻辑；
        if (!handled && successor != null) {
            successor.handle();
        }
    }
}
