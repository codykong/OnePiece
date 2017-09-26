package com.xten.op.redis;

import com.xten.op.common.util.PrintUtil;
import redis.clients.jedis.Jedis;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/6/16
 * Time: 上午11:49
 */
public class ListCase {

    public static void main(String[] args) {

        Jedis jedis = JedisUtil.build();

//        jedis.lpush("lkey","a","b","c");
        PrintUtil.printJson(jedis.lrange("lkey",0,-1));
        PrintUtil.printJson(jedis.rpoplpush("lkey","lkey2"));
        jedis.del("lkey");
//        jedis.lrem("lkey",0,"b");
        PrintUtil.printJson(jedis.lrange("lkey",0,-1));

    }
}
