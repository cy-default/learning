package com.rm13.learn.mybatisplus.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.rm13.learn.mybatisplus.bean.constant.GenderEnum;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("user")
public class UserVo implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField(value = "name")
    private String name;
    private Integer age;
    private String email;

    @Version
    private Integer version;

    /**
     * 支持枚举类型
     */
    private GenderEnum gender;


    /**
     * 支持逻辑删除字段
     */
    private Integer deleteFlag;

    /**
     * 插入时自动填充创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时自动填充修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
