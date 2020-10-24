package tmp;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/19
 */
public class IO_NIOTest {

    public static void main(String[] args) throws IOException {
        final Selector selector = Selector.open();
        final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8888));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("server start");

        while (true) {
            selector.select();

            final Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                final SelectionKey selectionKey = iterator.next();

                if (selectionKey.isAcceptable()) {
                    final ServerSocketChannel serverChannel = (ServerSocketChannel) selectionKey.channel();
                    final SocketChannel socketChannel = serverChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    final SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    final ByteBuffer allocate = ByteBuffer.allocate(1024);
                    while (socketChannel.read(allocate) > 0) {
                        allocate.flip();
                        final byte[] bytes = new byte[allocate.remaining()];
                        allocate.get(bytes);
                        String msg = new String(bytes);
                        System.out.println("receive msg:" + msg);
                        allocate.clear();
                    }
                }
                iterator.remove();
            }
        }
    }
}
