package com.rm13.shardingsphere.service;

import com.rm13.shardingsphere.model.po.User;
import com.rm13.shardingsphere.model.query.UserQuery;
import com.rm13.shardingsphere.model.vo.UserVO;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/21
 */
public interface UserService extends BaseService<UserQuery, UserVO>{


    /**
     * 用户详情
     * @param id
     * @return
     */
    UserVO get(Integer id);
}
