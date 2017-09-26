package com.xten.op.bitmap.undertow.path;

import com.xten.op.bitmap.undertow.HttpServer;
import io.undertow.server.handlers.PathHandler;

/**
 * Description:
 * User: kongqingyu
 * Date: 2017/9/26
 */
public class PathServerAppDemo {

    public static void main(String[] args) {


        startServer();
    }

    public static void startServer(){
        PathHandler pathHandler = new PathHandler();

        pathHandler.addExactPath(PathHandlerDemo.PATH,new PathHandlerDemo());

        HttpServer httpServer = new HttpServer("127.0.0.1",8080,pathHandler);
        httpServer.start();
    }
}
