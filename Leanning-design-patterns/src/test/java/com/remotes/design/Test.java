package com.remotes.design;

import com.remotes.design.strategy.Cashier;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-18
 */
public class Test {

    public static void main(String[] args) {

        try {
            User user  = User.class.newInstance();
            System.out.println(user);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public static void join1(){
        List<String> list = Arrays.asList("11","22","23");

        //最传统写法：
        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s);
        }

        System.out.println(sb.toString());

        //如果想要加个分隔符，比如逗号，传统写法：
        sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));

            if(i < list.size() - 1){
                sb.append(",");
            }
        }
        System.out.println(sb.toString());

        //使用commons-lang库写法, 其实这个已经够简单了，就这个功能而言，我很喜欢，而且最最常用：
        System.out.println(StringUtils.join(list.toArray(), ","));

        //进入jdk8时代：
        System.out.println(list.stream().collect(Collectors.joining()));
        //jdk8时代，加个分隔符：
        System.out.println(list.stream().collect(Collectors.joining(",")));
    }
}
