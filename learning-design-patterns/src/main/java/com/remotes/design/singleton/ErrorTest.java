package com.remotes.design.singleton;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-11
 */
public class ErrorTest {

    public static void main(String[] args) {
        try {
             int num = 1/ 0;
        }finally {
            System.out.println("hello world---");
        }

    }


}
