package com.IO.NIO.ScatterAndGather;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 分散读取(Scatter) 把channel的数据读入到多个buffer中去
 * 聚集写入(Gathering) 把多个buffer中的数据聚集到channel中
 */
public class ChannelTest {
    public static void main(String[] args) throws IOException {
        scatterAndGathering();
    }

    private static void scatterAndGathering() throws IOException {
        FileInputStream is = new FileInputStream("NIO FileChannel data.txt");
        FileChannel isChannel = is.getChannel();
        FileOutputStream os = new FileOutputStream("NIO FileChannel data2.txt");
        FileChannel osChannel = os.getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.put("hello.data".getBytes());
        //定义多个缓冲区做数据分散
        ByteBuffer buffer1 = ByteBuffer.allocate(4);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);
        ByteBuffer[] buffers = {buffer1,buffer2};
        //从通道读取数据分散到各个缓冲区
        isChannel.read(buffers);
        //从每个缓冲区中查看数据是否读取
        for(ByteBuffer buffer : buffers){
            buffer.flip();
            System.out.println(new String(buffer.array(),0,buffer.remaining()));
        }
        //聚集写入到通道
        osChannel.write(buffers);
        isChannel.close();
        osChannel.close();
        System.out.println("file copy");
    }
}
