package com.rm13.jvm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * -Xms40m -Xmx40m -Xmn20m -Xss1m -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDateStamps  -XX:+PrintGCDetails -Xloggc:/Users/chenyuan/Documents/project/collect/Leanning/Leanning-jdk/src/main/java/com/rm13/jvm/OOMTestGC.log -XX:HeapDumpPath=/Users/chenyuan/Documents/project/collect/Leanning/Leanning-jdk/src/main/java/com/rm13/jvm
 *
 *
 *
 */
public class OOMTest {

    private static List<Byte[]> result = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException, IOException {

        while (true){
            result.add(new Byte[1024*1]);
        }
    }
}
