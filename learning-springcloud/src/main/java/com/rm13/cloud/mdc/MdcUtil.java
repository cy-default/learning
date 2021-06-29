package com.rm13.cloud.mdc;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import java.util.UUID;

@Slf4j
public class MdcUtil {

    public final static String TRACE_ID = "TRACE-ID";

    /**
     * 设置traceId
     */
    public static void setTraceId(String traceId) {
        if (StringUtils.isBlank(traceId)) {
            traceId = UUID.randomUUID().toString().replace("-", "");
        }
        MDC.put(MdcUtil.TRACE_ID, traceId);
    }

    /**
     * remove traceId
     */
    public static void removeTraceId() {
        MDC.remove(MdcUtil.TRACE_ID);
    }

    /**
     * 生产traceid
     * @return
     */
    public static String generateTraceId() {
        String traceId = UUID.randomUUID().toString().replace("-", "");
        return traceId;
    }
}
