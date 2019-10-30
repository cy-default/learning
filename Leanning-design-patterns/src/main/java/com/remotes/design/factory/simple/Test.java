package com.remotes.design.factory.simple;

import com.remotes.design.factory.GoVideo;
import com.remotes.design.factory.JavaVideo;
import com.remotes.design.factory.PythonVideo;

import java.util.Optional;

/**
 * 简单工厂设计模式
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-09
 */
public class Test {

    public static void main(String[] args) throws Exception {
        byName();
        byReference();
    }

    public static void byName(){
        Optional.ofNullable(VideoFactory.getVideoByName(VideoFactory.GO)).ifPresent(t->t.getVideo());
        Optional.ofNullable(VideoFactory.getVideoByName(VideoFactory.JAVA)).ifPresent(t->t.getVideo());
        Optional.ofNullable(VideoFactory.getVideoByName(VideoFactory.PYTHON)).ifPresent(t->t.getVideo());
    }

    public static void byReference() throws Exception {
        Optional.ofNullable(VideoFactory.getVideoByRefernce(GoVideo.class)).ifPresent(t->t.getVideo());
        Optional.ofNullable(VideoFactory.getVideoByRefernce(JavaVideo.class)).ifPresent(t->t.getVideo());
        Optional.ofNullable(VideoFactory.getVideoByRefernce(PythonVideo.class)).ifPresent(t->t.getVideo());
    }
}
