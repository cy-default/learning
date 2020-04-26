package com.rm13.cloud.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import java.time.LocalDate;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/12
 */
public class User {
    private String a;
    private String b;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate c;
    @Min(value = 10, message = "不能小于10")
    private Integer num;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c=" + c +
                '}';
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public LocalDate getC() {
        return c;
    }

    public void setC(LocalDate c) {
        this.c = c;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
