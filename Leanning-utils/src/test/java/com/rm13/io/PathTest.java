package com.rm13.io;

import org.junit.Test;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/1/20
 */
public class PathTest {

    @Test
    public void test01(){
        // 类所在的目录
        final String path1 = PathTest.class.getResource("").getPath();
        // /Users/chenyuan/Documents/project/collect/Leanning/Leanning-utils/target/test-classes/com/rm13/io/
        System.out.println(path1);

        // 运行的根目录
        final String path2 = PathTest.class.getResource("/").getPath();
        // /Users/chenyuan/Documents/project/collect/Leanning/Leanning-utils/target/test-classes/
        System.out.println(path2);
    }
}
