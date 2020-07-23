package com.learn.data.springdata;

import com.alibaba.fastjson.JSON;
import com.learn.data.springdata.domain.Comment;
import com.learn.data.springdata.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
@SpringBootTest
class MongoRepositoryTests {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void saveTest() {

        final Random random = new Random();

        for (int num = 0; num < 100; num++) {
            Comment comment = new Comment();
            comment.setArticleId(String.valueOf(random.nextInt(10000000)));
            comment.setContent("创建业务逻辑类 cn.itcast.article包下创建service包");
            comment.setCreateDateTime(LocalDateTime.now());
            comment.setLikeNum(Long.valueOf(random.nextInt(100000)));
            comment.setNickName("张三"+ random.nextInt(100));
            comment.setParentId(String.valueOf(random.nextLong()));
            comment.setPublishTime(LocalDateTime.now());
            comment.setReplyNum(Long.valueOf(random.nextInt(50)));
            comment.setState(String.valueOf(random.nextInt(2)));
            comment.setUserId(String.valueOf(random.nextLong()));
            comment = commentRepository.save(comment);
            log.info("result:{}",comment.toString());
        }
    }

    @Test
    void findByIdTest(){
        final Optional<Comment> result = commentRepository.findById("5ea3d8dd6e86cc70109ad52a");
        if(result.isPresent()){
            log.info(JSON.toJSONString(result.get()));
        }
    }

    @Test
    void findAllTest(){
        final List<Comment> all = commentRepository.findAll();
        for (Comment comment : all) {
            log.info(JSON.toJSONString(comment));
        }
    }

}
