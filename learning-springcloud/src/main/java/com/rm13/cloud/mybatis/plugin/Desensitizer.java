package com.rm13.cloud.mybatis.plugin;

import java.util.function.Function;

/**
 * 具体策略的函数
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/8/12
 */
public interface Desensitizer extends Function<String, String> {
}
