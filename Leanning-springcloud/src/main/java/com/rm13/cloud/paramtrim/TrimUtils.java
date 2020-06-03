package com.rm13.cloud.paramtrim;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 去掉bean中所有属性为字符串的前后空格
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/6
 */
@Slf4j
public class TrimUtils {
    /**
     * 去掉bean中所有属性为字符串的前后空格
     *
     * @param bean
     * @throws Exception
     */
    public static void trimObject(Object bean) {
        try {
            if (bean != null) {
                //获取所有的字段包括public,private,protected,private
                Field[] fields = bean.getClass().getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    field.setAccessible(true);
                    final Annotation[] declaredAnnotations = field.getDeclaredAnnotations();

                    // 获取字段注解
                    if(declaredAnnotations==null || declaredAnnotations.length<1){
                        continue;
                    }

                    // 判定字段是否有@Trim注解
                    final boolean contains = Arrays.asList(declaredAnnotations).contains(Trim.class);
                    if(!contains){
                        continue;
                    }

                    // 对String.class类型的字段值去除前后空格
                    if (String.class.equals(field.getType())) {
                        //获取字段名
                        Object value = field.get(bean);
                        if (StringUtils.isEmpty(value)) {
                            continue;
                        }
                        value = value.toString().trim();
                        field.set(bean, value);
                    }
                }
            }
        } catch (Exception e) {
            log.error("trimObject.error:{}", e.getMessage());
        }
    }
}
