package com.xten.op.redis;

import com.xten.op.common.util.PrintUtil;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/6/16
 * Time: 上午11:49
 */
public class HashCase {

    public static void main(String[] args) {

        Jedis jedis = JedisUtil.build();

        Map<String,String> fields = new HashMap<>();
        fields.put("f1","v1");
        fields.put("f2","v2");
        jedis.hmset("hkey",fields);

        PrintUtil.printJson(jedis.hgetAll("hkey"));
        jedis.hdel("hkey","f1");
        PrintUtil.printJson(jedis.hgetAll("hkey"));

    }
}
