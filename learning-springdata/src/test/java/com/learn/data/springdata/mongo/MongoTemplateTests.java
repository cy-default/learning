package com.learn.data.springdata.mongo;

import com.alibaba.fastjson.JSON;
import com.learn.data.springdata.domain.Account;
import com.learn.data.springdata.domain.Comment;
import com.learn.data.springdata.domain.User;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import static org.springframework.data.mongodb.core.query.Query.query;

@Slf4j
@SpringBootTest
class MongoTemplateTests {

    @Autowired
    private MongoTemplate mongoTemplate;

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
            comment.setParentId(String.valueOf(random.nextInt(10000000)));
            comment.setPublishTime(LocalDateTime.now());
            comment.setReplyNum(Long.valueOf(random.nextInt(50)));
            comment.setState(String.valueOf(random.nextInt(2)));
            comment.setUserId(String.valueOf(random.nextInt(10000000)));
            comment = mongoTemplate.save(comment);
            log.info("mongoTemplate:{}",JSON.toJSONString(comment));
        }
    }


    @Test
    void queryTest(){
        // 模糊查询
        Query query = query(Criteria.where("nickName").regex("95"));
        final List<Comment> result1 = mongoTemplate.find(query, Comment.class);
        for (Comment comment : result1) {
            log.info("result1:{}", JSON.toJSONString(comment));
        }
        // 精确查询
        query = query(Criteria.where("userId").is("5473400").and("state").is("1"));
        final List<Comment> result2 = mongoTemplate.find(query, Comment.class);
        for (Comment comment : result2) {
            log.info("result2:{}", JSON.toJSONString(comment));
        }
    }

    @Test
    void updateTest(){
        final User user = new User();
        user.setName("陈4");
        user.setAddress("上海");
        final Account account = new Account();
        account.setPrice(new BigDecimal("20.34"));
        account.setType("上海浦发银行");
        user.setAccount(account);
        mongoTemplate.save(user);
        log.info("user:{}", JSON.toJSONString(user));

    }

    @Test
    void update2Test(){
        final User user = mongoTemplate.findById("5ea3e6a3af30aa402a70b032", User.class);
        log.info("update2Test:{}", user);
        final UpdateResult id = mongoTemplate.updateMulti(query(Criteria.where("_id").is("5ea3e6a3af30aa402a70b032")), new Update().inc("account.price", 1), User.class);
        log.info("update2Test:{}", id);
    }

}
