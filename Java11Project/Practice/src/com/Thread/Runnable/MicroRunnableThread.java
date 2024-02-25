package com.Thread.Runnable;

public class MicroRunnableThread implements Runnable {

    @Override
    public void run() {
        try {
            for(int i = 10;i > 0;i--){
                System.out.println("MicroRunnable Thread: " + i);
                Thread.sleep(50);
            }
        }catch (InterruptedException e){
            System.out.println("MicroRunnable Thread: " + e.getMessage());
        }
        System.out.println("MicroRunnable Thread: exiting");
    }
}
