package tmp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.nio.charset.StandardCharsets;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/19
 */
public class IO_NIOTest_NettyTest {

    public static void main(String[] args) throws InterruptedException {
        final NioEventLoopGroup boss = new NioEventLoopGroup(1);
        final NioEventLoopGroup child = new NioEventLoopGroup();

        final ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(boss, child)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 0)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        final ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new LoggingHandler(LogLevel.DEBUG));
                        pipeline.addLast(new EchoServerHandler());
                    }
                });

        final ChannelFuture channelFuture = serverBootstrap.bind(8888).sync();
        System.out.println("111-------");
        channelFuture.channel().closeFuture().sync();
        System.out.println("222-------");
        boss.shutdownGracefully();
        child.shutdownGracefully();

    }

    public static void send(SocketChannel socketChannel, String msg) {
        final ByteBufAllocator aDefault = ByteBufAllocator.DEFAULT;
        final ByteBuf buffer = aDefault.buffer(msg.getBytes().length);
        buffer.writeCharSequence(msg, StandardCharsets.UTF_8);
        socketChannel.writeAndFlush(buffer);

    }


    private static class EchoServerHandler extends SimpleChannelInboundHandler {

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
            final ByteBuf msg1 = (ByteBuf) msg;
            final byte[] bytes = new byte[msg1.readableBytes()];
            msg1.readBytes(bytes);
            final String result = new String(bytes, StandardCharsets.UTF_8);
            System.out.println(result);
            ctx.write(msg);
        }
    }
}
