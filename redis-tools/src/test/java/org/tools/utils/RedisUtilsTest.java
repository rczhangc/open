package org.tools.utils;

import junit.framework.TestCase;
import org.junit.Test;
import org.tools.utils.redis.RedisHash;

/**
 * @author barnak
 */
public class RedisUtilsTest extends TestCase {

    @Test
    public void test() {
        RedisHash hash = RedisUtils.getHash();
        Long key = hash.hSet("666", "555", "555");
        Boolean aBoolean = hash.hExists("666", "555");
        Boolean bBoolean = hash.hExists("666", "555");

    }

}