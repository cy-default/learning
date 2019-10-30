package com.remotes.design.factory;

import com.remotes.design.factory.simple.Video;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-09
 */
public class PythonVideo extends Video {
    @Override
    public void getVideo() {
        System.out.println("python video");
    }
}
