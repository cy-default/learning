package netty;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Netty 实现简单群聊系统
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/14
 */
public class NettyChatServer {
    private static final int PORT = Integer.parseInt(System.getProperty("port", "8007"));

    public static void main(String[] args) {
        // 1. 声明线程池
        final NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        final NioEventLoopGroup childGroup = new NioEventLoopGroup();

        try {
            // 2. 服务端引导类
            final ServerBootstrap serverBootstrap = new ServerBootstrap();

            // 3. 设置线程池
            serverBootstrap.group(bossGroup, childGroup)
                    // 4. 设置serverSocketChannel的类型
                    .channel(NioServerSocketChannel.class)
                    // 5. 设置参数
                    .option(ChannelOption.SO_BACKLOG, 100)
                    // 6. 设置serverSocketChannel对应的Handler，只能设置一个
                    .handler(new LoggingHandler(LogLevel.INFO))
                    // 7. 设置SocketChannel对应的Handler
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            final ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new LoggingHandler(LogLevel.INFO));
                            pipeline.addLast(new ChatNettyHandler());
                        }
                    });
            // 8. 绑定端口
            final ChannelFuture f = serverBootstrap.bind(PORT).sync();
            System.out.println("bind sync");

            // 9. 等待服务端监听端口关闭， 这里会阻塞主线程
            f.channel().closeFuture().sync();
            // 这个不会执行
            System.out.println("close sync");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }

    }


    private static class ChatNettyHandler extends SimpleChannelInboundHandler<ByteBuf> {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("one conn active:" + ctx.channel());
            // channel是在ServerBootstrapAcceptor中放到EventLoopGroup中的
            ChatHodler.join((SocketChannel) ctx.channel());
        }

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, ByteBuf byteBuf) throws Exception {
            final byte[] bytes = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(bytes);
            String content = new String(bytes, StandardCharsets.UTF_8);
            System.out.println(content);
            if ("quit\r\n".equals(content)) {
                ctx.channel().close();
                ChatHodler.quit((SocketChannel) ctx.channel());
            } else {
                ChatHodler.propagate((SocketChannel) ctx.channel(), content);
            }
        }
    }

    private static class ChatHodler {
        private static final Map<SocketChannel, String> USER_MAP = new ConcurrentHashMap<>();

        /**
         * 加入群聊
         *
         * @param socketChannel
         */
        public static void join(SocketChannel socketChannel) {
            String userId = "用户" + ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
            send(socketChannel, "你的Id为: " + userId + "\n\r");
            for (SocketChannel channel : USER_MAP.keySet()) {
                send(channel, userId + " 加入了群聊 \n\r");
            }
            USER_MAP.put(socketChannel, userId);
        }

        /**
         * 退出群聊
         *
         * @param socketChannel
         */
        public static void quit(SocketChannel socketChannel) {
            String userId = USER_MAP.get(socketChannel);
            send(socketChannel, "你退出了群聊\n\r");
            USER_MAP.remove(socketChannel);
            for (SocketChannel channel : USER_MAP.keySet()) {
                if (channel != socketChannel) {
                    send(channel, userId + " 退出了群聊\n\r");
                }
            }
        }

        /**
         * 扩散说话内容
         *
         * @param socketChannel
         * @param msg
         */
        public static void propagate(SocketChannel socketChannel, String msg) {
            String userId = USER_MAP.get(socketChannel);
            for (SocketChannel channel : USER_MAP.keySet()) {
                if (channel != socketChannel) {
                    send(channel, userId + ": " + msg);
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
            final ByteBufAllocator allocator = ByteBufAllocator.DEFAULT;
            final ByteBuf writeBuffer = allocator.buffer(msg.getBytes().length);
            writeBuffer.writeCharSequence(msg, Charset.defaultCharset());
            socketChannel.writeAndFlush(writeBuffer);
        }
    }
}
