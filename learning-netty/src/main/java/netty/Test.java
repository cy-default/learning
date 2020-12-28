package netty;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/25
 */
public class Test {

    public static void main(String[] args) throws IOException {


    }

    public static void nioserver() throws IOException {

        final Selector selector = Selector.open();
        final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8888));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            selector.select();

            final Set<SelectionKey> selectionKeys = selector.selectedKeys();
            final Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                final SelectionKey selectionKey = iterator.next();
                if(selectionKey.isReadable()){
                    final ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel)selectionKey.channel();
                    final SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }else if(selectionKey.isReadable()){
                    final SocketChannel channel = (SocketChannel)selectionKey.channel();
                    final ByteBuffer allocate = ByteBuffer.allocate(1024);
                    while(channel.read(allocate)>0){
                        allocate.flip();
                        final byte[] bytes = new byte[allocate.remaining()];
                        allocate.get(bytes);
                        System.out.println(new String(bytes));
                        allocate.clear();
                    }
                }
                iterator.remove();
            }

        }

    }


    public static void nioclient() throws IOException {

        final SocketChannel socketChannel = SocketChannel.open();
        socketChannel.bind(new InetSocketAddress("127.0.0.1", 8888));
        socketChannel.configureBlocking(false);

        final ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.put("hello world".getBytes());
        socketChannel.write(allocate);
    }

    public static void bioserver() throws IOException {
        final ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            final Socket accept = serverSocket.accept();
            new Thread(() -> {
                final InputStream inputStream;
                try {
                    inputStream = accept.getInputStream();
                    final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String msg = null;
                    while ((msg = bufferedReader.readLine()) != null) {
                        System.out.println(msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
        }
    }

    public static void bioclient() throws IOException {
        final Socket socket = new Socket();
        socket.bind(new InetSocketAddress("127.0.0.1", 8888));
        final OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello world".getBytes("utf-8"));
    }
}
