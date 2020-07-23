package com.remotes.design.io;

import org.junit.Test;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-21
 */
public class Client {

    @Test
    public  void test(){

        try {
            Socket socket = new Socket("127.0.0.1",8080);
            socket.getOutputStream().write("救赎 u uuuu".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
