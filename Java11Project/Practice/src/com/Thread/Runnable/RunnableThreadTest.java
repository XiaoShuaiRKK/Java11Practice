package com.Thread.Runnable;

public class RunnableThreadTest {
    public static void main(String[] args) {
        Thread micro = new Thread(new MicroRunnableThread());
        micro.start();
        MyRunnableThread microThread = new MyRunnableThread("XS");
        microThread.start();
    }
}

