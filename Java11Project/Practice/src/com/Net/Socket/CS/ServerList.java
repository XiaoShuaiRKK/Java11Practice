package com.Net.Socket.CS;

import com.Net.Socket.CS.Sever.ServerThread;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServerList {

    private static final ServerList INSTANCE = new ServerList();

    public static synchronized ServerList getInstance(){
        return INSTANCE;
    }

    private final List<ServerThread> servers = new ArrayList<>();

    public void addServer(ServerThread server){
        servers.add(server);
    }

    public ServerThread getServer(){
        servers.sort(Comparator.comparingInt(ServerThread::getClientNumbers));
        return servers.get(0);
    }
}
