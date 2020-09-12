import io.netty.util.NettyRuntime;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/12
 */
public class NCPUTest {

    public static void main(String[] args) {
        // CPU 核数
        System.out.println(Runtime.getRuntime().availableProcessors());
        // netty 默认线程数
        System.out.println(NettyRuntime.availableProcessors() * 2);

    }
}
