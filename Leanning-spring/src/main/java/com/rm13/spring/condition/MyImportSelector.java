package com.rm13.spring.condition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑返回需要导入的组件
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
public class MyImportSelector implements ImportSelector {

    /**
     * 返回值，就是到导入到容器中的组件全类名
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String className = importingClassMetadata.getClassName();
        log.info("MyImportSelector:{}", className);
        return new String[]{"com.rm13.spring.domain.entity.Blue","com.rm13.spring.domain.entity.Yellow"};
    }
}
