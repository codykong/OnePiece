package com.xten.op.consul.service;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.xten.op.akka.util.AkkaUtils;
import com.xten.op.bitmap.undertow.path.PathServerAppDemo;
import com.xten.op.consul.ConsulService;
import com.xten.op.consul.ConsulUtils;

/**
 * Description:
 * User: kongqingyu
 * Date: 2017/9/26
 */
public class ServiceDefinitionDemo {


    public static void main(String[] args) throws Exception {

        registerTcpService();

    }

    /**
     * 以undertow 启动端口为8080 的http 服务，并监听该服务
     * @throws Exception
     */
    public static void registerHttpService() throws Exception {

        PathServerAppDemo.startServer();
        ConsulService consulService = new ConsulService(ConsulUtils.hostAndPort());
        HealthDefinition healthDefinition = new HealthDefinition(consulService);

        healthDefinition.register(8080,"id1","name");

    }

    /**
     * 以akka 启动端口为2553 的netty（tcp）服务，并监听该服务
     * @throws Exception
     */
    public static void registerTcpService() throws Exception {
        Config config = ConfigFactory.load("remote.conf");

        AkkaUtils.createActorSystem("akka",config);

        ConsulService consulService = new ConsulService(ConsulUtils.hostAndPort());
        HealthDefinition healthDefinition = new HealthDefinition(consulService);

        healthDefinition.register(2553,"id1","name");
    }



}
