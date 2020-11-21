package com.rm13.shardingsphere.util;

import com.rm13.shardingsphere.model.vo.UserVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 字段赋值通用类
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/9
 */
public class CommonFieldsUtil {

    /**
     * 初始化通用字段
     *
     * @param t
     * @param user
     * @param <T>
     */
    public static <T> void initCommonsFiled(T t, UserVO user) {
        final Field[] declaredFields = t.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            insertFiled(t, declaredField, user);
            updateFiled(t, declaredField, user);
        }
    }


    /**
     * 初始化通用字段
     *
     * @param ts
     * @param user
     * @param <T>
     */
    public static <T> void initCommonsFileds(List<T> ts, UserVO user) {
        if (CollectionUtils.isNotEmpty(ts)) {
            for (T t : ts) {
                if (t == null) {
                    continue;
                }
                initCommonsFiled(t, user);
            }
        }
    }

    /**
     * 更新通用字段
     *
     * @param t
     * @param user
     * @param <T>
     */
    public static <T> void updateCommonsFiled(T t, UserVO user) {
        final Field[] declaredFields = t.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            updateFiled(t, declaredField, user);
        }
    }


    /**
     * 更新通用字段
     *
     * @param ts
     * @param user
     * @param <T>
     */
    public static <T> void updateCommonsFileds(List<T> ts, UserVO user) {
        if (CollectionUtils.isNotEmpty(ts)) {
            for (T t : ts) {
                if (t == null) {
                    continue;
                }
                updateCommonsFiled(t, user);
            }
        }
    }


    private static <T> void insertFiled(T t, Field declaredField, UserVO user) {
        try {
            if ("createBy".equals(declaredField.getName()) && user != null && StringUtils.isNotBlank(user.getUsername())) {
                declaredField.set(t, user.getUsername());
            }
            if ("createTime".equals(declaredField.getName())) {
                declaredField.set(t, LocalDateTime.now());
            }
            if ("deleteFlag".equals(declaredField.getName())) {
                declaredField.set(t, false);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static <T> void updateFiled(T t, Field declaredField, UserVO user) {
        try {
            if ("modifyBy".equals(declaredField.getName()) && user != null && StringUtils.isNotBlank(user.getUsername())) {
                declaredField.set(t, user.getUsername());
            }
            if ("modifyTime".equals(declaredField.getName())) {
                declaredField.set(t, LocalDateTime.now());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}