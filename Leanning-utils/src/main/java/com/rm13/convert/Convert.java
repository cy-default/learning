package com.rm13.convert;

import org.springframework.beans.BeanUtils;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-28
 */
public class Convert {

   static <R extends Class, P> Object convert(P source, R targetClass){
       Object target = null;
       try {
           target = targetClass.newInstance();
           BeanUtils.copyProperties(source, target);
           return target;
       } catch (InstantiationException e) {
           e.printStackTrace();
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       }
       return null;

   }
}
