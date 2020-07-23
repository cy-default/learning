package com.rm13.cloud.resolve;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/21
 */
@ControllerAdvice
public class ControllerStringParamTrimConfig {


    /**
     * 接收 url 或 form 表单中的参数
     * 对于这种情况，Spring MVC 提供了一个 org.springframework.beans.propertyeditors.StringTrimmerEditor 类，我们只需要在参数绑定中进行注册就行
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 创建 String trim 编辑器
        // 构造方法中 boolean 参数含义为如果是空白字符串,是否转换为null
        // 即如果为true,那么 " " 会被转换为 null,否者为 ""
        StringTrimmerEditor propertyEditor = new StringTrimmerEditor(false);
        // 为 String 类对象注册编辑器
        binder.registerCustomEditor(String.class, propertyEditor);
    }
}
