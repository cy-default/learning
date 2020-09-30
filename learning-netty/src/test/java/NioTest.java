import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.io.IOException;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/27
 */
public class NioTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        final ServerBootstrap serverBootstrap = new ServerBootstrap();
        final NioEventLoopGroup boss = new NioEventLoopGroup(1);
        final NioEventLoopGroup child = new NioEventLoopGroup();

        serverBootstrap.group(boss, child)
                .handler(new LoggingHandler(LogLevel.INFO))
                .option(ChannelOption.SO_BACKLOG, 100)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        final ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new LoggingHandler(LogLevel.INFO));
                    }
                });

        final ChannelFuture channelFuture = serverBootstrap.bind(8888).sync();

        channelFuture.channel().closeFuture().sync();

        boss.shutdownGracefully();
        child.shutdownGracefully();

    }

}
