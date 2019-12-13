package com.rm13.io;

import sun.nio.fs.DefaultFileSystemProvider;

import java.io.File;
import java.nio.file.spi.FileSystemProvider;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/12
 */
public class FileTest {

    public static void main(String[] args) {
        final String separator = File.separator;
        System.out.println(separator);
    }
}
