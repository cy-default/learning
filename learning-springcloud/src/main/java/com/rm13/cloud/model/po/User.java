package com.rm13.cloud.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import java.time.LocalDate;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-12-11
 */
@Data
public class User {

    private String firstName;

    private String lastName;

    private Long id;

    private String a;
    private String b;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate c;
    @Min(value = 10, message = "不能小于10")
    private Integer num;
}
