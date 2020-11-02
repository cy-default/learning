package com.rm13.cloud.converter.string2localdate;

import com.rm13.cloud.login.passlogin.PassLogin;
import com.rm13.cloud.model.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/14
 */
@Slf4j
@PassLogin
@RestController
@RequestMapping("/datehandler")
public class LocalDateController {

    /**
     * http://localhost:8080/datehandler/demo1?localDate=2020-01-01
     *
     * 参考<>https://mp.weixin.qq.com/s/IiOTrsMmc7YgbdClRJVvjw</>
     *
     * GET请求及POST表单日期时间字符串格式转换
     * <p>
     * (MethodArgumentTypeMismatchException: Failed to convert value of type 'java.lang.String' to required type 'java.time.LocalDate';)
     * <p>
     * 前端json转后端pojo底层使用的是Json序列化Jackson工具（HttpMessgeConverter）；而时间字符串作为普通请求参数传入时，转换用的是Converter，两者在处理方式上是有区别。
     *
     * @param localDate
     * @return
     */
    @GetMapping("/demo1")
    public LocalDate demo1(LocalDate localDate) {
        log.info(localDate.toString());
        return localDate;
    }


    @GetMapping("/demo2")
    public LocalDate demo2(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate localDate) {
        log.info(localDate.toString());
        return localDate;
    }

    /**
     * post form 表单的形式提交
     * @param user
     * @return
     */
    @PostMapping(value = "/demo3", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public User demo3(User user) {
        log.info(user.toString());
        return user;
    }

    /**
     * post application/json的形式传递
     * @param user
     * @return
     */
    @PostMapping(value = "/demo4", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User demo4(User user) {
        log.info(user.toString());
        return user;
    }
}
