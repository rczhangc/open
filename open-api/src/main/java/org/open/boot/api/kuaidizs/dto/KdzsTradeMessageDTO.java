package org.open.boot.api.kuaidizs.dto;

/**
 * 快递助手：订单备注回传
 *
 * @author barnak
 */
public class KdzsTradeMessageDTO {

    /**
     * 订单ID（必须）
     */
    private String tid;

    /**
     * 订单备注（必须）
     */
    private String sellerMemo;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getSellerMemo() {
        return sellerMemo;
    }

    public void setSellerMemo(String sellerMemo) {
        this.sellerMemo = sellerMemo;
    }

    @Override
    public String toString() {
        return "KdzsTradeMessageDto{" +
                "tid='" + tid + '\'' +
                ", sellerMemo='" + sellerMemo + '\'' +
                '}';
    }
}
