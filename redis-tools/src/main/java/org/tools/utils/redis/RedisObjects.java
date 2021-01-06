package org.tools.utils.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author barnak
 */
public class RedisObjects {

    protected static final String CACHE_MAP = "CACHE_MAP:";

    protected <T> T getObjects(String value, Type type) {
        return JSONObject.parseObject(value,type);
    }

    protected <T> Set<T> getObjects(Set<String> values, Type type) {
        Set<T> sets = new HashSet<T>(values.size());
        for (String value : values) {
            T o = JSONObject.parseObject(value, type);
            sets.add(o);
        }
        return sets;
    }

    protected <T> List<T> getObjects(List<String> values, Type type) {
        List<T> list = new ArrayList<T>(values.size());
        for (String value : values) {
            T o = JSONObject.parseObject(value, type);
            list.add(o);
        }
        return list;
    }

    protected <T> String getString(T value) {
        if (value instanceof String) {
            return String.valueOf(value);
        }
        return JSON.toJSONString(value);
    }

    protected <T> String[] getString(T ... values) {
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
}
