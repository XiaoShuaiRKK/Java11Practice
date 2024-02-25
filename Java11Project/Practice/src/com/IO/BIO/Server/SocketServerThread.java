package com.IO.BIO.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketServerThread implements Runnable {

    private static final Logger LOGGER = Logger.getLogger("com.IO.BIO.Server.SocketServerThread");

    static {
        LOGGER.setLevel(Level.INFO);
    }

    private final Socket socket;

    public SocketServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(InputStream in = socket.getInputStream(); OutputStream out = socket.getOutputStream())
        {
            int sourcePort = socket.getPort();
            int maxLen = 1024;
            byte[] contextBytes = new byte[maxLen];
            int realLen = in.read(contextBytes,0,maxLen);
            String msg = new String(contextBytes,0,realLen);
            LOGGER.info("服务收到来自于端口: " + sourcePort + " 的信息: " + msg);
            out.write("服务器回应的信息".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
