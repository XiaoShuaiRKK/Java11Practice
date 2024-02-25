package com.Thread;

import java.util.function.Consumer;

public class ThreadTest {
    public static void main(String[] args) {
//        priorityTest();
        yieTest();
    }

    private static void yieTest(){
        Thread t1 = new Thread(() -> {
            for(int i=0;i<10;i++){
                if(i % 2 == 0)
                    Thread.yield();
                System.out.println("Thread 1 : " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i=0;i<10;i++){
                System.out.println("Thread 2 : " + i);
            }
        });
        t1.start();
        t2.start();
    }

    private static void priorityTest(){
        Consumer<Thread> printer = Thread::start;
        Consumer<Thread> printer2 = Thread::start;
        Consumer<String> printFunction = (s) -> {
            for(int i=0;i<10;i++)
                System.out.println(s + " : " + i + " round");
        };
        Consumer<Thread> checkIsAlive = (t) -> {
            if (t.isAlive())
                System.out.println(t.getName() + " is alive");
        };
        var t1 = new Thread(() -> printFunction.accept("Thread 1"),"Thread One");
        var t2 = new Thread(() -> printFunction.accept("Thread 2"),"Thread Two");
        t1.setPriority(10);
        t2.setPriority(9);
        printer.accept(t1);
        printer2.accept(t2);
        checkIsAlive.accept(t1);
        checkIsAlive.accept(t2);
    }

    private static void normalTest(){
        Thread thread = new Thread(() -> {
            for(int i = 0;i < 10;i++)
                System.out.println("Thread: Say in " + i);
        },"MyThread");
        thread.start();
    }
}
