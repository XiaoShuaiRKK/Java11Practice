package com.Net.Socket.CC.Server;

import com.Net.Socket.CC.Client.ClientSocket;
import com.Net.Socket.CS.Client.ClientThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerSocket implements Runnable {
    private final java.net.ServerSocket serverSocket;
    private final int port;
    private String serverName;
    private final List<Socket> clients = new ArrayList<>();
    private int clientNumbers;

    public int getClientNumbers() {
        return clientNumbers;
    }

    public int getPort() {
        return port;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public ServerSocket(int port) throws IOException {
        this.port = port;
        this.serverSocket = new java.net.ServerSocket(port);
    }

    public ServerSocket(java.net.ServerSocket serverSocket) throws IOException {
        this.port = serverSocket.getLocalPort();
        this.serverSocket = serverSocket;
    }

    public java.net.ServerSocket getServerSocket() {
        return serverSocket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Server start up");
            System.out.println("Server Info: IP/" + serverSocket.getInetAddress() + " Port/" + port);
            System.out.println("Server read now");
            while (true){
                Socket socket = serverSocket.accept();
                clients.add(socket);
                System.out.println("Socket Join");
                new Thread(() -> {
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        while (true){
                            String msg = br.readLine();
                            System.out.println(msg);
                            clients.forEach((c) -> {
                                try {
                                    PrintWriter pw = new PrintWriter(c.getOutputStream());
                                    pw.println(msg);
                                    pw.flush();
                                }catch (IOException e){
                                    e.printStackTrace();
                                }
                            });
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
