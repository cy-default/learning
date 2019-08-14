package com.rm13.snowflake;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * 雪花算法
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-08
 */
public class SnowflakeTest {

    public static void main(String[] args){
        Snowflake snowflake = IdUtil.createSnowflake(10, 11);
        System.out.println(snowflake.nextId());
    }
}
