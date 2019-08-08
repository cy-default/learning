package com.remotes.design.io;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-21
 */
public class QQ {

    @Test
    public void test(){

        List<Socket> list = new ArrayList<>();
        byte[] bytes = new byte[1024];
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("no listern");

            Socket socket = serverSocket.accept();
            if(socket ==  null){
                System.out.println("no connection");
            }else{
                System.out.println("connection");
                list.add(socket);
                for (Socket st : list) {
                    int num = st.getInputStream().read(bytes);
                    if(num >0){
                        System.out.println(new String(bytes));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
