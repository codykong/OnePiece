package com.xten.op.consul;

import com.google.common.net.HostAndPort;
import com.orbitz.consul.Consul;

/**
 * Description:
 * User: kongqingyu
 * Date: 2017/9/26
 */
public class ConsulUtils {

    public static Consul consul(String hostAndPort){
        return Consul.builder().withHostAndPort(HostAndPort.fromString(hostAndPort)).build();
    }

    public static Consul localConsul(){
        return Consul.builder().withHostAndPort(HostAndPort.fromString("127.0.0.1:8414")).build();
    }

    public static String hostAndPort() {
        return "127.0.0.1:8414";
    }





}
