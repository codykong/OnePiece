package com.xten.op.redis;

import redis.clients.jedis.Jedis;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/6/16
 * Time: 上午11:42
 */
public class JedisUtil {

    private static final String REDIS_HOST="localhost";

    public static Jedis build(){
        return  new Jedis(REDIS_HOST);
    }

}
