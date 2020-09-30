package tmp;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/19
 */
public class NIOTest {

    public static void main(String[] args) throws IOException {

        final Selector selector = Selector.open();

        final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8000));

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();
            final Set<SelectionKey> selectionKeys = selector.selectedKeys();
            final Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                final SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    final ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                    final SocketChannel socketChannel = channel.accept();
                    channel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    final SocketChannel channel = (SocketChannel) selectionKey.channel();
                    final ByteBuffer allocate = ByteBuffer.allocate(1024);

                    while (channel.read(allocate) > 0) {
                        allocate.flip();
                        final byte[] bytes = new byte[allocate.limit()];
                        allocate.get(bytes);
                        final String result = new String(bytes, StandardCharsets.UTF_8);
                        System.out.println(result);
                    }
                }
            }

        }
    }
}
