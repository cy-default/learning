package com.rm13.spring.service;

import com.alibaba.fastjson.JSON;
import com.rm13.spring.dao.BookDao;
import com.rm13.spring.domain.entity.Blue;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
@Service
@Data
// @RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookService {
   // private final BookDao bookDao;

    //@Qualifier("bookDao")
    //@Autowired(required=false)
    //@Resource(name="bookDao2")
    //@Inject

    @Autowired
    private BookDao bookDao;

    public void print(){
        log.info(JSON.toJSONString(bookDao));
    }
}
