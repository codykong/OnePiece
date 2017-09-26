package com.xten.op.bitmap.undertow.path;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;


/**
 * Description:
 * User: kongqingyu
 * Date: 2017/9/12
 */
public class PathHandlerDemo implements HttpHandler {

    public static final String PATH = "/path";

    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
        exchange.getResponseSender().send("check");
    }
}
