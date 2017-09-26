package com.xten.op.balkimo.anything;

/**
 * Description:
 * User: kongqingyu
 * Date: 2017/9/20
 */
public class ShutdownHook {

    public static void main(String[] args) throws InterruptedException {

        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                System.out.println("ShutdownHook has bean added");
            }

        });


        System.out.println("start main");
        Thread.sleep(1000);
        System.out.println("end main");
    }
}
