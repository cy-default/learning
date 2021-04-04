package com.rm13.learn.mybatisplus.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 通用字段填充
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 创建时间
     */
    public static final String CREATE_TIME = "createTime";

    /**
     * 修改时间
     */
    public static final String UPDATE_TIME = "updateTime";

    @Override
    public void insertFill(MetaObject metaObject) {
        boolean createTime = metaObject.hasSetter(CREATE_TIME);
        if (createTime) {
            this.strictInsertFill(metaObject, CREATE_TIME, LocalDateTime.class, LocalDateTime.now());
        }
        insertUpdateCommonFill(metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        insertUpdateCommonFill(metaObject);
    }

    /**
     * 插入、修改都需要填充的字段
     *
     * @param metaObject
     */
    private void insertUpdateCommonFill(MetaObject metaObject) {
        boolean updateTime = metaObject.hasSetter(UPDATE_TIME);
        if (updateTime) {
            this.strictInsertFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
        }
    }
}