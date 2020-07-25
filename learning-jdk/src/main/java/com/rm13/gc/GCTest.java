package com.rm13.gc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * BASE GC
 * <p>
 * -server -Xms10M -Xmx10M -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails
 * </p>
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/25
 */
public class GCTest {

    /*
        2020-07-25T10:03:28.869-0800: [GC (Allocation Failure) [PSYoungGen: 2048K->512K(2560K)] 2048K->677K(9728K), 0.0041796 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
        2020-07-25T10:03:28.884-0800: [GC (Allocation Failure) [PSYoungGen: 668K->496K(2560K)] 6833K->6685K(9728K), 0.0014892 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
        2020-07-25T10:03:28.886-0800: [GC (Allocation Failure) --[PSYoungGen: 2534K->2534K(2560K)] 8723K->8771K(9728K), 0.0015557 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        2020-07-25T10:03:28.887-0800: [Full GC (Ergonomics) [PSYoungGen: 2534K->0K(2560K)] [ParOldGen: 6237K->4505K(7168K)] 8771K->4505K(9728K), [Metaspace: 3149K->3149K(1056768K)], 0.0055580 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
        2020-07-25T10:03:28.893-0800: [GC (Allocation Failure) [PSYoungGen: 2048K->64K(2560K)] 6553K->6569K(9728K), 0.0017479 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        2020-07-25T10:03:28.895-0800: [Full GC (Ergonomics) [PSYoungGen: 64K->0K(2560K)] [ParOldGen: 6505K->6505K(7168K)] 6569K->6505K(9728K), [Metaspace: 3149K->3149K(1056768K)], 0.0038010 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
        2020-07-25T10:03:28.899-0800: [GC (Allocation Failure) [PSYoungGen: 0K->0K(1536K)] 6505K->6505K(8704K), 0.0002872 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        2020-07-25T10:03:28.899-0800: [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(1536K)] [ParOldGen: 6505K->6488K(7168K)] 6505K->6488K(8704K), [Metaspace: 3149K->3149K(1056768K)], 0.0066578 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
        Heap
         PSYoungGen      total 1536K, used 49K [0x00000007bfd00000, 0x00000007c0000000, 0x00000007c0000000)
          eden space 1024K, 4% used [0x00000007bfd00000,0x00000007bfd0c560,0x00000007bfe00000)
          from space 512K, 0% used [0x00000007bff80000,0x00000007bff80000,0x00000007c0000000)
          to   space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
         ParOldGen       total 7168K, used 6488K [0x00000007bf600000, 0x00000007bfd00000, 0x00000007bfd00000)
          object space 7168K, 90% used [0x00000007bf600000,0x00000007bfc56000,0x00000007bfd00000)
         Metaspace       used 3181K, capacity 4496K, committed 4864K, reserved 1056768K
          class space    used 350K, capacity 388K, committed 512K, reserved 1048576K

        Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     */


    public static void main(String[] args) throws InterruptedException {
        List<Byte> byteArryList = new ArrayList<Byte>();
        while (true) {
            Byte[] bytes = new Byte[1024 * 500];
           //byteArryList.addAll(Arrays.asList(bytes));
            TimeUnit.MILLISECONDS.sleep(1000);
        }

    }
}
