package com.Concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) {
        int num = 10;
        Meet conference = new Meet(num);
        new Thread(conference).start();
        for(int i=0;i < num;i++){
            Paticipant p = new Paticipant(conference,"老总" + i);
            new Thread(p).start();
        }
    }

}
