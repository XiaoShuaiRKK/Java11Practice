package com.IO.NIO.Transfer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * transfer to 把原通道数据复制到目标通道
 */
public class TransferToTest {
    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream("NIO FileChannel data.txt");
        FileOutputStream os = new FileOutputStream("NIO FileChannel data3.txt");
        FileChannel isChannel = is.getChannel();
        FileChannel osChannel = os.getChannel();
        //copy
        isChannel.transferTo(isChannel.position(),isChannel.size(),osChannel);
        isChannel.close();
        osChannel.close();
        System.out.println("copy finish");
    }
}
