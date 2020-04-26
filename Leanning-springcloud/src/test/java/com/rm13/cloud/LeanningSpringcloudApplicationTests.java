package com.rm13.cloud;

import com.sun.media.sound.SoftTuning;
import org.springframework.boot.test.context.SpringBootTest;

class LeanningSpringcloudApplicationTests {

    public static void main(String[] args) {
        int[] arr = new int[10];
        int a = 10;
        System.out.println(arr.getClass());
        Object ccc = arr;
        System.out.println(ccc);

        System.out.println(arr.getClass().getSuperclass());
    }

}
