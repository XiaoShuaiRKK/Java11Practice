package com.IO.BIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingleServerTest {
    private static final Logger LOGGER = Logger.getLogger("com.IO.BIO.SingleServerTest");

    static {
        LOGGER.setLevel(Level.INFO);
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(20057);
        try {
            Socket socket = serverSocket.accept();
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            int sourcePort = socket.getPort();
            int maxLen = 2048;
            byte[] contextBytes = new byte[maxLen];
            int realLen = in.read(contextBytes,0,maxLen);
            String msg = new String(contextBytes,0,realLen);
            LOGGER.info("服务器收到来自于端口" + sourcePort + "的信息" + msg + "\n");
            out.write("回应响应信息".getBytes());
            out.close();
            in.close();
            socket.close();
        }catch (Exception e){
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        }finally {
            serverSocket.close();
        }
    }
}
