package com.Concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 会议
 * 要求count个人进来后开始会议
 */
public class Meet implements Runnable {

    /**
     * CountDownLatch一般用作多线程倒计时计数器，强制它们等待其他一组（CountDownLatch的初始化决定）任务执行完成
     * 计数器大于0时,await()会一直阻塞
     */
    private final CountDownLatch controller;

    public Meet(int count){
        controller = new CountDownLatch(count);
    }

    public void arrive(String name){
        System.out.println(name + " 到达会议室");
        controller.countDown();
    }

    @Override
    public void run() {
        System.out.println("会议开启还需要" + controller.getCount() + " 个人");
        try {
            controller.await();
            System.out.println("所以人到达完");
            System.out.println("会议开始");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
