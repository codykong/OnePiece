package com.xten.op.redis;

import redis.clients.jedis.Jedis;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/6/16
 * Time: 上午11:49
 */
public class RedisClientTest {

    public static void main(String[] args) {

        Jedis jedis = JedisUtil.build();

        jedis.set("test","hello world!");
        byte[] d = jedis.dump("test");
        System.out.println(d);
        System.out.println(jedis.get("test"));
    }
}
