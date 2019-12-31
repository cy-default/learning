package com.rm13.cloud.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/17
 */
@Slf4j
@Service
public class AsyncService {


    @Async("rm13TaskExecutor")
    public void endlessLoop() throws InterruptedException {
        while(true){
            for(int i=1; i<1000; i++){

            }
            Thread.sleep(10);
            log.info("Thread.sleep(10)");
        }
    }
}
