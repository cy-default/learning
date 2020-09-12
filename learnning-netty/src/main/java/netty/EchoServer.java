package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/12
 */
public class EchoServer {

    public static void main(String[] args) throws InterruptedException {
        // 1：声明线程（必须）
        // bossGroup处理Accept事件， workerGroup处理消息的读写事件
        EventLoopGroup acceptorGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup clientGroup = new NioEventLoopGroup();

        // 2：创建服务端引导类（必须）
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        // 3：设置线程池（必须）
        serverBootstrap.group(acceptorGroup, clientGroup);

        // 4：设置netty以何种IO模型运行（必须）
        // OioServerSocketChannel/NioServerSocketChannel/EpollServerSocketChannel
        serverBootstrap.channel(NioServerSocketChannel.class);

        // 5：设置参数(可选)
        // 一般不用设置
        serverBootstrap.option(ChannelOption.SO_BACKLOG, 100);

        // 6：设置Handler(可选)
        // 可以通过ChannelInitializer设置多个
        serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));

        // 7：编写并设置子Handler（必须）
        // handler分2种；inbound/outbound
        // 设置子handler设置的是SocketChannel对应的Handler，也只能设置1个。用于处理socketChannel事件。
        // 虽然只能设置一个，但是可以通过ChannelInitializer设置多个。
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline p = ch.pipeline();
                // 可以添加多个子Handler
                p.addLast(new LoggingHandler(LogLevel.INFO));
                p.addLast(new EchoServerHandler());
            }
        });

        // 8：绑定端口（必须）
        // 绑定端口，并启动服务端程序， sync() 会阻塞直到启动完成才执行后面的代码。
        ChannelFuture channelFuture = serverBootstrap.bind(8080).sync();

        // 9：等待服务端端口关闭（必须）
        // 等待服务端监听端口关闭，sync () 会阻塞主线程，内部调用的是 Object 的 wait () 方法。
        channelFuture.channel().closeFuture().sync();

        // 10：优雅地关闭线程池（建议）
        acceptorGroup.shutdownGracefully();
        clientGroup.shutdownGracefully();
    }

    private static class EchoServerHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            // 读取数据后写回客户端
            ctx.write(msg);
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) {
            ctx.flush();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            cause.printStackTrace();
            ctx.close();
        }
    }
}
