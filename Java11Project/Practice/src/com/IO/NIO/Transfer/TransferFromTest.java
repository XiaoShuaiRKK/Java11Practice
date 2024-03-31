package com.IO.NIO.Transfer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * transfer from 从目标通道中去复制原通道数据
 */
public class TransferFromTest {
    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream("NIO FileChannel data.txt");
        FileOutputStream os = new FileOutputStream("NIO FileChannel data3.txt");
        FileChannel isChannel = is.getChannel();
        FileChannel osChannel = os.getChannel();
        //copy
        osChannel.transferFrom(isChannel,isChannel.position(),isChannel.size());
        isChannel.close();
        osChannel.close();
        System.out.println("copy finish");
    }
}
