package org.open.boot.dao.goods.business;

/**
 * @author barnak
 */
public class GoodsDetailSkuValueBO {

    /**
     * 规格编码
     */
    private String skuCode;

    /**
     * 规格名称
     */
    private String skuName;

    /**
     * 规格值
     */
    private String skuValue;

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuValue() {
        return skuValue;
    }

    public void setSkuValue(String skuValue) {
        this.skuValue = skuValue;
    }

    @Override
    public String toString() {
        return "GoodsDetailSkuValueBO{}";
    }
}
