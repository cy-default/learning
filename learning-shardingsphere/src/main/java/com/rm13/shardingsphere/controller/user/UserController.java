package com.rm13.shardingsphere.controller.user;

import com.github.pagehelper.PageInfo;
import com.rm13.shardingsphere.model.base.PageParam;
import com.rm13.shardingsphere.model.base.Result;
import com.rm13.shardingsphere.model.query.UserQuery;
import com.rm13.shardingsphere.model.vo.UserVO;
import com.rm13.shardingsphere.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/list")
    public Result<List<UserVO>> list(@RequestBody UserQuery query) {
        List<UserVO> result = userService.list(query);
        return Result.success(result);
    }

    @PostMapping("/list/page")
    public Result<PageInfo<UserVO>> page(@RequestBody PageParam<UserQuery> query) {
        PageInfo<UserVO> page = userService.page(query);
        return Result.success(page);
    }

    @GetMapping("/{id}")
    public Result<UserVO> info(@PathVariable("id") Integer id) {
        UserVO userVO = userService.get(id);
        return Result.success(userVO);
    }
}
