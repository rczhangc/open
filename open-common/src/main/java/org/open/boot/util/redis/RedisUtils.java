package org.open.boot.util.redis;

import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis工具
 *
 * @author barnak
 */
public class RedisUtils {

    private static JedisPool jedisPool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(1024);
        config.setMaxIdle(200);
        config.setMaxWaitMillis(3000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        String host = "127.0.0.1";
        int port = 6379;
        String password = "test123";
        //redis如果设置了密码：
        jedisPool = new JedisPool(config, host, port, 10000, StringUtils.isBlank(password) ? null : password);
        Jedis resource = jedisPool.getResource();
        //redis未设置了密码：
        // jedisPool = new JedisPool(config, JRedisPoolConfig.REDIS_IP,
        //  JRedisPoolConfig.REDIS_PORT);
    }

    public static <K, V> RedisHash<K, V> getHash(String key, Class<K> keyClazz, Class<?> ... valuesClazz) {
        return new RedisHash<>(jedisPool.getResource(), key, keyClazz, valuesClazz);
    }

}
