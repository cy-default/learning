package com.rm13.cloud.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import java.time.LocalDate;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/3/24
 */
@Data
public class User2 {
    private String a;
    private String b;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate c;
    @Min(value = 10, message = "不能小于10")
    private Integer num;
}
