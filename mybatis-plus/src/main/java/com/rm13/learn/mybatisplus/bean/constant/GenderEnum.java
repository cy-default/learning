package com.rm13.learn.mybatisplus.bean.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum GenderEnum {

    MAN(0, "男"),
    WOMAN(1, "女");

    @EnumValue
    private Integer code;
    private String value;

    GenderEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
