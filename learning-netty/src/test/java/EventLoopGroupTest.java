import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.NettyRuntime;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/12
 */
public class EventLoopGroupTest {
    public static void main(String[] args) {

        // event loop 事件循环
        // event loop group 事件循环组

        EventLoopGroup bossGroup = new NioEventLoopGroup();
    }
}
