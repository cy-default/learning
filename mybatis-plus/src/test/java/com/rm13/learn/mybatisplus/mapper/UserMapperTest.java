package com.rm13.learn.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rm13.learn.mybatisplus.MybatisPlusApplication;
import com.rm13.learn.mybatisplus.po.User;
import com.rm13.learn.mybatisplus.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisPlusApplication.class)
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 测试查询列表
     */
    @Test
    public void testSelect() {
        log.info("select all test");
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /**
     * 测试插入；
     * 1：测试id自动生成策略
     * 2：测试数据库自增的形式插入后，实体对象里面有没有id属性值
     * 3：测试创建时间、修改时间自动填充
     */
    @Test
    public void testInsert() {
        User user = new User();
        user.setAge(19);
        user.setEmail("lovemyrm13@aliyun.com");
        user.setName("rm13");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);
    }

    /**
     * 测试乐观锁
     */
    @Test
    public void testVersion() {
        User user = userMapper.selectById(1);
        user.setName("rm13333");
        int i = userMapper.updateById(user);
        System.out.println(user);
    }

    /**
     * 测试逻辑删除
     */
    @Test
    public void testLogicDel() {
        int i = userMapper.deleteById(1);
        // 查不到
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    /**
     * 测试创建时间、修改时间自动填充
     */
    @Test
    public void testFill() {
        User user = new User();
        user.setAge(19);
        user.setEmail("lovemyrm13@aliyun.com");
        user.setName("rm13");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);

        user = userMapper.selectById(2);
        user.setName("rm14");
        userMapper.updateById(user);
        System.out.println(user);
    }


    @Test
    public void testPage(){
        Page page = new Page(1, 2);
        IPage<UserVo> userVoIPage = userMapper.selectPageVo(page, 19);
        userVoIPage.getRecords().forEach(System.out::println);
    }
}