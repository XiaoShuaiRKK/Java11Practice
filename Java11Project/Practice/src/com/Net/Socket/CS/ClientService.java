package com.Net.Socket.CS;

import com.Net.Socket.CS.Client.ClientThread;
import com.Net.Socket.CS.Sever.ServerThread;

import java.io.IOException;

public class ClientService {
    public static void main(String[] args) {
        try {
            ClientThread client = new ClientThread("0.0.0.0",20013,"XS");
            new Thread(client).start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
