package com.IO.BIO;

import com.IO.BIO.Client.SocketClientRequestThread;

import java.util.concurrent.CountDownLatch;

public class SocketClientDaemon {
    public static void main(String[] args) throws InterruptedException {
        int clientNumber = 20;
        CountDownLatch countDownLatch = new CountDownLatch(clientNumber);
        for(int i = 0;i < clientNumber;i++,countDownLatch.countDown()){
            SocketClientRequestThread client = new SocketClientRequestThread(countDownLatch,i);
            new Thread(client).start();
        }
        //这个wait不涉及到具体的实验逻辑，只是为了保证守护线程在启动所有线程后，进入等待状态
        synchronized (SocketClientDaemon.class){
            SocketClientDaemon.class.wait();
        }
    }
}
