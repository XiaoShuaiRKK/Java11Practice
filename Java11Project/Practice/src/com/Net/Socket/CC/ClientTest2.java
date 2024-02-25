package com.Net.Socket.CC;

import com.Net.Socket.CC.Client.ClientSocket;

import java.io.IOException;

public class ClientTest2 {
    public static void main(String[] args) {
        try {
            ClientSocket client = new ClientSocket("0.0.0.0",20005,"Client 2");
            new Thread(client).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
