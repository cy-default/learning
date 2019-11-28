package com.rm13.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.rm13.springboot.annotation.Logg;
import com.rm13.springboot.domain.ActionLog;
import com.rm13.springboot.response.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author lovemyrmb
 * @Description: 记录操作日志(基于注解)
 * @date 2018-11-02 14:45
 */
@Slf4j
@RestController
@RequestMapping("/logg")
public class LoggController {

    /**
     * @param
     * @return
     * @RequestBody用来处理非Content-Type: application/x-www-form-urlencoded编码格式的数据。
     */
    @Logg("操作日志")
    @PostMapping(value = "/demo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultResponse index(@RequestBody ActionLog actionLog) {
        log.info("ActionLog:{}", JSON.toJSONString(actionLog));
        return ResultResponse.success(Arrays.asList("记录操作日志(基于注解)"));
    }
}
