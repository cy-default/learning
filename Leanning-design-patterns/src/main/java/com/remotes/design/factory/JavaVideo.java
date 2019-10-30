package com.remotes.design.factory;

import com.remotes.design.factory.simple.Video;

/**
 * <p>
 *    视频video
 * <p>
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-09 11:50
 */
public class JavaVideo extends Video {
    @Override
    public void getVideo() {
        System.out.println("Java Video");
    }
}
