package com.learn.data.springdata.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 文章评论实体类
 *
 *
 * @author chenyuan
 */
@Data
@Document(collection="tb_comment")
@CompoundIndex(def = "{'userId': 1, 'content': 1}")
public class Comment implements Serializable {

    /**
     * 主键，
     * @该属性的值回自动对应mongodb的主键字段"_id"
     */
    @Id
    private String id;

    /**
     * 吐槽内容,
     * @该属性对应mongodb的字段的名字，如果一致，则无需该注解
     */
    @Field("content")
    private String content;

    /**
     * 发布时间
     */
    private LocalDateTime publishTime;

    /**
     * 发布人ID
     */
    private String userId;

    /**
     * 发布人昵称
     * @添加一个单字段索引
     */
    @Indexed
    private String nickName;

    /**
     * 评论的日期时间
     */
    private LocalDateTime createDateTime;

    /**
     * 点赞数
     */
    private Long likeNum;

    /**
     * 回复数
     */
    private Long replyNum;

    /**
     * 状态，是否可见
     */
    private String state;

    /**
     * 上级ID
     */
    private String parentId;

    /**
     * 对应文章ID
     */
    private String articleId;

    /**
     * @临时字段，使用@transient忽略注解
     */
    @Transient
    private String tmpFiled;

}
