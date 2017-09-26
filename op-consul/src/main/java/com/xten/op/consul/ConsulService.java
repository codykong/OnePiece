package com.xten.op.consul;

import com.google.common.base.Optional;
import com.google.common.net.HostAndPort;
import com.google.common.net.InetAddresses;
import com.orbitz.consul.Consul;
import com.orbitz.consul.KeyValueClient;
import com.orbitz.consul.model.kv.Value;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 * User: kongqingyu
 * Date: 2017/9/26
 */
public class ConsulService {

    private final Consul consul ;
    private final KeyValueClient kvClient;
    private final String agentHost;
    private final int agentPort;


    public ConsulService(String hostAndPort){
        consul = this.consul(hostAndPort);
        kvClient = consul.keyValueClient();
        String[] items = hostAndPort.split(":");
        this.agentHost = items[0];
        this.agentPort = Integer.valueOf(items[1]) ;

    }

    public ConsulService(Integer port) throws UnknownHostException {
        this.agentHost = InetAddress.getLocalHost().getHostAddress();
        this.agentPort = port;

        consul = this.consul(this.agentHost+":"+this.agentPort);
        kvClient = consul.keyValueClient();
    }



    public static Consul consul(String hostAndPort){
        return Consul.builder().withHostAndPort(HostAndPort.fromString(hostAndPort)).build();
    }

    public Consul consul(){
        return this.consul;
    }



    /**
     * 增加K/V 到kv store
     * @param key
     * @param value
     * @return
     */
    public Boolean putValue(String key, String value){

        return kvClient.putValue(key, value);
    }


    /**
     * 通过key获取value
     * @param key
     * @return
     */
    public Optional<String> getValue(String key){

        Optional<String> value = kvClient.getValueAsString(key);
        return value;
    }

    /**
     * 获取string类型的值集合
     * @param key
     * @return
     */
    public List<String> getValuesAsString(String key){

        List<String> result = new ArrayList<>();

        List<Value> values = kvClient.getValues(key);
        if (values!=null){
            result = values.stream().filter(v -> v.getValue().isPresent())
                    .map(v -> v.getValueAsString().get()).collect(Collectors.toList());
        }

        return result;
    }
    /**
     * 删除某个key
     * @param key
     */
    public void deleteKey(String key){
        kvClient.deleteKey(key);
    }

    public void deleteKeys(String key){
        kvClient.deleteKeys(key);
    }

    public List<String> getKeys(String key){
        List<String> keys = kvClient.getKeys(key);

        return keys;
    }


    public String getAgentHost() {
        return agentHost;
    }

    public int getAgentPort() {
        return agentPort;
    }
}

