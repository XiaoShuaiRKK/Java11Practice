package com.IO.NIO.File;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        fastCopy("D:\\LL banner\\40.png","D:\\LL banner\\LLCD\\1.png");
        long e = System.currentTimeMillis();
        System.out.println("操作时间: " + (e - s) + " ms");
    }

    private static void fastCopy(String src,String dist) throws IOException {
        //获取源文件的输入字节流
        FileInputStream fin = new FileInputStream(src);
        //获取输入字节流的文件通道
        FileChannel fcin = fin.getChannel();
        //获取目标文件的输出字节流
        FileOutputStream fout = new FileOutputStream(dist);
        //获取输出字节流的通道
        FileChannel fcout = fout.getChannel();
        //缓冲区分配1024个字节
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        while (true){
            int r = fcin.read(buffer);
            if(r == -1)
                break;
            //切换读写
            buffer.flip();
            fcout.write(buffer);
            buffer.clear();
        }
    }
}
