package com.rm13.wx.learningwx.util;

import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Test;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/2
 */
public class AesTest {

    @Test
    public void aesTest(){
        final byte[] result = Base64.decodeBase64("20PQmo8xLWk0onA9uP9DGrNwrbONBpZivu45NOjqFdh"+"=");
        System.out.println(new String(result));

    }
}
