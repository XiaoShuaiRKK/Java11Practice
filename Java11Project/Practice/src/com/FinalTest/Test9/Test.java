package com.FinalTest.Test9;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(() -> System.out.println("Hello"));
        Future<String> future = es.submit(() -> "World");
        System.out.println(future.get());
        es.shutdown();
    }
}
