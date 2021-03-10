package org.open.boot.api.kuaidizs.dto;

import java.util.List;

/**
 * 订单助手：订单退款对象
 *
 * @author barnak
 */
public class KdzsMallTradeRefundDTO extends KdzsObjectDTO {

    /**
     * 订单id，全局唯一（必须）
     */
    private String tid;

    /**
     * 子订单id，全局唯一
     */
    private List<String> oids;

    /**
     * 退款状态（必须）
     */
    private String refundStatus;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public List<String> getOids() {
        return oids;
    }

    public void setOids(List<String> oids) {
        this.oids = oids;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    @Override
    public String toString() {
        return "KdzsMallTradeRefundDTO{" +
                "tid='" + tid + '\'' +
                ", oids=" + oids +
                ", refundStatus='" + refundStatus + '\'' +
                '}';
    }
}
