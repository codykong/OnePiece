package com.xten.op.balkimo.concurrent.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/6/28
 * Time: 下午9:16
 */
public class PrintThread {

    Lock lock = new ReentrantLock();

    public void printWorld() throws InterruptedException {
        System.out.println("start:current Thread is "+ Thread.currentThread().getName()+
                ",time is:"+System.currentTimeMillis());
        try{
            lock.lock();
            Thread.sleep(2000);
        }finally {
            lock.unlock();
        }

        System.out.println("end:current Thread is "+ Thread.currentThread().getName()+
                ",time is:"+System.currentTimeMillis());

    }
}
