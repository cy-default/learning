package com.remotes.design.template.demo2;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-23
 */
public class Test {
    public static void main(String[] args) {

        SearchParam search = new SearchParam();

        PageResult result =  new QueryTemplate<Object>(){
            @Override
            public List<Object> pageQuery() {

                // 实现具体的业务逻辑查询。
                List result = new ArrayList();
                result.add("aa");
                result.add("bb");
                return result;
            }
        }.pageResult(search);

        System.out.println(result.toString());
    }
}
