package com.remotes.design.handler.demo6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2021/1/9
 */
public class HandlerChain {
    private List<IHandler> handlers = new ArrayList<>();

    public void addHandler(IHandler handler){
        this.handlers.add(handler);
    }

    public void handle(){
        for (IHandler handler : handlers) {
            boolean handled = handler.handle();
            // 若想让所有处理链都处理；则屏蔽break；
            if(handled){
                break;
            }
        }
    }

}
