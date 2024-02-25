package com.IO.BIO.Client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketClientRequestThread implements Runnable{
    public static final Logger LOGGER = Logger.getLogger("com.IO.BIO.Client.SocketClientRequestThread");
    private CountDownLatch countDownLatch;
    private Integer clientIndex;

    public SocketClientRequestThread(CountDownLatch countDownLatch, Integer clientIndex) {
        this.countDownLatch = countDownLatch;
        this.clientIndex = clientIndex;
    }

    static {
        LOGGER.setLevel(Level.INFO);
    }

    @Override
    public void run() {

        try(Socket socket = new Socket("localhost",20057);
            OutputStream clientRequest = socket.getOutputStream();
            InputStream clientResponse = socket.getInputStream())
        {
            //等SocketClientDaemon完成所有线程的启动，然后所有线程一起发送请求
            countDownLatch.await();
            clientRequest.write(("这是第" + clientIndex + " 个客户端的请求").getBytes());
            clientRequest.flush();
            //等待服务器返回信息
            SocketClientRequestThread.LOGGER.info("第" + this.clientIndex + " 个客户端请求发生完成,等待服务器响应");
            int maxLen = 1024,realLen;
            byte[] contextBytes = new byte[maxLen];
            StringBuilder msg = new StringBuilder();
            while ((realLen = clientResponse.read(contextBytes,0,maxLen)) != 1)
                msg.append(new String(contextBytes, 0, realLen));
            SocketClientRequestThread.LOGGER.info("服务器信息:" + msg);
        }catch (Exception e){
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        }
    }
}
