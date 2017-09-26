package com.xten.op.consul.health;

import com.orbitz.consul.Consul;
import com.xten.op.consul.ConsulService;
import com.xten.op.consul.ConsulUtils;

/**
 * Description:
 * User: kongqingyu
 * Date: 2017/9/26
 */
public class ServiceRegisterDemo {


    public static void main(String[] args) throws Exception {

        registerService();

    }


    public static void registerService() throws Exception {

        ConsulService consulService = new ConsulService(ConsulUtils.hostAndPort());
        HealthDefinition healthDefinition = new HealthDefinition(consulService);

        healthDefinition.register(8080,"id1","name");

    }

}
