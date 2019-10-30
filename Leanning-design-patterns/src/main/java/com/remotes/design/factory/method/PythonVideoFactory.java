package com.remotes.design.factory.method;

import com.remotes.design.factory.PythonVideo;
import com.remotes.design.factory.simple.Video;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-09
 */
public class PythonVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}
