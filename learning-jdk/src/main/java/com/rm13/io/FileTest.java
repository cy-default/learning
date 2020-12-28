package com.rm13.io;


import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * 获取当前系统的文件符
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/12
 */
public class FileTest {

    public static void main(String[] args) throws IOException {


        final ArrayList<Object> arrayList = new ArrayList<>();

        for (Object o : arrayList) {
            System.out.println(o);
        }
    }

    public void bioclient() throws Exception {
        final Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1", 8888));
        if (socket.isConnected()) {
            final OutputStream outputStream = socket.getOutputStream();
            outputStream.write("lovemyrm13".getBytes());
        }
    }

    public void bioserver() throws Exception {
        final ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            final Socket accept = serverSocket.accept();
            new Thread(() -> {
                try {
                    final InputStream inputStream = accept.getInputStream();
                    final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String msg = null;
                    while ((msg = bufferedReader.readLine()) != null) {
                        System.out.println(msg);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }

    public void nioserver() throws IOException {
        final Selector selector = Selector.open();
        final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8888));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();
            final Set<SelectionKey> selectionKeys = selector.selectedKeys();
            final Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                final SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    final ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                    final SocketChannel accept = channel.accept();
                    accept.configureBlocking(false);
                    accept.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    final SocketChannel channel = (SocketChannel) selectionKey.channel();
                    final ByteBuffer allocate = ByteBuffer.allocate(1024);
                    while (channel.read(allocate) > 0) {
                        allocate.flip();
                        final byte[] bytes = new byte[allocate.remaining()];
                        allocate.get(bytes);
                        System.out.println(new String(bytes));
                    }
                }
                iterator.remove();
            }
        }
    }
}
