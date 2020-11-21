package com.rm13.shardingsphere.dao;

import com.rm13.shardingsphere.dao.base.UserMapper;
import com.rm13.shardingsphere.model.po.User;
import com.rm13.shardingsphere.model.query.UserQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/21
 */
public interface UserDAO extends UserMapper {

    List<User> list(@Param("query") UserQuery query);
}
