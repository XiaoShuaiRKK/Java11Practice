package com.IO.NIO.Reactor;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Acceptor implements Runnable {
    private final ExecutorService executor = Executors.newFixedThreadPool(20);
    private final ServerSocketChannel serverSocket;

    public Acceptor(ServerSocketChannel serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            SocketChannel channel = serverSocket.accept();
            if(channel != null)
                executor.execute(new Handler(channel));//将客户端连接交给线程池处理
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
