package com.rm13.cloud.retry;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/25
 */
public interface RetryService {

    /**
     * 基于注解方式的重试服务
     *
     * @param sql
     * @return
     */
    String annotationRetryService(String sql);

    /**
     * 基于用户自定义retryTemplate实现方式
     *
     * @param sql
     * @return
     */
    String custRetryService(String sql);


    /**
     * 异常最后执行的方法
     *
     * @param e
     * @param sql
     * @return
     */
    String recover(Exception e, String sql);
}
