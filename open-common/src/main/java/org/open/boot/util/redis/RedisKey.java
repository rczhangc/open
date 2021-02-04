package org.open.boot.util.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author barnak
 */
public class RedisKey {

    /**
     * Redis链接对象
     * @see Jedis
     */
    private final Jedis redis;

    public RedisKey(Jedis redis) {
        this.redis = redis;
    }

    /**
     * 该命令用于在 key 存在时删除 key
     * Redis DEL 命令用于删除已存在的键。不存在的 key 会被忽略
     * version >= 1.0.0
     *
     * @param keys RedisKey数组
     * @return 被删除 key 的数量
     */
    public Long del(String... keys) {
        Jedis redis = getRedis();
        Long count = redis.del(keys);
        release(redis);
        return count;
    }

    /**
     * 序列化给定 key ，并返回被序列化的值
     * Redis DUMP 命令用于序列化给定 key ，并返回被序列化的值
     * version >= 2.6.0
     *
     * @param key RedisKey
     * @return 如果 key 不存在，那么返回 nil 。 否则，返回序列化之后的值
     */
    public byte[] dump(String key) {
        Jedis redis = getRedis();
        byte[] dump = redis.dump(key);
        release(redis);
        return dump;
    }

    /**
     * 检查给定 key 是否存在
     * Redis EXISTS 命令用于检查给定 key 是否存在
     * version >= 1.0.0
     *
     * @param key RedisKey
     * @return 若 key 存在返回 1 ，否则返回 0
     */
    public boolean exists(String key) {
        Jedis redis = getRedis();
        Boolean exists = redis.exists(key);
        release(redis);
        return exists;
    }

    /**
     * 为给定 key 设置过期时间，以秒计
     * Redis Expire 命令用于设置 key 的过期时间，key 过期后将不再可用。单位以秒计
     * version >= 1.0.0
     *
     * @param key RedisKey
     * @param seconds 秒
     * @author 设置成功返回 1 。 当 key 不存在或者不能为 key 设置过期时间时(比如在低于 2.1.3 版本的 Redis 中你尝试更新 key 的过期时间)返回 0
     */
    public Long expire(String key, int seconds) {
        Jedis redis = getRedis();
        Long expire = redis.expire(key, seconds);
        release(redis);
        return expire;
    }

    /**
     * EXPIREAT 的作用和 EXPIRE 类似，都用于为 key 设置过期时间。 不同在于 EXPIREAT 命令接受的时间参数是 UNIX 时间戳(unix timestamp)
     * Redis Expireat 命令用于以 UNIX 时间戳(unix timestamp)格式设置 key 的过期时间。key 过期后将不再可用
     * version >= 1.0.0
     *
     * @param key RedisKey
     * @param unixTime unix时间戳
     * @return 设置成功返回 1 。 当 key 不存在或者不能为 key 设置过期时间时(比如在低于 2.1.3 版本的 Redis 中你尝试更新 key 的过期时间)返回 0
     */
    public Long expireAt(String key, long unixTime) {
        Jedis redis = getRedis();
        Long aLong = redis.expireAt(key, unixTime);
        release(redis);
        return aLong;
    }

    /**
     * 设置 key 的过期时间以毫秒计
     * Redis PEXPIRE 命令和 EXPIRE 命令的作用类似，但是它以毫秒为单位设置 key 的生存时间，而不像 EXPIRE 命令那样，以秒为单位
     * version >= 2.6.0
     *
     * @param key RedisKey
     * @param milliseconds 毫秒
     * @return 设置成功，返回 1 key 不存在或设置失败，返回 0
     */
    public Long pExpire(String key, long milliseconds) {
        Jedis redis = getRedis();
        Long pExpire = redis.pexpire(key, milliseconds);
        release(redis);
        return pExpire;
    }

    /**
     * 设置 key 过期时间的时间戳(unix timestamp) 以毫秒计
     * Redis PEXPIREAT 命令用于设置 key 的过期时间，以毫秒计。key 过期后将不再可用
     * version >= 1.0.0
     *
     * @param key RedisKey
     * @param millisecondsTimestamp 毫秒时间戳
     * @return 设置成功返回 1 。 当 key 不存在或者不能为 key 设置过期时间时(比如在低于 2.1.3 版本的 Redis 中你尝试更新 key 的过期时间)返回 0
     */
    public Long pExpireAt(String key, long millisecondsTimestamp) {
        Jedis redis = getRedis();
        Long aLong = redis.pexpireAt(key, millisecondsTimestamp);
        release(redis);
        return aLong;
    }

    /**
     * 查找所有符合给定模式( pattern)的 key
     * Redis Keys 命令用于查找所有符合给定模式 pattern 的 key
     * version >= 1.0.0
     *
     * @param pattern 匹配规则
     * @return 符合给定模式的 key 列表 (Array)
     */
    public Set<String> keys(String pattern) {
        Jedis redis = getRedis();
        Set<String> keys = redis.keys(pattern);
        release(redis);
        return keys;
    }

    /**
     * 将当前数据库的 key 移动到给定的数据库 db 当中
     * Redis MOVE 命令用于将当前数据库的 key 移动到给定的数据库 db 当中
     * version >= 1.0.0
     *
     * @param key RedisKey
     * @param dbIndex 指定库索引
     * @return 移动成功返回 1 ，失败则返回 0
     */
    public Long move(String key, int dbIndex) {
        Jedis redis = getRedis();
        Long move = redis.move(key, dbIndex);
        release(redis);
        return move;
    }

    /**
     * 移除 key 的过期时间，key 将持久保持
     * Redis PERSIST 命令用于移除给定 key 的过期时间，使得 key 永不过期
     * version >= 2.2.0
     *
     * @param key RedisKey
     * @return 当过期时间移除成功时，返回 1 。 如果 key 不存在或 key 没有设置过期时间，返回 0
     */
    public Long persist(String key) {
        Jedis redis = getRedis();
        Long persist = redis.persist(key);
        release(redis);
        return persist;
    }

    /**
     * 以毫秒为单位返回 key 的剩余的过期时间
     * Redis Pttl 命令以毫秒为单位返回 key 的剩余过期时间
     * version >= 2.6.0
     *
     * @param key RedisKey
     * @return 当 key 不存在时，返回 -2 。 当 key 存在但没有设置剩余生存时间时，返回 -1 。 否则，以毫秒为单位，返回 key 的剩余生存时间
     * 在 Redis 2.8 以前，当 key 不存在，或者 key 没有设置剩余生存时间时，命令都返回 -1
     */
    public Long pTtl(String key) {
        Jedis redis = getRedis();
        Long pTtl = redis.pttl(key);
        release(redis);
        return pTtl;
    }

    /**
     * 以秒为单位，返回给定 key 的剩余生存时间(TTL, time to live)
     * Redis TTL 命令以秒为单位返回 key 的剩余过期时间
     * version >= 1.0.0
     *
     * @param key RedisKey
     * @return 当 key 不存在时，返回 -2 。 当 key 存在但没有设置剩余生存时间时，返回 -1 。 否则，以秒为单位，返回 key 的剩余生存时间
     * 在 Redis 2.8 以前，当 key 不存在，或者 key 没有设置剩余生存时间时，命令都返回 -1
     */
    public Long ttl(String key) {
        Jedis redis = getRedis();
        Long ttl = redis.ttl(key);
        release(redis);
        return ttl;
    }

    /**
     * 从当前数据库中随机返回一个 key
     * Redis RANDOMKEY 命令从当前数据库中随机返回一个 key
     * version >= 1.0.0
     *
     * @return 当数据库不为空时，返回一个 key 。 当数据库为空时，返回 nil （windows 系统返回 null）
     */
    public String randomKey() {
        Jedis redis = getRedis();
        String randomKey = redis.randomKey();
        release(redis);
        return randomKey;
    }

    /**
     * 修改 key 的名称
     * Redis Rename 命令用于修改 key 的名称
     * version >= 1.0.0
     *
     * @param oldKey 旧 RedisKey
     * @param newKey 新 RedisKey
     * @return 改名成功时提示 OK ，失败时候返回一个错误
     * 当 OLD_KEY_NAME 和 NEW_KEY_NAME 相同，或者 OLD_KEY_NAME 不存在时，返回一个错误
     * 当 NEW_KEY_NAME 已经存在时， RENAME 命令将覆盖旧值
     */
    public String rename(String oldKey, String newKey) {
        Jedis redis = getRedis();
        String rename = redis.rename(oldKey, newKey);
        release(redis);
        return rename;
    }

    /**
     * 仅当 newkey 不存在时，将 key 改名为 newkey
     * Redis Renamenx 命令用于在新的 key 不存在时修改 key 的名称
     * version >= 1.0.0
     *
     * @param oldKey 旧 RedisKey
     * @param newKey 新 RedisKey
     * @return 修改成功时，返回 1 。 如果 NEW_KEY_NAME 已经存在，返回 0
     */
    public Long renameNx(String oldKey, String newKey) {
        Jedis redis = getRedis();
        Long renameNx = redis.renamenx(oldKey, newKey);
        release(redis);
        return renameNx;
    }

    /**
     * 返回 key 所储存的值的类型
     * Redis Type 命令用于返回 key 所储存的值的类型
     * version >= 1.0.0
     *
     * @param key RedisKey
     * @return 返回 key 的数据类型，数据类型有：
     * none (key不存在)
     * string (字符串)
     * list (列表)
     * set (集合)
     * zset (有序集)
     * hash (哈希表)
     */
    public String type(String key) {
        Jedis redis = getRedis();
        String type = redis.type(key);
        release(redis);
        return type;
    }

    /**
     * 获取Redis链接对象
     *
     * @return {@link Jedis}
     */
    protected Jedis getRedis() {
        return redis;
    }

    /**
     * 释放Redis链接对象
     *
     * @param redis {@link Jedis}
     */
    protected void release(Jedis redis) {
        redis.close();
    }
}
