package org.tools.utils.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import redis.clients.jedis.Jedis;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author barnak
 */
public abstract class RedisObjects extends RedisKey {

    /**
     * 常用数据类型Type
     */
    protected static final ParameterizedType BYTE_TYPE = new ParameterizedTypeImpl(new Type[]{Byte.class}, null, null);
    protected static final ParameterizedType SHORT_TYPE = new ParameterizedTypeImpl(new Type[]{Short.class}, null, null);
    protected static final ParameterizedType INT_TYPE = new ParameterizedTypeImpl(new Type[]{Integer.class}, null, null);
    protected static final ParameterizedType LONG_TYPE = new ParameterizedTypeImpl(new Type[]{Long.class}, null, null);
    protected static final ParameterizedType FLOAT_TYPE = new ParameterizedTypeImpl(new Type[]{Float.class}, null, null);
    protected static final ParameterizedType DOUBLE_TYPE = new ParameterizedTypeImpl(new Type[]{Double.class}, null, null);
    protected static final ParameterizedType DECIMAL_TYPE = new ParameterizedTypeImpl(new Type[]{BigDecimal.class}, null, null);
    protected static final ParameterizedType STRING_TYPE = new ParameterizedTypeImpl(new Type[]{String.class}, null, null);

    /**
     * Redis Hash缓存key标识头
     */
    protected static final String CACHE_MAP_HEAD = "CACHE_MAP:";

    /**
     * Redis缓存key
     */
    protected final String key;

    /**
     * Hash value类型
     * @see Type
     */
    protected final Type valueType;

    /**
     * Redis 缓存值是否是整数
     */
    protected final boolean valueIsInteger;

    /**
     * Redis 缓存值是否是浮点
     */
    protected final boolean valueIsFloat;

    public RedisObjects(Jedis redis, String key, Class<?> ... valuesClazz) {
        super(redis);
        this.key = key;
        this.valueType = buildType(valuesClazz);
        this.valueIsInteger = isInteger(valueType);
        this.valueIsFloat = isFloat(valueType);
    }

    /**
     * 字符串转换为指定类型
     *
     * @param value 值
     * @param type {@link Type}
     * @param <T> {@link T}
     * @return {@link T}
     */
    protected <T> T getObjects(String value, Type type) {
        return JSONObject.parseObject(value,type);
    }

    /**
     * 字符串列表转换为指定类型
     *
     * @param values {@link Set<String>}
     * @param type {@link Type}
     * @param <T> {@link T}
     * @return {@link Set<T>}
     */
    protected <T> Set<T> getObjects(Set<String> values, Type type) {
        if (STRING_TYPE.equals(type)) {
            @SuppressWarnings("unchecked")
            Set<T> set = (Set<T>) values;
            return set;
        }
        Set<T> sets = new HashSet<>(values.size());
        for (String value : values) {
            if (null == value) {
                continue;
            }
            T o = JSONObject.parseObject(value, type);
            sets.add(o);
        }
        return sets;
    }

    /**
     * 字符串列表转换为指定类型
     *
     * @param values {@link List<String>}
     * @param type {@link Type}
     * @param <T> {@link T}
     * @return {@link List<T>}
     */
    protected <T> List<T> getObjects(List<String> values, Type type) {
        if (STRING_TYPE.equals(type)) {
            @SuppressWarnings("unchecked")
            List<T> list = (List<T>) values;
            return list;
        }
        List<T> list = new ArrayList<>(values.size());
        for (String value : values) {
            if (null == value) {
                continue;
            }
            T o = JSONObject.parseObject(value, type);
            list.add(o);
        }
        return list;
    }

    /**
     * 将对象转换为字符串
     *
     * @param value 值
     * @return {@link String}
     */
    protected String getString(Object value) {
        if (value instanceof String) {
            return String.valueOf(value);
        }
        return JSON.toJSONString(value);
    }

    /**
     * 将对象列表转换为字符串
     * @param values 值列表
     * @return {@link String[]}
     */
    protected String[] getString(Object ... values) {
        String[] strings = new String[values.length];
        for (int i=0 ; i<values.length ; i++) {
            Object value = values[i];
            if (value instanceof String) {
                strings[i] = String.valueOf(value);
                continue;
            }
            strings[i] = JSON.toJSONString(value);
        }
        return strings;
    }

    /**
     * 多级泛型转换构建
     *
     * @param types {@link Type}
     * @return {@link Type}
     */
    protected static Type buildType(Type ... types) {
        ParameterizedTypeImpl beforeType = null;
        if (types == null || types.length < 1) {
            return null;
        }
        for (int i = types.length - 1; i >= 0; i--) {
            if (i == 0) {
                beforeType = new ParameterizedTypeImpl(new Type[]{beforeType == null ? types[i] : beforeType}, null, null);
                continue;
            }
            beforeType = new ParameterizedTypeImpl(new Type[]{beforeType == null ? types[i] : beforeType}, null, types[i - 1]);
        }
        return beforeType;
    }

    /**
     * 是否是整型
     *
     * @param type {@link Type}
     * @return true是 false否
     */
    protected boolean isInteger(Type type) {
        return LONG_TYPE.equals(type) || INT_TYPE.equals(type) || BYTE_TYPE.equals(type) || SHORT_TYPE.equals(type) ;
    }

    /**
     * 是否是浮点型
     *
     * @param type {@link Type}
     * @return true是 false否
     */
    protected boolean isFloat(Type type) {
        return DOUBLE_TYPE.equals(type) || DECIMAL_TYPE.equals(type) || FLOAT_TYPE.equals(type);
    }
}
