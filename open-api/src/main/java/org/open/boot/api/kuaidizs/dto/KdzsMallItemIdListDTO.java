package org.open.boot.api.kuaidizs.dto;

import java.util.List;

/**
 * 快递助手：商品Id列表对象
 *
 * @author barnak
 */
public class KdzsMallItemIdListDTO extends KdzsObjectDTO {

    /**
     * 商品Id列表（必须）
     */
    private List<String> itemIdList;

    public List<String> getItemIdList() {
        return itemIdList;
    }

    public void setItemIdList(List<String> itemIdList) {
        this.itemIdList = itemIdList;
    }

    @Override
    public String toString() {
        return "KdzsMallItemIdListDTO{" +
                "itemIdList=" + itemIdList +
                '}';
    }
}
