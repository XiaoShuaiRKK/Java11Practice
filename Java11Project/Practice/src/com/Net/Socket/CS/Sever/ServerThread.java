package com.Net.Socket.CS.Sever;

import com.Net.Socket.CS.Client.ClientThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerThread implements Runnable {

    private final ServerSocket serverSocket;
    private final int port;
    private String serverName;
    private final Map<String,ClientThread> clients = new HashMap<>();
    private int clientNumbers;
    public void joinServer(ClientThread client){
        clients.put(client.getClientName(),client);
        clientNumbers++;
    }

    public ClientThread getClient(String clientName){
        return clients.get(clientName);
    }

    public ClientThread exitClient(String clientName){
        ClientThread clientThread = getClient(clientName);
        clients.remove(clientName);
        return clientThread;
    }

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

    public ServerThread(int port) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(port);
    }

    public ServerThread(ServerSocket serverSocket) throws IOException {
        this.port = serverSocket.getLocalPort();
        this.serverSocket = serverSocket;
    }

    public ServerSocket getServerSocket() {
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
                System.out.println("Socket Join");
                new Thread(() -> {
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        while (true){
                            System.out.println(br.readLine());
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
