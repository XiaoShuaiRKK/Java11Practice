package com.Net.Socket.CC.Client;

import com.sun.source.tree.WhileLoopTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket implements Runnable {
    private final int port;
    private final Socket socket;
    private final String clientName;

    public ClientSocket(String ip, int port, String clientName) throws IOException {
        this.port = port;
        this.socket = new Socket(ip,port);
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public int getPort() {
        return port;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader brToServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            new Thread(() -> {
                try {
                    while (true){
                        pw.println(clientName + " : " + br.readLine());
                        pw.flush();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    while (true){
                        System.out.println(brToServer.readLine());
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }).start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
