package org.open.boot.api.kuaidizs.dto;

import java.util.List;

/**
 * 快递助手：商品列表对象
 *
 * @author barnak
 */
public class KdzsMallItemListDTO extends KdzsObjectDTO {

    /**
     * 商品列表（必须）
     */
    private List<KdzsMallItemDTO> itemList;

    public List<KdzsMallItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(List<KdzsMallItemDTO> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "KdzsMallItemListDTO{" +
                "itemList=" + itemList +
                '}';
    }
}
