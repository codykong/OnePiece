package com.xten.op.balkimo.thread.communication;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/1/18
 * Time: 下午5:37
 */
public class DBTools {

    private volatile boolean prevIsA = false;

     public void backupA(){
        try {
            synchronized("a"){
                System.out.println("AAAAAAAAA start");

                System.out.println("AAAAAAAAA end");
            }

//            while (prevIsA){
//                wait();
//            }


//            prevIsA = true;
//
//            notifyAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backupB(){
        try {

            synchronized("a"){
                System.out.println("BBBBBBB start");
                System.out.println("BBBBBBB end");
            }

//            while (!prevIsA){
//                wait();
//            }

//            notifyAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
