package com.Concurrent.CountDownLatch;

public class Paticipant implements Runnable {

    private final Meet meet;
    private final String name;

    public Paticipant(Meet meet, String name) {
        this.meet = meet;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(50);
            meet.arrive(name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
