package org.open.boot.api.kuaidizs.dto;

/**
 * 快递助手：商品属性
 *
 * @author barnak
 */
public class KdzsMallSkuPropDTO {

    /**
     * 键值（必须）
     */
    private String key;

    /**
     * 键值（中文）（必须）
     */
    private String name;

    /**
     * 属性值（必须）
     */
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "KdzsMallSkuPropDTO{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
