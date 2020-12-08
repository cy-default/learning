package com.rm13.cloud.mdc;

import org.slf4j.MDC;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Map;
import java.util.UUID;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/12/1
 */
public class TraceThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {

    @Override
    public void execute(Runnable task) {

        super.execute(wrap(task, MDC.getCopyOfContextMap()));
    }

    private static Runnable wrap(final Runnable runnable, final Map<String, String> context) {
        return () -> {
            if (context == null) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            setTraceIdIfAbsent();
            try {
                runnable.run();
            } finally {
                MDC.clear();
            }
        };
    }

    private static void setTraceIdIfAbsent() {
        if (MDC.get(MdcAspect.TRACE_ID) == null) {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            uuid = "snmt-job-" + uuid;
            MDC.put(MdcAspect.TRACE_ID, uuid);
        }
    }
}

