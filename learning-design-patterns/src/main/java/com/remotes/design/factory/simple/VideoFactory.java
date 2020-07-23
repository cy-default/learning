package com.remotes.design.factory.simple;

import com.remotes.design.factory.GoVideo;
import com.remotes.design.factory.JavaVideo;
import com.remotes.design.factory.PythonVideo;

/**
 * 简单工厂设计模式
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-09
 */
public class VideoFactory {

    public static final String JAVA = "JAVA";
    public static final String GO = "GO";
    public static final String PYTHON = "PYTHON";

    /**
     * <p>
     *  通过反射获取视频
     * </p>
     * @param
     * @return
     * @author yuan.chen
     * @Date 2019-09-09
     */
    public static Video getVideoByRefernce(Class cls) throws Exception {
        return ((Video) cls.newInstance());
    }

    /**
     * <p>
     *    通过名称获取video
     * </p>
     * @param
     * @return 
     * @author yuan.chen
     * @Date 2019-09-09
     */
    public static Video getVideoByName(String name){
        if(JAVA.equals(name)){
            return new JavaVideo();
        }else if (GO.equals(name)){
            return new GoVideo();
        }else if(PYTHON.equals(name)) {
            return new PythonVideo();
        }else{
            return null;
        }
    }
}
