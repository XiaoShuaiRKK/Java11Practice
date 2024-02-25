package com.Net.Socket.CS.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable {
    private final int port;
    private final Socket socket;
    private final String clientName;

    public ClientThread(String ip, int port, String clientName) throws IOException {
        this.port = port;
        this.socket = new Socket(ip,port);
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            while (true){
                pw.println(clientName + " : " + br.readLine());
                pw.flush();
                Thread.sleep(500);
            }
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
