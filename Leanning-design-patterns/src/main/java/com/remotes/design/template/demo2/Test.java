package com.remotes.design.template.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-23
 */
public class Test {
    public static void main(String[] args) {

        Search search = new Search();

        // lambda
        PageResult result = ((PageTemplate<UserVO, Search>) t -> {

            // 实现具体的业务逻辑查询。
            List result1 = new ArrayList();
            UserVO userVO = new UserVO("张三");
            result1.add(userVO);
            userVO = new UserVO("李四");
            result1.add(userVO);
            return result1;
        }).pageResult(search);

        System.out.println(result.toString());
    }
}
