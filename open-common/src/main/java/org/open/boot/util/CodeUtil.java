package org.open.boot.util;

import org.open.boot.constants.CodeRegEx;

import java.util.Random;

/**
 * @author barnak
 */
public class CodeUtil {

    private static char[] CODE_SEQUENCE = { '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };


    public static String getGoodsCode() {
        return CodeRegEx.GOODS_CODE_HEAD + System.currentTimeMillis() + getRandomCode(5);
    }

    public static String getGoodsSkuCode() {
        return CodeRegEx.GOODS_SKU_HEAD + System.currentTimeMillis() + getRandomCode(5);
    }

    public static String getGoodsSkuValueCode() {
        return CodeRegEx.GOODS_SKU_VALUE_HEAD + System.currentTimeMillis() + getRandomCode(5);
    }

    public static String getGoodsSkuDetailCode() {
        return CodeRegEx.GOODS_SKU_DETAIL_HEAD + System.currentTimeMillis() + getRandomCode(5);
    }

    public static String getMenusCode() {
        return CodeRegEx.MENUS_CODE_HEAD + System.currentTimeMillis() + getRandomCode(5);
    }

    public static String getRolesCode() {
        return CodeRegEx.ROLES_CODE_HEAD + System.currentTimeMillis() + getRandomCode(5);
    }

    /**
     * 获取随机字母长度
     *
     * @param length
     * @return
     */
    public static String getRandomCode(int length) {
        StringBuffer code = new StringBuffer();
        for (int i = 0; i < length; i++) {
            code.append(CODE_SEQUENCE[new Random().nextInt(CODE_SEQUENCE.length)]);
        }
        return code.toString();
    }
}
