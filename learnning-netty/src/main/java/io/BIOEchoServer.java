package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/11
 */
public class BIOEchoServer {

    public static void main(String[] args) throws IOException {
        // 启动服务端，绑定8001端口
        ServerSocket serverSocket = new ServerSocket(8001);
        System.out.println("server start");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("one clinet connection:" + socket);

            new Thread(() -> {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String msg;
                    while ((msg = bufferedReader.readLine()) != null) {
                        System.out.println("receive msg: " + msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
