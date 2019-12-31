package com.rm13.shiro.convertor;

import com.rm13.shiro.model.bo.UserBO;
import com.rm13.shiro.model.generator.User;
import com.rm13.shiro.model.vo.UserVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/23
 */
@Mapper(componentModel = "spring")
public abstract class AbstractUserConvertor {

    /**
     * do to bo
     * @param user
     * @return
     */
    public abstract UserBO doToBo(User user);

    /**
     * dos to bos
     * @param users
     * @return
     */
    public abstract List<UserBO> dosToBos(List<User> users);

    /**
     * bo to vo
     * @param userBO
     * @return
     */
    public abstract UserVO boToVo(UserBO userBO);

    /**
     * bos to vos
     * @param userBOs
     * @return
     */
    public abstract List<UserVO> bosToVos(List<UserBO> userBOs);


}
