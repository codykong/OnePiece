package com.xten.op.bitmap.undertow;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;

/**
 * Description:
 * User: kongqingyu
 * Date: 2017/9/12
 */
public class HttpServer {

    private final Undertow server;

    public HttpServer(String host, int port, HttpHandler httpHandler) {

        server = getServer(host,port,httpHandler);

    }

    public Undertow getServer(String host,int port,HttpHandler httpHandler) {

        Undertow server = Undertow.builder()
                .addHttpListener(port, host)
                .setHandler(httpHandler).build();

        return server;

    }


    public void start(){
        server.start();

    }


}
