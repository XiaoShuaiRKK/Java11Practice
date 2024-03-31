package com.IO.NIO.NewFileChannel;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) throws IOException {
        write();
        read();
    }

    private static void read() throws IOException{
        FileInputStream fis = new FileInputStream("NIO FileChannel data.txt");
        FileChannel channel = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        channel.close();
        buffer.flip();
        System.out.println(new String(buffer.array(),0,buffer.remaining()));
    }

    private static void write() throws IOException {
        //字节输出流通向目标文件
        FileOutputStream fos = new FileOutputStream("NIO FileChannel data.txt");
        //得到字节输出流对应的通道
        FileChannel outChannel = fos.getChannel();
        //分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("hello".getBytes());
        //缓冲区切换写出模式
        buffer.flip();
        outChannel.write(buffer);
        outChannel.close();
    }
}
