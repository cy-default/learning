package com.rm13.trycatch;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-15
 */
@Slf4j
public class TryCatchTest {


    public static void main(String[] args) {
        log.info("main..start");
        tryCatch();
        log.info("main..end");
    }


    public static String tryCatch(){
        try{
            log.info("try");
            int num = 1/0;
            return "try";
        }finally {
            log.info("finally");
        }
    }
}
