package com.rm13.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/2
 */
public class NioTest {

    public static void main(String[] args) throws Exception {

        buffer();
        //channel1();
        channel2();

    }

    /**
     * FileChannel
     * SocketChannel
     * ServerSocketChannel
     * DatagramChannel
     */
    public static void channel1() throws Exception {
        FileInputStream in = new FileInputStream("/Users/chenyuan/Documents/project/myself/learning/learning-jdk/src/main/java/com/rm13/nio/18mm.mp4");
        FileOutputStream out = new FileOutputStream("/Users/chenyuan/Documents/project/myself/learning/learning-jdk/src/main/java/com/rm13/nio/18mmmm.mp4");
        FileChannel inChannel = in.getChannel();
        FileChannel outChannel = out.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        inChannel.close();
        outChannel.close();

        in.close();
        out.close();


    }

    public static void channel2() throws Exception {
        RandomAccessFile readFile = new RandomAccessFile("/Users/chenyuan/Documents/project/myself/learning/learning-jdk/src/main/java/com/rm13/nio/18mm.mp4", "rw");
        RandomAccessFile writeFile = new RandomAccessFile("/Users/chenyuan/Documents/project/myself/learning/learning-jdk/src/main/java/com/rm13/nio/19mm.mp4", "rw");
        FileChannel readFileChannel = readFile.getChannel();
        FileChannel writeFileChannel = writeFile.getChannel();
        readFileChannel.transferTo(0, readFile.getChannel().size(), writeFileChannel);
        readFileChannel.close();
        writeFileChannel.close();
        readFile.close();
        writeFile.close();

    }

    public static void buffer() {
        String data = "a";
        ByteBuffer bf = ByteBuffer.allocate(1024);
        System.out.println(bf.position());
        System.out.println(bf.limit());
        System.out.println(bf.capacity());
        System.out.println("=====");

        bf.put(data.getBytes());
        System.out.println(bf.position());
        System.out.println(bf.limit());
        System.out.println(bf.capacity());
        System.out.println("=====");

        bf.flip();
        System.out.println(bf.position());
        System.out.println(bf.limit());
        System.out.println(bf.capacity());
        System.out.println("=====");
    }
}
