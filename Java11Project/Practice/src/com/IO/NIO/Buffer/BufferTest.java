package com.IO.NIO.Buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferTest {
    public static void main(String[] args) {
//        basicApiTest();
        apiTest();
//        markApiTest();
//        directTest();
    }

    /**
     * 直接内存
     */
    private static void directTest(){
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        System.out.println("Direct: " + buffer.isDirect());
    }

    private static void markApiTest(){
        //分配容量
        CharBuffer charBuffer = CharBuffer.allocate(10);
        System.out.println("Load");
        printBufferInfo(charBuffer);
        //写入数据
        charBuffer.put("hello");
        System.out.println("Put()");
        printBufferInfo(charBuffer);
        charBuffer.flip();
        printBufferInfo(charBuffer);
        int i = 0;
        while (charBuffer.position() < charBuffer.limit() && i < 5){
            System.out.print(charBuffer.get());
            if (charBuffer.position() == 2)
                charBuffer.mark();
            if (charBuffer.position() == 4){
                i++;
                charBuffer.reset();
            }
        }
        System.out.println();
        printBufferInfo(charBuffer);
    }

    private static void apiTest(){
        //分配容量
        CharBuffer charBuffer = CharBuffer.allocate(10);
        System.out.println("Load");
        printBufferInfo(charBuffer);
        //写入数据
        charBuffer.put("hello");
        System.out.println("Put()");
        printBufferInfo(charBuffer);
        //将position重置
        charBuffer.clear();
        System.out.println("Clear()");
        printBufferInfo(charBuffer);
        //再次写入
        charBuffer.put("world");
        printBufferInfo(charBuffer);
        charBuffer.flip();
        while (charBuffer.hasRemaining())
            System.out.print(charBuffer.get());
        System.out.println();
        printBufferInfo(charBuffer);
    }

    private static void basicApiTest(){
        //分配容量
        CharBuffer charBuffer = CharBuffer.allocate(10);
        System.out.println("Load");
        printBufferInfo(charBuffer);
        //写入数据
        charBuffer.put("hello");
        System.out.println("Put()");
        printBufferInfo(charBuffer);
        //切换读数据模式
        charBuffer.flip();
        System.out.println("Flip()");
        printBufferInfo(charBuffer);
        while (charBuffer.position() < charBuffer.limit())
            System.out.print(charBuffer.get());
        System.out.println();
        System.out.println("Get()");
        printBufferInfo(charBuffer);
    }

    private static void printBufferInfo(Buffer buffer){
        System.out.println("Capacity: " + buffer.capacity() + ", Limit: " + buffer.limit()
                + ", Position: " + buffer.position());
        System.out.println("Buffer中是否还有元素:" + buffer.hasRemaining());
    }
}
