package com.rm13.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/12
 */
public class AIOEchoServer {
    public static void main(String[] args) throws IOException {
        // 启动服务
        final AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8007));
        System.out.println("server start");

        // 监听accept事件，完全异步，不会阻塞
        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel socketChannel, Object attachment) {
                try {
                    System.out.println("accept new conn: " + socketChannel.getRemoteAddress());
                    // 再次监听accept 事件
                    serverSocketChannel.accept(null, this);

                    // 消息处理x
                    while (true) {
                        final ByteBuffer allocate = ByteBuffer.allocate(1024);
                        final Future<Integer> read = socketChannel.read(allocate);
                        if (read.get() > 0) {
                            allocate.flip();
                            final byte[] bytes = new byte[allocate.remaining()];
                            allocate.get(bytes);
                            final String content = new String(bytes);
                            System.out.println(content);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("failed");
            }
        });
        // 阻塞住主线程
        System.in.read();

    }
}
