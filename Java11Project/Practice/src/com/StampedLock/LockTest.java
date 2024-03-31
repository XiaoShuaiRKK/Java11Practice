package com.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class LockTest {
    public static void main(String[] args) {
        LockTest.Point point = new LockTest().new Point();

        Thread thread = new Thread(()->{
            for (double i = 0.0;i < 5000.0;i++){
                point.move(i,i + 2.0);
            }
        });
        Thread thread1 = new Thread(()->{
           for(int i=0;i<10000;i++)
               System.out.println(point.distanceFromOrigin());
        });
        thread.start();
        thread1.start();
    }

    class Point{
        private double x,y;
        private final StampedLock sl = new StampedLock();
        void move(double deltaX,double deltaY){
            //StampedLock加锁成功后都会返回一个stamp值 后面要解锁的话要传入此值
            long stamp = sl.writeLock();
            try {
                x += deltaX;
                y += deltaY;
            }finally {
                sl.unlockWrite(stamp);
            }
        }

        //乐观读锁
        double distanceFromOrigin(){
            //获得一个乐观读锁
            long stamp = sl.tryOptimisticRead();
            //将两个字段读入本地局部变量
            double currentX = x,currentY = y;
            //检查发出乐观锁后同时是否还有其它写锁发生
            if(!sl.validate(stamp)){
                //如果没有就获得一个悲观锁
                stamp = sl.readLock();
                try {
                    currentX = x;
                    currentY = y;
                }finally {
                    sl.unlockRead(stamp);
                }
            }
            return Math.sqrt(currentX * currentX + currentY * currentY);
        }

        //悲观读锁
        void moveIfAtOrign(double newX,double newY){
            long stamp = sl.readLock();
            try {
                //循环检查状态是否符合
                while (x == 0.0 && y == 0.0){
                    //将读锁转成写锁
                    long ws = sl.tryConvertToWriteLock(stamp);
                    //检查转锁是否成功
                    if(ws != 0L){
                        stamp = ws;
                        x = newX;
                        y = newY;
                        break;
                    }else{ //如果不能成功转换
                        //显式释放读锁
                        sl.unlockRead(stamp);
                        //显式进行写锁
                        stamp = sl.writeLock();
                    }
                }
            }finally {
                //释放锁
                sl.unlock(stamp);
            }
        }
    }
}
