package org.open.boot.api.kuaidizs.dto;

import java.util.List;

/**
 * 订单助手：订单发货对象
 *
 * @author barnak
 */
public class KdzsMallTradeSendDTO extends KdzsObjectDTO {

    /**
     * 订单id，全局唯一（必须）
     */
    private String tid;

    /**
     * 子订单id，全局唯一
     */
    private List< String > oids;

    /**
     * 快递公司code，详见快递公司对应表（必须）
     */
    private String companyCode;

    /**
     * 运单号（必须）
     */
    private String waybillNo;

    /**
     * 是否拆单，拆单则oids为必传（必须）
     */
    private String split;

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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    public String getSplit() {
        return split;
    }

    public void setSplit(String split) {
        this.split = split;
    }

    @Override
    public String toString() {
        return "KdzsMallTradeSendDTO{" +
                "tid='" + tid + '\'' +
                ", oids=" + oids +
                ", companyCode='" + companyCode + '\'' +
                ", waybillNo='" + waybillNo + '\'' +
                ", split='" + split + '\'' +
                '}';
    }
}
