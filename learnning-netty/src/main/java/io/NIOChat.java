package io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * NIO实现聊天室
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/12
 */
public class NIOChat {
    public static void main(String[] args) throws IOException {
        final Selector selector = Selector.open();
        final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        // 将accept事件绑定到selector上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            // 阻塞在selector上
            selector.select();

            // 遍历selectKeys
            final Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                final SelectionKey selectionKey = iterator.next();

                // 如果是accept事件
                if (selectionKey.isAcceptable()) {
                    final ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
                    final SocketChannel socketChannel = ssc.accept();
                    System.out.println("accept new conn: " + socketChannel.getRemoteAddress());

                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    // 加入群聊
                    ChatHolder.join(socketChannel);
                } else if (selectionKey.isReadable()) {
                    // 如果是读事件
                    final SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    // 将数据读到buffer中
                    final int read = socketChannel.read(byteBuffer);
                    if (read > 0) {
                        byteBuffer.flip();
                        final byte[] bytes = new byte[byteBuffer.remaining()];
                        // 将数据读到byte数组中
                        byteBuffer.get(bytes);

                        // 换行符会跟着消息一起传过来
                        String content = new String(bytes, "UTF-8").replace("\r\n", "");
                        if (content.equalsIgnoreCase("quit")) {
                            // 退出群聊
                            ChatHolder.quit(socketChannel);
                            selectionKey.cancel();
                            socketChannel.close();
                        } else {
                            // 扩散
                            ChatHolder.propagate(socketChannel, content);
                        }
                    }
                }
                iterator.remove();
            }
        }

    }


    private static class ChatHolder {
        private static final Map<SocketChannel, String> USER_MAP = new ConcurrentHashMap<>();

        /**
         * 加入群聊
         *
         * @param socketChannel
         */
        public static void join(SocketChannel socketChannel) {
            // 有人加入就给他分配一个id
            String userId = "用户" + ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
            send(socketChannel, "您的id为：" + userId + "\n\r");
            for (SocketChannel channel : USER_MAP.keySet()) {
                send(channel, userId + " 加入了群聊" + "\n\r");
            }
            // 将当前用户加入到map中
            USER_MAP.put(socketChannel, userId);
        }


        /**
         * 退出群聊
         *
         * @param socketChannel
         */
        public static void quit(SocketChannel socketChannel) {
            final String userId = USER_MAP.get(socketChannel);
            send(socketChannel, "您退出了群聊" + "\n\r");
            USER_MAP.remove(socketChannel);
            for (SocketChannel channel : USER_MAP.keySet()) {
                if (channel != socketChannel) {
                    send(channel, userId + " 退出了群聊" + "\n\r");
                }
            }
        }


        /**
         * 扩散说话的内容
         *
         * @param socketChannel
         * @param content
         */
        public static void propagate(SocketChannel socketChannel, String content) {
            final String userId = USER_MAP.get(socketChannel);
            for (SocketChannel channel : USER_MAP.keySet()) {
                if (channel != socketChannel) {
                    send(channel, userId + ": " + content + "\r\n");
                }
            }
        }


        /**
         * 发送消息
         *
         * @param socketChannel
         * @param msg
         */
        public static void send(SocketChannel socketChannel, String msg) {
            try {
                final ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                writeBuffer.put(msg.getBytes());
                writeBuffer.flip();
                socketChannel.write(writeBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


