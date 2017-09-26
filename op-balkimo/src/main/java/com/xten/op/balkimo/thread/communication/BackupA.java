package com.xten.op.balkimo.thread.communication;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/1/18
 * Time: 下午5:42
 */
public class BackupA extends Thread {

    private DBTools dbTools;

    public BackupA(DBTools dbTools){
        this.dbTools = dbTools;
    }

    @Override
    public void run(){
        dbTools.backupA();
    }
}
