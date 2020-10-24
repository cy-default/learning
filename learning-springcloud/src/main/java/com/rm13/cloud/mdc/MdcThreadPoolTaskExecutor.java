package com.rm13.cloud.mdc;

import org.slf4j.MDC;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/10/24
 */
public class MdcThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {

    final private boolean useFixedContext;
    final private Map<String, String> fixedContext;

    /**
     * Pool where task threads take MDC from the submitting thread.
     */
    public static MdcThreadPoolTaskExecutor newWithInheritedMdc(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                                                TimeUnit unit, int queueCapacity) {
        return new MdcThreadPoolTaskExecutor(null, corePoolSize, maximumPoolSize, keepAliveTime, unit, queueCapacity);
    }

    private MdcThreadPoolTaskExecutor(Map<String, String> fixedContext, int corePoolSize, int maximumPoolSize,
                                      long keepAliveTime, TimeUnit unit, int queueCapacity) {
        setCorePoolSize(corePoolSize);
        setMaxPoolSize(maximumPoolSize);
        setKeepAliveSeconds((int) unit.toSeconds(keepAliveTime));
        setQueueCapacity(queueCapacity);
        this.fixedContext = fixedContext;
        useFixedContext = (fixedContext != null);
    }

    private Map<String, String> getContextForTask() {
        return useFixedContext ? fixedContext : MDC.getCopyOfContextMap();
    }

    /**
     * All executions will have MDC injected. {@code ThreadPoolExecutor}'s submission methods ({@code submit()} etc.)
     * all delegate to this.
     */
    @Override
    public void execute(Runnable command) {
        super.execute(wrap(command, getContextForTask()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task, getContextForTask()));
    }


    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return super.submit(wrap(task, getContextForTask()));
    }

    private static <T> Callable<T> wrap(final Callable<T> task, final Map<String, String> context) {
        return () -> {
            Map<String, String> previous = MDC.getCopyOfContextMap();
            if (context == null) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            try {
                return task.call();
            } finally {
                if (previous == null) {
                    MDC.clear();
                } else {
                    MDC.setContextMap(previous);
                }
            }
        };
    }

    private static Runnable wrap(final Runnable runnable, final Map<String, String> context) {
        return () -> {
            Map<String, String> previous = MDC.getCopyOfContextMap();
            if (context == null) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            try {
                runnable.run();
            } finally {
                if (previous == null) {
                    MDC.clear();
                } else {
                    MDC.setContextMap(previous);
                }
            }
        };
    }
}
