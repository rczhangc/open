package org.open.boot.api.kuaidizs.dto;

import java.util.List;

/**
 * 订单助手：订单删除,预申请单号
 *
 * @author barnak
 */
public class KdzsMallTradeTidListDTO extends KdzsObjectDTO {

    /**
     * 订单id列表
     * 订单删除（必须）
     * 预申请单号（必须）
     */
    private List<String> tidList;

    /**
     * 指定模版id
     * 订单删除（非必须）
     * 预申请单号（必须）
     */
    private String modeListShowId;

    public List<String> getTidList() {
        return tidList;
    }

    public void setTidList(List<String> tidList) {
        this.tidList = tidList;
    }

    public String getModeListShowId() {
        return modeListShowId;
    }

    public void setModeListShowId(String modeListShowId) {
        this.modeListShowId = modeListShowId;
    }

    @Override
    public String toString() {
        return "KdzsMallTradeTidListDTO{" +
                "tidList=" + tidList +
                ", modeListShowId='" + modeListShowId + '\'' +
                '}';
    }
}
