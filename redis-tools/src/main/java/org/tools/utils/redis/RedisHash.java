package org.tools.utils.redis;

import redis.clients.jedis.Jedis;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author barnak
 */
public class RedisHash<K,V> extends RedisObjects {

    private final Jedis redis;

    private final String key;

    private final Type keyType;

    private final Type valueType;

    public RedisHash(Jedis redis, String key, Type keyType, Type valueType) {
        this.redis = redis;
        this.key = CACHE_MAP + key;
        this.keyType = keyType;
        this.valueType = valueType;
    }

    /**
     * 删除一个或多个哈希表字段
     * Redis Hdel 命令用于删除哈希表 key 中的一个或多个指定字段，不存在的字段将被忽略
     * version >= 2.0.0
     *
     * @param field 值
     * @return 被成功删除字段的数量，不包括被忽略的字段
     */
    public Long hDel(K ... field) {
        Long hDel = redis.hdel(key, getString(field));
        redis.close();
        return hDel;
    }

    /**
     * 查看哈希表 key 中，指定的字段是否存在
     * Redis Hexists 命令用于查看哈希表的指定字段是否存在
     * version >= 2.0.0
     *
     * @param field 值
     * @return 如果哈希表含有给定字段，返回 1 。 如果哈希表不含有给定字段，或 key 不存在，返回 0
     */
    public Boolean hExists(K field){
        Boolean hExists = redis.hexists(key, getString(field));
        redis.close();
        return hExists;
    }

    /**
     * 获取存储在哈希表中指定字段的值
     * Redis Hget 命令用于返回哈希表中指定字段的值
     * version >= 2.0.0
     *
     * @param field 值
     * @return 返回给定字段的值。如果给定的字段或 key 不存在时，返回 nil
     */
    public V hGet(K field) {
        String hGet = redis.hget(key, getString(field));
        redis.close();
        return getObjects(hGet,valueType);
    }

    /**
     * 为哈希表 key 中的指定字段的整数值加上增量 increment
     * Redis Hincrby 命令用于为哈希表中的字段值加上指定增量值
     * 增量也可以为负数，相当于对指定字段进行减法操作
     * 如果哈希表的 key 不存在，一个新的哈希表被创建并执行 HINCRBY 命令
     * 如果指定的字段不存在，那么在执行命令前，字段的值被初始化为 0
     * 对一个储存字符串值的字段执行 HINCRBY 命令将造成一个错误
     * 本操作的值被限制在 64 位(bit)有符号数字表示之内
     * version >= 2.0.0
     *
     * @param field 值
     * @param increment 增量
     * @return 执行 HINCRBY 命令之后，哈希表中字段的值
     */
    public Long hIncrBy(K field, long increment) {
        Long aLong = redis.hincrBy(key, getString(field), increment);
        redis.close();
        return aLong;
    }

    /**
     * 为哈希表 key 中的指定字段的浮点数值加上增量 increment
     * Redis Hincrbyfloat 命令用于为哈希表中的字段值加上指定浮点数增量值
     * 如果指定的字段不存在，那么在执行命令前，字段的值被初始化为 0
     * version >= 2.6.0
     *
     * @param field 值
     * @param increment 增量
     * @return 执行 Hincrbyfloat 命令之后，哈希表中字段的值
     */
    public Double hIncrByFloat(K field, double increment) {
        Double aDouble = redis.hincrByFloat(key, getString(field), increment);
        redis.close();
        return aDouble;
    }

    /**
     * 获取所有哈希表中的字段
     * Redis Hkeys 命令用于获取哈希表中的所有域（field）
     * version >= 2.0.0
     *
     * @return 包含哈希表中所有域（field）列表。 当 key 不存在时，返回一个空列表
     */
    public Set<K> hKeys() {
        Set<String> hKeys = redis.hkeys(key);
        redis.close();
        return getObjects(hKeys, keyType);
    }

    /**
     * 获取哈希表中字段的数量
     * Redis Hlen 命令用于获取哈希表中字段的数量
     * version >= 2.0.0
     *
     * @return 哈希表中字段的数量。 当 key 不存在时，返回 0
     */
    public Long hLen() {
        Long hLen = redis.hlen(key);
        redis.close();
        return hLen;
    }

    /**
     * 获取所有给定字段的值
     * Redis Hmget 命令用于返回哈希表中，一个或多个给定字段的值
     * 如果指定的字段不存在于哈希表，那么返回一个 nil 值
     * version >= 2.0.0
     *
     * @param field 值
     * @return 一个包含多个给定字段关联值的表，表值的排列顺序和指定字段的请求顺序一样
     */
    public List<V> hmGet(String ... field) {
        List<String> hmGet = redis.hmget(key, field);
        redis.close();
        return getObjects(hmGet, valueType);
    }

    /**
     * 同时将多个 field-value (域-值)对设置到哈希表 key 中
     * Redis Hmset 命令用于同时将多个 field-value (字段-值)对设置到哈希表中
     * 此命令会覆盖哈希表中已存在的字段
     * 如果哈希表不存在，会创建一个空哈希表，并执行 HMSET 操作
     * version >= 2.0.0
     *
     * @param map {@link Map}
     * @return 如果命令执行成功，返回 OK
     */
    public String hmSet(Map<K, V> map) {
        String hmSet = redis.hmset(key, getMap(map));
        redis.close();
        return hmSet;
    }

    /**
     * 将哈希表 key 中的字段 field 的值设为 value
     * Redis Hset 命令用于为哈希表中的字段赋值
     * 如果哈希表不存在，一个新的哈希表被创建并进行 HSET 操作
     * 如果字段已经存在于哈希表中，旧值将被覆盖
     * version >= 2.0.0
     *
     * @param field
     * @param value
     * @return 如果字段是哈希表中的一个新建字段，并且值设置成功，返回 1 。 如果哈希表中域字段已经存在且旧值已被新值覆盖，返回 0
     */
    public Long hSet(K field, V value) {
        Long hSet = redis.hset(key, getString(field), getString(value));
        redis.close();
        return hSet;
    }

    /**
     * 只有在字段 field 不存在时，设置哈希表字段的值
     * Redis Hsetnx 命令用于为哈希表中不存在的的字段赋值
     * 如果哈希表不存在，一个新的哈希表被创建并进行 HSET 操作
     * 如果字段已经存在于哈希表中，操作无效
     * 如果 key 不存在，一个新哈希表被创建并执行 HSETNX 命令
     * version >= 2.0.0
     *
     * @param field
     * @param value
     * @return 设置成功，返回 1 。 如果给定字段已经存在且没有操作被执行，返回 0
     */
    public Long hSetNx(K field, V value) {
        Long hSetNx = redis.hsetnx(key, getString(field), getString(value));
        redis.close();
        return hSetNx;
    }

    /**
     * 获取哈希表中所有值
     * Redis Hvals 命令返回哈希表所有域(field)的值
     * version >= 2.0.0
     *
     * @return 一个包含哈希表中所有域(field)值的列表。 当 key 不存在时，返回一个空表
     */
    public List<V> hValS() {
        List<String> hValS = redis.hvals(key);
        redis.close();
        return getObjects(hValS,valueType);
    }

    private Map<String, String> getMap(Map<K,V> map) {
        Map<String, String> hash = new HashMap<>(map.size());
        for (Map.Entry<K,V> entry : map.entrySet()) {
            hash.put(getString(entry.getKey()), getString(entry.getValue()));
        }
        return hash;
    }
}
