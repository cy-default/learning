package com.rm13.spring.ioc.dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * 名字默认是类名首字母小写的形式注入到IOC容器中
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Repository
@Data
public class BookDao {

    private String label = "1";

}
