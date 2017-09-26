package com.xten.op.balkimo.concurrent.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/6/28
 * Time: 下午8:57
 */
public class ReentrantLockCase {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        lock.isHeldByCurrentThread();

        PrintThread printThread = new PrintThread();



        new Runnable(){

            @Override
            public void run() {
                try {
                    printThread.printWorld();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.run();

//        new Runnable(){
//
//            @Override
//            public void run() {
//                try {
//                    printThread.printWorld();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.run();

    }


}


