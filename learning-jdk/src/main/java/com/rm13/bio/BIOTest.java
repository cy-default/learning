package com.rm13.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/8/22
 */
public class BIOTest {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);

        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
            final Socket accept = serverSocket.accept();

            executorService.submit(() -> process(accept));


        }

    }

    public static void process(Socket accept) {
        try {
            final InputStream inputStream = accept.getInputStream();
            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes) != -1) {
                System.out.println(new String(bytes));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
