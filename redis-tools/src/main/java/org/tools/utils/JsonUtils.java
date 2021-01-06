package org.tools.utils;

import com.alibaba.fastjson.util.ParameterizedTypeImpl;

import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * @author barnak
 */
public class JsonUtils {

    /**
     * 多级泛型转换构建
     *
     * @param types {@link Type}
     * @return {@link Type}
     */
    public static Type buildType(Type ... types) {
        ParameterizedTypeImpl beforeType = null;
        if (types == null || types.length < 1) {
            return null;
        }
        for (int i = types.length - 1; i > 0; i--) {
            beforeType = new ParameterizedTypeImpl(new Type[]{beforeType == null ? types[i] : beforeType}, null, types[i - 1]);
        }
        return beforeType;
    }

    /**
     * 多级泛型转换构建
     *
     * @param types {@link Type}
     * @return {@link Type}
     */
    public static Type buildTypes(Type value, Type ... types) {
        if (null == types || types.length < 1) {
            return buildType(value);
        }
        Type[] newTypes = Arrays.copyOf(types, types.length + 1);
        newTypes[types.length] = value;
        return buildType(newTypes);
    }
}
