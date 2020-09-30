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
public class NettyTest {

    public static void main(String[] args) throws InterruptedException {
        final NioEventLoopGroup boss = new NioEventLoopGroup(1);
        final NioEventLoopGroup child = new NioEventLoopGroup();

        final ServerBootstrap serverBootstrap = new ServerBootstrap();
        final EchoServerHandler echoServerHandler = new EchoServerHandler();
        serverBootstrap.group(boss, child)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler())
                .option(ChannelOption.SO_BACKLOG, 100)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        final ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new LoggingHandler(LogLevel.INFO));
                        pipeline.addLast(echoServerHandler);
                    }
                });

        final ChannelFuture sync = serverBootstrap.bind(8000).sync();

        sync.channel().closeFuture().sync();

        boss.shutdownGracefully();
        child.shutdownGracefully();


    }

    public static void send(SocketChannel socketChannel, String msg){
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
            msg1.writeBytes(bytes);
            final String result = new String(bytes, StandardCharsets.UTF_8);
            System.out.println(result);
            ctx.write(msg);
        }
    }
}
