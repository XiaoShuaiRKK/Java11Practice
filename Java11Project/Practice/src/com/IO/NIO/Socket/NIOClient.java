package com.IO.NIO.Socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.MappedByteBuffer;

public class NIOClient {
    public static void main(String[] args) throws IOException {
        for(int i=0;i<20;i++)
            new Thread(new ClientSocketThread("127.0.0.1",20057,"User-" + i)).start();
    }

    static class ClientSocketThread implements Runnable{

        private final String ip;
        private final int port;
        private final String name;
        private final Socket socket;

        ClientSocketThread(String ip, int port, String name) throws IOException {
            this.ip = ip;
            this.port = port;
            this.name = name;
            this.socket = new Socket(ip,port);
        }

        @Override
        public void run() {
            try(OutputStream outputStream = socket.getOutputStream()) {
                outputStream.write((name + ": hello").getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
