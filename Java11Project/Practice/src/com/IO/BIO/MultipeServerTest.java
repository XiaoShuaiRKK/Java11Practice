package com.IO.BIO;

import com.IO.BIO.Server.SocketServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultipeServerTest {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(20057);
        while (true){
            Socket socket = serverSocket.accept();
            SocketServerThread socketServerThread = new SocketServerThread(socket);
            new Thread(socketServerThread).start();
        }
    }
}
