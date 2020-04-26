package com.learn.data.springdata.repository;

import com.learn.data.springdata.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/25
 */
public interface CommentRepository extends MongoRepository<Comment, String> {
}
