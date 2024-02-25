package com.Thread.Runnable;

import com.sun.security.jgss.GSSUtil;

public class MyRunnableThread extends Thread implements Runnable {
    private final String name;
    private Thread thread;

    public MyRunnableThread(String name){
        this.name = name;
    }

    public MyRunnableThread(String name, Thread thread) {
        this.name = name;
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            for(var i = 0;i < 10;i++){
                System.out.println();
                System.out.printf("%s Thread : %d",name,i);
                Thread.sleep(50);
            }
        }catch (InterruptedException e){
            System.out.println();
            System.out.printf("%s Thread : %s",name,e.getMessage());
        }
    }

    @Override
    public synchronized void start() {
        System.out.println();
        System.out.printf("%s Thread Start",name);
        if(thread == null)
            thread = new Thread(this,name);
        thread.start();
    }
}
