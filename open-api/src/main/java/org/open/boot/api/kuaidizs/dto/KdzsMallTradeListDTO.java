package org.open.boot.api.kuaidizs.dto;

import java.util.List;

/**
 * 快递助手：订单列表对象
 *
 * @author barnak
 */
public class KdzsMallTradeListDTO extends KdzsObjectDTO {

    /**
     * 订单列表（必须）
     */
    List<KdzsMallTradeDTO> mallTradeList;

    public List<KdzsMallTradeDTO> getMallTradeList() {
        return mallTradeList;
    }

    public void setMallTradeList(List<KdzsMallTradeDTO> mallTradeList) {
        this.mallTradeList = mallTradeList;
    }

    @Override
    public String toString() {
        return "KdzsMallTradeListDTO{" +
                "mallTradeList=" + mallTradeList +
                '}';
    }
}
