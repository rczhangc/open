package org.tools.utils;

import junit.framework.TestCase;
import org.junit.Test;
import org.tools.utils.redis.RedisHash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author barnak
 */
public class RedisUtilsTest extends TestCase {

    @Test
    public void test() {
        String cacheMapKey = "CACHE_MAP";
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


        Long aLong = hash.hSet(key3, value3);
        Long aLong1 = hash.hSetNx(key3, value3);
        Boolean aBoolean = hash.hExists(key1);
        List<Integer> integers = hash.hGet(key1);
        Long aLong2 = hash.hIncrBy(key1, 1);
        Double aDouble = hash.hIncrByFloat(key1, 1.0);
        List<List<Integer>> lists = hash.hmGet(key1, key2);
        String s = hash.hmSet(key1Map);

        hash.hKeys();
        hash.hLen();
        hash.hValS();
        hash.hDel();

//        hash.hSet()

//        Long key = hash.hSet("666", "555", "555");
//        Boolean aBoolean = hash.hExists("666", "555");
//        Boolean bBoolean = hash.hExists("666", "555");



    }

}