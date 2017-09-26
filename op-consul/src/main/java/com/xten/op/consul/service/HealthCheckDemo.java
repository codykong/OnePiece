package com.xten.op.consul.service;

import com.orbitz.consul.cache.ConsulCache;
import com.orbitz.consul.cache.ServiceHealthCache;
import com.orbitz.consul.cache.ServiceHealthKey;
import com.orbitz.consul.model.health.ServiceHealth;
import com.orbitz.consul.option.QueryOptions;
import com.xten.op.consul.ConsulService;
import com.xten.op.consul.ConsulUtils;

import java.util.Map;
import java.util.Scanner;

/**
 * Description:
 * User: kongqingyu
 * Date: 2017/9/26
 */
public class HealthCheckDemo {

    public static void main(String[] args) throws Exception {

        ConsulService consulService = new ConsulService(ConsulUtils.hostAndPort());

        ServiceHealthCache cache = ServiceHealthCache.newCache(consulService.consul().healthClient(),
                "name",
                true,
                QueryOptions.BLANK,
                3);

        ConsulCache.Listener<ServiceHealthKey, ServiceHealth> listener = new ConsulCache.Listener<ServiceHealthKey, ServiceHealth>() {
            @Override
            public void notify(Map<ServiceHealthKey, ServiceHealth> newValues) {

                System.out.println(newValues);
            }
        };

        cache.addListener(listener);
        cache.start();

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = sc.nextLine();

    }
}
