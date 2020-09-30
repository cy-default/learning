package netty;

import cn.hutool.core.date.StopWatch;
import io.netty.util.concurrent.DefaultEventExecutor;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/24
 */
public class PromiseTest {

    public static void main(String[] args) {

        // 构造线程池
        final DefaultEventExecutor eventExecutors = new DefaultEventExecutor();

        // 构建promise实例
        final DefaultPromise promise = new DefaultPromise(eventExecutors);

        promise.addListener((GenericFutureListener<Future<Integer>>) future -> {
            if(future.isSuccess()){
                System.out.println("任务结束，结果："+future.get());
            }else{
                System.out.println("任务失败，异常："+future.cause());
            }
        });
        promise.addListener((GenericFutureListener<Future<Integer>>) future -> {
            System.out.println("任务结束，balabala。。。");
        });


        eventExecutors.submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // main线程阻塞等待执行结果
        try {
            promise.sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
