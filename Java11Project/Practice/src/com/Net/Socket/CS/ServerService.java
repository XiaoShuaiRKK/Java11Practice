package com.Net.Socket.CS;

import com.Net.Socket.CS.Sever.ServerThread;

import java.io.IOException;

public class ServerService {
    public static void main(String[] args) {
        try {
            ServerThread server = new ServerThread(20013);
            ServerList.getInstance().addServer(server);
            new Thread(server).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
