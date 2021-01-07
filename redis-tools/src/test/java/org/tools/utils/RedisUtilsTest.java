package org.tools.utils;

import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;
import org.junit.Test;
import org.tools.utils.redis.RedisHash;

import java.util.*;

/**
 * @author barnak
 */
public class RedisUtilsTest extends TestCase {

    @Test
    public void test() {
        String cacheMapKey = "CACHE_MAP";
        RedisHash<String, Long> integerMap = RedisUtils.getHash("INTEGER_MAP", String.class, Long.class);
        RedisHash<String, List<Integer>> hash = RedisUtils.getHash(cacheMapKey,String.class, List.class, Integer.class);
        String key1 = "HAHA";
        String key2 = "HEHE";
        String key3 = "HEIHEI";
        List<Integer> value1 = Arrays.asList(1,2);
        List<Integer> value2 = Arrays.asList(3,4);
        List<Integer> value3 = Arrays.asList(5,6);

        Map<String,List<Integer>> key1Map = new HashMap<>();
        key1Map.put(key1,value1);
        key1Map.put(key2,value2);

        Long aLong3 = hash.hDel(key1, key2, key3);

        Long aLong = hash.hSet(key3, value3);
        Long aLong1 = hash.hSetNx(key3, value3);
        Boolean aBoolean = hash.hExists(key1);
        List<Integer> integers = hash.hGet(key1);

        List<List<Integer>> lists = hash.hmGet(key1, key2);
        String s = hash.hmSet(key1Map);

        Set<String> strings = hash.hKeys();
        Long aLong4 = hash.hLen();
        List<List<Integer>> lists1 = hash.hValS();


        Long aLong2 = hash.hIncrBy(key1, 1);
        Double aDouble = hash.hIncrByFloat(key1, 1.0);

        Long aLong5 = hash.hDel(key1, key2, key3);

    }

    public static void main(String[] args) {

        String string = JSONObject.parseObject("String", String.class);
    }

}