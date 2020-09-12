package com.rm13.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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

    /**
     * 使用内存映射文件
     * @throws IOException
     */
    public static void channel3() throws IOException {
        final FileChannel readChannel = FileChannel.open(Paths.get("18mm.mp4"), StandardOpenOption.READ);
        final FileChannel writeChannel = FileChannel.open(Paths.get("20mm.mp4"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        final MappedByteBuffer readMap = readChannel.map(FileChannel.MapMode.READ_ONLY, 0, readChannel.size());
        final MappedByteBuffer writeMap = writeChannel.map(FileChannel.MapMode.READ_WRITE, 0, writeChannel.size());
        byte[] dst = new byte[readMap.limit()];
        readMap.get(dst);
        writeMap.put(dst);
        readChannel.close();
        writeChannel.close();
    }

    /**
     * 通道之间的数据传输（直接缓冲区）
     * @throws IOException
     */
    public static void channel4() throws IOException {
        final FileChannel readChannel = FileChannel.open(Paths.get("18mm.mp4"), StandardOpenOption.READ);
        final FileChannel writeChannel = FileChannel.open(Paths.get("20mm.mp4"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
        readChannel.transferTo(0, readChannel.size(), writeChannel);
        readChannel.close();
        writeChannel.close();
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
