package com.rm13.cloud.ribboncore;

import org.springframework.data.redis.serializer.*;
import sun.nio.cs.StandardCharsets;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/10/15
 */
public class SerializableTest {

    public static void main(String[] args) {

        // jackson
        final GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        final byte[] serialize = genericJackson2JsonRedisSerializer.serialize("1");
        // 1
        System.out.println(new String(serialize));

        // jackson
        final Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(String.class);
        final byte[] serialize2 = jackson2JsonRedisSerializer.serialize("1");
        // 1
        System.out.println(new String(serialize2));

        // jdk
        final JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
        final byte[] serialize1 = jdkSerializationRedisSerializer.serialize("1");
        // 整数1序列化： �� sr java.lang.Integer⠤���8 I valuexr java.lang.Number������  xp   
        // 字符串"1"序列化：�� t 1
        System.out.println(new String(serialize1));

        //
        final GenericToStringSerializer genericToStringSerializer = new GenericToStringSerializer(String.class);
        final byte[] serialize3 = genericToStringSerializer.serialize("1");
        // 1
        System.out.println(new String(serialize3));

        //
        final StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        final byte[] serialize4 = stringRedisSerializer.serialize("1");
        // 1
        System.out.println(new String(serialize4));
    }
}
