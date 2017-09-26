package com.xten.op.consul.health;

import com.orbitz.consul.AgentClient;
import com.orbitz.consul.HealthClient;
import com.orbitz.consul.NotRegisteredException;
import com.xten.op.consul.ConsulService;

/**
 * Description:
 * User: kongqingyu
 * Date: 2017/9/26
 */
public class HealthDefinition {

    private static final long DEFAULT_TTL = 3;
    private final ConsulService consulService;

    public HealthDefinition(ConsulService consulService){
        this.consulService = consulService;
    }

    public void register(int port,String id,String name,String... tags) throws Exception {
        consulService.consul().agentClient().register(port,DEFAULT_TTL,name,id,tags);
        autoPass(id,DEFAULT_TTL);

    }

    public void register(int port,String id,String name,long ttl,String... tags) throws Exception {
        consulService.consul().agentClient().register(port,ttl,name,id,tags);
        autoPass(id,ttl);

    }

    private void autoPass(String id,long ttl) throws NotRegisteredException, InterruptedException {


        long slpTime =ttl/2*1000;
        /**
         * 先进行休眠，给足够的时间进行注册
         */
        Thread.sleep(slpTime);
        consulService.consul().agentClient().pass(id);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        long start = System.currentTimeMillis();
                        consulService.consul().agentClient().pass(id);
                        long slp = slpTime-(System.currentTimeMillis()-start);
                        if (slp >0){
                            Thread.sleep(slp);
                        }
                    }

                } catch (NotRegisteredException e) {
                    throw new RuntimeException(e.getMessage(),e.getCause());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage(),e.getCause());
                }

            }
        }).start();
    }


}
