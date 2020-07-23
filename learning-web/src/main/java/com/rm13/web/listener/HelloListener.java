package com.rm13.web.listener;

import javax.servlet.http.HttpSessionListener;
import java.util.EventListener;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/3/16
 */
public class HelloListener implements EventListener {

    public HelloListener() {
        System.out.println("HelloListener...");
    }

}
