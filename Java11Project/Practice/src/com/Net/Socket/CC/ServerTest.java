package com.Net.Socket.CC;

import com.Net.Socket.CC.Server.ServerSocket;

import java.io.IOException;

public class ServerTest {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(20005);
            new Thread(server).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
