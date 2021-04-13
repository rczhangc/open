package org.open.boot.util;

import org.apache.commons.lang.StringUtils;
import org.open.boot.constants.Constants;
import org.open.boot.constants.RegEx;

import java.math.BigDecimal;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 对象校验工具
 *
 * @author barnak
 * @date 2020/9/16 15:56
 */
@SuppressWarnings("all")
public class CheckUtil {

    // -----------------------------------基础校验----------------------------------------
    /**
     * 校验布尔值是否为true
     * 为true时抛出 {@link RuntimeException}
     * 相当于 if (expression) { throw new RuntimeException(message); }
     *
     * @param expression 布尔值
     * @param message 错误异常信息
     */
    public static void checkIf(boolean expression, String message) {
        if (expression) {
            throw new RuntimeException(message);
        }
    }

    /**
     * 校验参数是否为null
     * 为null时抛出 {@link RuntimeException}
     *
     * @param obj 需要校验的参数
     * @param message 错误异常信息
     */
    public static void checkNonNull(Object obj, String message) {
        if (null == obj) {
            throw new RuntimeException(message);
        }
    }
    // ----------------------------------------------------------------------------------

    // -----------------------------------字符串校验--------------------------------------
    /**
     * 校验是否为空或空字符串
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param string 待校验的参数 {@link String}
     */
    public static void checkEmpty(String string){
        checkEmpty(string,"参数");
    }

    /**
     * 校验是否为空或空字符串
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param string 待校验的参数 {@link String}
     * @param name 参数名
     */
    public static void checkEmpty(String string,String name){
        if (StringUtils.isEmpty(string)){
            throw new RuntimeException(name + "不能为空");
        }
    }

    /**
     * 校验 String 长度
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param string 待校验的参数 {@link String}
     * @param maxLength 最大长度
     */
    public static void checkLength(String string,int maxLength){
        checkLength(string,maxLength,0,"参数");
    }

    /**
     * 校验 String 长度
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param string 待校验的参数 {@link String}
     * @param maxLength 最大长度
     * @param name 参数名称
     */
    public static void checkLength(String string,int maxLength,String name){
        checkLength(string,maxLength,0,name);
    }

    /**
     * 校验 String 长度
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param string 待校验的参数 {@link String}
     * @param maxLength 最大长度
     * @param minLength 最小长度
     */
    public static void checkLength(String string,int maxLength,int minLength){
        checkLength(string,maxLength,minLength,"参数");
    }

    /**
     * 校验 String 长度
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param string 待校验的参数 {@link String}
     * @param maxLength 最大长度
     * @param minLength 最小长度
     * @param name 参数名称
     */
    public static void checkLength(String string,int maxLength,int minLength,String name){
        checkEmpty(string,name);
        int length = string.length();
        if (length < minLength){
            throw new RuntimeException(name +"最少需要输入"+ minLength +"个字符");
        }
        if (length > maxLength){
            throw new RuntimeException(name +"做多可输入"+ maxLength +"个字符");
        }
    }

    /**
     * 校验是否为整型数
     * 不是整型数时抛出 {@link RuntimeException} 异常
     *
     * @param string 待校验的参数 {@link String}
     * @param name 参数名
     */
    public static void checkInteger(String string,String name) {
        checkEmpty(string,name);
        Pattern pattern = Pattern.compile(RegEx.INTEGER);
        if (pattern.matcher(string).matches()) {
            return;
        }
        throw new RuntimeException(name +"需为整型数字");
    }
    // ----------------------------------------------------------------------------------

    // -----------------------------------整型数校验--------------------------------------
    /**
     * 校验 Integer 是否为空
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param integerValue 待校验的参数 {@link Integer}
     */
    public static void checkNull(Integer integerValue) {
        checkNull(integerValue,"参数");
    }

    /**
     * 校验 Integer 是否为空
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param integerValue 待校验的参数 {@link Integer}
     * @param name 参数名称
     */
    public static void checkNull(Integer integerValue,String name) {
        if (null == integerValue){
            throw new RuntimeException(name +"不能为空");
        }
    }

    /**
     * 校验 Integer 大小
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param integerValue 待校验的参数 {@link Integer}
     * @param min 最小值
     * @param name 参数名称
     */
    public static void checkSize(Integer integerValue,int min,String name) {
        checkSize(integerValue,min,Integer.MAX_VALUE,name);
    }

    /**
     * 校验 Integer 大小
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param integerValue 待校验的参数 {@link Integer}
     * @param min 最小值
     * @param max 最大值
     */
    public static void checkSize(Integer integerValue,int min,int max) {
        checkSize(integerValue,max,min,"参数");
    }

    /**
     * 校验 Integer 大小
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param integerValue 待校验的参数 {@link Integer}
     * @param min 最小值
     * @param max 最大值
     * @param name 参数名称
     */
    public static void checkSize(Integer integerValue,int min,int max,String name) {
        checkNull(integerValue,name);
        if (integerValue < min) {
            throw new RuntimeException(name +"不能小于"+ min);
        }
        if (integerValue > max) {
            throw new RuntimeException(name +"不能大于"+ max);
        }
    }


    /**
     * 校验 Long 是否为空
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param longValue 待校验的参数 {@link Long}
     */
    public static void checkNull(Long longValue) {
        checkNull(longValue,"参数");
    }

    /**
     * 校验 Long 是否为空
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param longValue 待校验的参数 {@link Long}
     * @param name 参数名称
     */
    public static void checkNull(Long longValue,String name) {
        if (null == longValue){
            throw new RuntimeException(name +"不能为空");
        }
    }

    /**
     * 校验 Long 大小
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param longValue 待校验的参数 {@link Long}
     * @param min 最小值
     * @param name 参数名称
     */
    public static void checkSize(Long longValue,long min,String name) {
        checkSize(longValue,Long.MAX_VALUE,min,name);
    }

    /**
     * 校验 Long 大小
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param longValue 待校验的参数 {@link Long}
     * @param min 最小值
     * @param max 最大值
     */
    public static void checkSize(Long longValue,long min,long max) {
        checkSize(longValue,max,min,"参数");
    }

    /**
     * 校验 Long 大小
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param longValue 待校验的参数 {@link Long}
     * @param min 最小值
     * @param max 最大值
     * @param name 参数名称
     */
    public static void checkSize(Long longValue,long min,long max,String name) {
        checkNull(longValue,name);
        if (longValue < min) {
            throw new RuntimeException(name +"不能小于"+ min);
        }
        if (longValue > max) {
            throw new RuntimeException(name +"不能大于"+ max);
        }
    }
    // ----------------------------------------------------------------------------------

    // -----------------------------------浮点数校验--------------------------------------
    /**
     * 校验 BigDecimal 小数位
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param bigDecimal 待校验的参数 {@link BigDecimal}
     * @param maxLength 最大长度
     */
    public static void checkDecimalPlacesLength(BigDecimal bigDecimal,int maxLength){
        checkDecimalPlacesLength(bigDecimal,maxLength,0,"参数");
    }

    /**
     * 校验 BigDecimal 小数位
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param bigDecimal 待校验的参数 {@link BigDecimal}
     * @param maxLength 最大长度
     * @param name 参数名称
     */
    public static void checkDecimalPlacesLength(BigDecimal bigDecimal,int maxLength,String name){
        checkDecimalPlacesLength(bigDecimal,maxLength,0,name);
    }

    /**
     * 校验 BigDecimal 小数位
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param bigDecimal 待校验的参数 {@link BigDecimal}
     * @param minLength 最小长度
     * @param maxLength 最大长度
     */
    public static void checkDecimalPlacesLength(BigDecimal bigDecimal,int maxLength,int minLength){
        checkDecimalPlacesLength(bigDecimal,maxLength,minLength,"参数");
    }

    /**
     * 校验 BigDecimal 小数位
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param bigDecimal 待校验的参数 {@link BigDecimal}
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @param name 参数名称
     */
    public static void checkDecimalPlacesLength(BigDecimal bigDecimal,int maxLength,int minLength,String name){
        if (null == bigDecimal) {
            throw new RuntimeException("请输入" + name);
        }
        int decimalPlacesLength = getDecimalPlacesLength(bigDecimal);
        if ( minLength > decimalPlacesLength) {
            throw new RuntimeException(name + "小数位长度不能小于" + minLength + "位");
        }
        if (maxLength < decimalPlacesLength) {
            throw new RuntimeException(name + "小数位长度不能超过" + maxLength + "位");
        }
    }

    /**
     * 校验 BigDecimal 整数位
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param bigDecimal 待校验的参数 {@link BigDecimal}
     * @param maxLength 最大长度
     */
    public static void checkIntegerBitLength(BigDecimal bigDecimal,int maxLength){
        checkIntegerBitLength(bigDecimal,maxLength,0,"参数");
    }

    /**
     * 校验 BigDecimal 整数位
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param bigDecimal 待校验的参数 {@link BigDecimal}
     * @param maxLength 最大长度
     * @param name 参数名称
     */
    public static void checkIntegerBitLength(BigDecimal bigDecimal,int maxLength,String name){
        checkIntegerBitLength(bigDecimal,maxLength,0,name);
    }

    /**
     * 校验 BigDecimal 整数位
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param bigDecimal 待校验的参数 {@link BigDecimal}
     * @param minLength 最小长度
     * @param maxLength 最大长度
     */
    public static void checkIntegerBitLength(BigDecimal bigDecimal,int maxLength,int minLength){
        checkIntegerBitLength(bigDecimal,maxLength,minLength,"参数");
    }

    /**
     * 校验 BigDecimal 整数位
     * 校验错误时抛出 {@link RuntimeException} 异常
     *
     * @param bigDecimal 待校验的参数 {@link BigDecimal}
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @param name 参数名称
     */
    public static void checkIntegerBitLength(BigDecimal bigDecimal,int maxLength,int minLength,String name){
        if (null == bigDecimal) {
            throw new RuntimeException("请输入" + name);
        }
        int integerBitLength = getIntegerBitLength(bigDecimal);
        if (minLength > integerBitLength) {
            throw new RuntimeException(name + "整数位长度不能小于" + minLength + "位");
        }
        if (maxLength < integerBitLength) {
            throw new RuntimeException(name + "整数位长度不能超过" + maxLength + "位");
        }
    }

    /**
     * 获取 BigDecimal 小数位长度
     *
     * @param bigDecimal 指定参数 {@link BigDecimal}
     * @return 小数位长度
     */
    public static int getDecimalPlacesLength(BigDecimal bigDecimal) {
        if (null == bigDecimal){
            return 0;
        }
        String string = bigDecimal.stripTrailingZeros().toPlainString();
        int index = string.indexOf(Constants.Symbol.EN_FULL_STOP);
        return Math.max( string.length() - index - 1 , 0);
    }

    /**
     * 获取 BigDecimal 整数位长度
     *
     * @param bigDecimal 指定参数 {@link BigDecimal}
     * @return 整数位长度
     */
    public static int getIntegerBitLength(BigDecimal bigDecimal) {
        if (null == bigDecimal){
            return 0;
        }
        String string = bigDecimal.stripTrailingZeros().toPlainString();
        int index = string.indexOf(Constants.Symbol.EN_FULL_STOP);
        return Math.max( index , 0 );
    }

    /**
     * 获取 BigDecimal 小数和整数总长度（小数点不在长度统计内）
     *
     * @param bigDecimal 指定参数 {@link BigDecimal}
     * @return 整体长度
     */
    public static int getLength(BigDecimal bigDecimal) {
        if (null == bigDecimal){
            return 0;
        }
        String string = bigDecimal.stripTrailingZeros().toPlainString();
        if (string.contains(Constants.Symbol.EN_FULL_STOP)){
            return string.length() - 1;
        }
        return string.length();
    }
    // ----------------------------------------------------------------------------------

    // -----------------------------------日期校验----------------------------------------

    /**
     * 校验日期范围
     *
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param name 名称
     */
    public static void checkRange(Date startTime,Date endTime,String name) {
        if (null == startTime) {
            throw new RuntimeException(name +"开始时间不能为空");
        }
        if (null == endTime) {
            throw new RuntimeException(name +"结束时间不能为空");
        }
        if (startTime.after(endTime)) {
            throw new RuntimeException(name +"开始时间不能大于"+ name +"结束时间");
        }
    }
    // ----------------------------------------------------------------------------------


}
