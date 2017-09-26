package com.xten.op.balkimo.thread.communication;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/1/18
 * Time: 下午5:43
 */
public class Run {

    public static void main(String[] args) {
        DBTools dbTools = new DBTools();

        for (int i =0;i<2;i++){
            BackupB output =new BackupB(dbTools);
            output.start();
//            BackupA input =new BackupA(dbTools);
//            input.start();
        }
    }
}
