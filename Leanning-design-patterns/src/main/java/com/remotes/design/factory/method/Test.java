package com.remotes.design.factory.method;

import java.util.Optional;

/**
 * 工厂方法设计模式
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-09
 */
public class Test {

    public static void main(String[] args) {
        VideoFactory videoFactory = new JavaVideoFactory();
        Optional.ofNullable(videoFactory.getVideo()).ifPresent(t->t.getVideo());

        videoFactory = new GoVideoFactory();
        Optional.ofNullable(videoFactory.getVideo()).ifPresent(t->t.getVideo());

        videoFactory = new PythonVideoFactory();
        Optional.ofNullable(videoFactory.getVideo()).ifPresent(t->t.getVideo());
    }
}
