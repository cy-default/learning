package com.rm13.spring.service;

import com.alibaba.fastjson.JSON;
import com.rm13.spring.dao.BookDao;
import com.rm13.spring.domain.entity.Blue;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    // 注入所有BookDao类型的bean
    @Autowired
    private List<BookDao> bookDaoList;

    @Autowired
    private Map<String, BookDao> bookDaoMap;


    public void print(){
        log.info(JSON.toJSONString(bookDao));
    }
}
