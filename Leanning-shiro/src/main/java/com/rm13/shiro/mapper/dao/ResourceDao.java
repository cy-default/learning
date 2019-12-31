package com.rm13.shiro.mapper.dao;

import com.rm13.shiro.mapper.base.ResourceMapper;
import com.rm13.shiro.mapper.base.UserMapper;
import com.rm13.shiro.model.generator.Resource;
import com.rm13.shiro.model.generator.User;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/23
 */
public interface ResourceDao extends ResourceMapper {

    /**
     * 根据登陆账户查询用户权限
     * @param username
     * @return
     */
    List<Resource> selectResourceByUserName(String username);


}
