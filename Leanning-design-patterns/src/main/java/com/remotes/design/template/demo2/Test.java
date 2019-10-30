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

        PageResult result =  new PageTemplate<UserVO, Search>(){
            @Override
            public List<UserVO> pageQuery(Search search) {

                // 实现具体的业务逻辑查询。
                List result = new ArrayList();
                UserVO userVO = new UserVO("张三");
                result.add(userVO);
                userVO = new UserVO("李四");
                result.add(userVO);
                return result;
            }
        }.pageResult(search);

        System.out.println(result.toString());
    }
}
