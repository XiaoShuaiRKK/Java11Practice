package com.IO.NIO.Reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 反应器
 *
 */
public class Reactor implements Runnable {
    private final Selector selector;
    private final ServerSocketChannel serverSocket;

    public Reactor(int port) throws IOException{
        serverSocket = ServerSocketChannel.open();//创建服务端的ServerSocketChannel
        serverSocket.configureBlocking(false);//设置为非阻塞模式
        selector = Selector.open();//创建一个Selector多路复用器
        SelectionKey key = serverSocket.register(selector,SelectionKey.OP_ACCEPT);
        serverSocket.bind(new InetSocketAddress(port));//绑定服务端端口
        key.attach(new Acceptor(serverSocket));//为服务端Channel绑定一个Acceptor
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                selector.select(); // 服务端使用一个线程不断等待客户端的连接到达
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()){
                    dispatch(iterator.next());
                    iterator.remove();
                }
                selector.selectNow();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void dispatch(SelectionKey key){
        Runnable attachment = (Runnable) key.attachment();
        attachment.run();
    }
}
