package org.open.boot.util.redis;

import redis.clients.jedis.Jedis;

/**
 * @author barnak
 */
public class RedisSubscribe {

    /**
     * Redis链接对象
     * @see Jedis
     */
    private final Jedis redis;

    public RedisSubscribe(Jedis redis) {
        this.redis = redis;
    }


    public void test() {

    }
}
