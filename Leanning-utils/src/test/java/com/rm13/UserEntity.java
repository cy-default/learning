package com.rm13;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-13
 */
@Data
@EqualsAndHashCode
public class UserEntity {

    private String name;
    private String city;
    private Integer age;

    public UserEntity(String name, String city, Integer age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public static List<UserEntity> init(){
        List<UserEntity> result = new ArrayList<UserEntity>();
        UserEntity user = new UserEntity("张三","上海", 40);
        result.add(user);
        user = new UserEntity("李四","上海",30);
        result.add(user);
        user = new UserEntity("李四","上海",30);
        result.add(user);
        user = new UserEntity("李四","上海",30);
        result.add(user);
        user = new UserEntity("王五","北京",32);
        result.add(user);
        user = new UserEntity("找六","深圳",28);
        result.add(user);
        return result;
    }
}
