package com.rm13.cloud.tmp;

import com.rm13.cloud.model.po.User;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/5
 */
public class Test {

    public static void main(String[] args) {

        /*
        final User user = new User();
        user.setFirstName("lovemyrm13");

        final GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        byte[] lovemyrm13s = genericJackson2JsonRedisSerializer.serialize(user);
        final String result = new String(lovemyrm13s);
        System.out.println("-------");
        System.out.println(result);

         */

        final ArrayList<Integer> integers = new ArrayList<>();
        System.out.println(integers.stream().filter(t -> t > 0).collect(Collectors.toList()));



    }
}
