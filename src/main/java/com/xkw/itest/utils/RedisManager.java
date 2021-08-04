package com.xkw.itest.utils;

import redis.clients.jedis.Jedis;

import java.io.Serializable;

/**
 * @author : chenghao
 * create at:  2021/8/4  11:55 上午
 * @description:
 */
public class RedisManager {

    private Jedis jedis = new Jedis("localhost");

    public String set(String key,Object object) {
        return jedis.set(key.getBytes(), SerializeUtil.serialize(object));
    }

    public Object get(String key) {
        byte[] value = jedis.get(key.getBytes());
        return SerializeUtil.unSerialize(value);
    }

    public boolean del(String key) {
        return jedis.del(key.getBytes()) > 0;
    }
}

