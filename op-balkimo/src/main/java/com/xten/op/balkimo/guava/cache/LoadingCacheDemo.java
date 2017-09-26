package com.xten.op.balkimo.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/1/4
 * Time: 下午5:20
 */
public class LoadingCacheDemo {
    public static void main(String[] args) throws ExecutionException {
        LoadingCache<Integer,Integer> cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(10, TimeUnit.MINUTES)
                .build(new CacheLoader<Integer, Integer>() {
                    @Override
                    public Integer load(Integer key) throws Exception {
                        System.out.println("load key:"+key);
                        return new Random().nextInt(100) ;
                    }

                });

        for (int i =0;i<100;i++){
            int key =new Random().nextInt(10);
            cache.get(key);

        }

    }
}
