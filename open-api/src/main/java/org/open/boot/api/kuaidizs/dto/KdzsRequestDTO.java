package org.open.boot.api.kuaidizs.dto;

import java.util.Objects;

/**
 * @author barnak
 */
public class KdzsRequestDTO {

    /**
     * 应用分配APPKey（必须）
     */
    private String appKey;

    /**
     * 方法名（必须）
     */
    private String method;

    /**
     * 应用下面的店铺ID，多店铺模式下必填
     */
    private Long mallUserId;

    /**
     * 时间戳（必须）
     */
    private Long timestamp;

    /**
     * 返回格式，当前仅支持json
     */
    private String format;

    /**
     * api版本号，当前1.0（必须）
     */
    private String v;

    /**
     * 签名的摘要算法，可选值为：md5，默认值md5
     */
    private String signMethod;

    /**
     * 加密后的密文，API输入参数签名结果（必须）
     */
    private String sign;

    /**
     * 应用参数的json字符串（必须）
     */
    private String appParam;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Long getMallUserId() {
        return mallUserId;
    }

    public void setMallUserId(Long mallUserId) {
        this.mallUserId = mallUserId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getSignMethod() {
        return signMethod;
    }

    public void setSignMethod(String signMethod) {
        this.signMethod = signMethod;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAppParam() {
        return appParam;
    }

    public void setAppParam(String appParam) {
        this.appParam = appParam;
    }

    @Override
    public String toString() {
        return "KdzsPublicReqDTO{}";
    }

    public static void main(String[] args) {
//        String param = "key\tString\t是\tcolor\t键值\n" +
//                "name\tString\t是\t颜色\t键值（中文）\n" +
//                "value\tString\t是\t红色\t属性值";
//        method1(param);
        String param = "tidList\tList< String >\t是\t订单id列表";
        method2(param);

    }

    public static void method1(String param) {
//        param = "key\tString\t是\tcolor\t键值\n" +
//                "name\tString\t是\t颜色\t键值（中文）\n" +
//                "value\tString\t是\t红色\t属性值";

        String[] line = param.split("\n");

        for (String str : line) {
            String[] split = str.split("\t");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\t/**\n\t * ").append(split[4]);
            if (Objects.equals(split[2],"是")) {
                stringBuilder.append("（必须）");
            }
            stringBuilder.append("\n\t */\n\tprivate ").append(split[1]).append(" ").append(split[0]).append(";\n");
            System.out.println(stringBuilder.toString());
        }
    }

    public static void method2(String param) {
//        param = "invoice\tString\t否\t发票内容\n" +
//                "invoiceHead\tString\t否\t发票抬头\n" +
//                "invoiceRecipientAddress\tString\t否\t发票寄件地址\n" +
//                "invoiceRecipientHandPhone\tString\t否\t发票手机号\n" +
//                "invoiceRecipientPhone\tString\t否\t发票电话\n" +
//                "invoiceType\tString\t否\t发票类型，增值还是普通（01增值 02普通 04 电子发票）";

        String[] line = param.split("\n");

        for (String str : line) {
            String[] split = str.split("\t");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\t/**\n\t * ").append(split[3]);
            if (Objects.equals(split[2],"是")) {
                stringBuilder.append("（必须）");
            }
            stringBuilder.append("\n\t */\n\tprivate ").append(split[1]).append(" ").append(split[0]).append(";\n");
            System.out.println(stringBuilder.toString());
        }
    }
}
