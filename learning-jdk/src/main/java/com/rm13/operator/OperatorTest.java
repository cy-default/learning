package com.rm13.operator;


import lombok.extern.slf4j.Slf4j;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-11
 */
@Slf4j
public class OperatorTest {

    public static void main(String[] args) {
        int a=1,b=1;
        log.info("a&b:{}", a&b);
        // CPU数
        log.info("CPU:{}", Runtime.getRuntime().availableProcessors());
        Integer num = Integer.SIZE- 3;
        log.info("RUNNING    = -1 << COUNT_BITS:{}", -1<<num);
        log.info("SHUTDOWN   =  0 << COUNT_BITS:{}",  0<<num);
        log.info("STOP       =  1 << COUNT_BITS:{}",  1<<num);
        log.info("TIDYING    =  2 << COUNT_BITS:{}",  2<<num);
        log.info("TERMINATED =  3 << COUNT_BITS:{}",  3<<num);

    }
}
