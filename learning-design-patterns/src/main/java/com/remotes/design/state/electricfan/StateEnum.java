package com.remotes.design.state.electricfan;

import lombok.Data;
import lombok.Getter;

/**
 * 状态机 状态枚举
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/6
 */
@Getter
public enum StateEnum {
    /**
     * low speed
     */
    LOW_SPEED(1, 300, "low speed"),

    /**
     * medium speed
     */
    MEDIUM_SPEED(2, 600, "medium speed"),

    /**
     * high speed
     */
    HIGH_SPEED(3, 900, "high speed"),

    /**
     * turning off
     */
    TURNING_OFF(4, 0, "turning off");

    private Integer code;
    private Integer spreed;
    private String desc;

    StateEnum(Integer code, Integer spreed, String desc) {
        this.code = code;
        this.spreed = spreed;
        this.desc = desc;
    }
    public static StateEnum getName(Integer no){
        for (StateEnum value : StateEnum.values()) {
            if(value.code.equals(no)){
                return value;
            }
        }
        return null;
    }

}
