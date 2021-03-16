package org.open.boot.api.kuaidizs.dto;

/**
 * 快递助手：模版列表对象
 *
 * @author barnak
 */
public class KdzsModeListShowDTO {

    /**
     * 快递公司码（必须）
     */
    private String excode;

    /**
     * 快递公司名称（必须）
     */
    private String excodeName;

    /**
     * 是否默认模板 0非默认 1默认（必须）
     */
    private Integer isDef;

    /**
     * 菜鸟模板id（必须）
     */
    private String cainiaoTemplateId;

    /**
     * 1普通面单;2网点面单;3云栈电子面单（必须）
     */
    private Integer kddType;

    /**
     * 快递公司id（必须）
     */
    private String logisticsCompanyId;

    /**
     * 子账号id（必须）
     */
    private Long subTaobaoId;

    /**
     * 是否可用（必须）
     */
    private Boolean enableStatus;

    /**
     * 快递单或发货单 kdd/fhd（必须）
     */
    private String modeId;

    /**
     * 模版ID,预申请单号必传（必须）
     */
    private Integer modeListshowId;

    public String getExcode() {
        return excode;
    }

    public void setExcode(String excode) {
        this.excode = excode;
    }

    public String getExcodeName() {
        return excodeName;
    }

    public void setExcodeName(String excodeName) {
        this.excodeName = excodeName;
    }

    public Integer getIsDef() {
        return isDef;
    }

    public void setIsDef(Integer isDef) {
        this.isDef = isDef;
    }

    public String getCainiaoTemplateId() {
        return cainiaoTemplateId;
    }

    public void setCainiaoTemplateId(String cainiaoTemplateId) {
        this.cainiaoTemplateId = cainiaoTemplateId;
    }

    public Integer getKddType() {
        return kddType;
    }

    public void setKddType(Integer kddType) {
        this.kddType = kddType;
    }

    public String getLogisticsCompanyId() {
        return logisticsCompanyId;
    }

    public void setLogisticsCompanyId(String logisticsCompanyId) {
        this.logisticsCompanyId = logisticsCompanyId;
    }

    public Long getSubTaobaoId() {
        return subTaobaoId;
    }

    public void setSubTaobaoId(Long subTaobaoId) {
        this.subTaobaoId = subTaobaoId;
    }

    public Boolean getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Boolean enableStatus) {
        this.enableStatus = enableStatus;
    }

    public String getModeId() {
        return modeId;
    }

    public void setModeId(String modeId) {
        this.modeId = modeId;
    }

    public Integer getModeListshowId() {
        return modeListshowId;
    }

    public void setModeListshowId(Integer modeListshowId) {
        this.modeListshowId = modeListshowId;
    }

    @Override
    public String toString() {
        return "KdzsModeListShowDTO{" +
                "excode='" + excode + '\'' +
                ", excodeName='" + excodeName + '\'' +
                ", isDef=" + isDef +
                ", cainiaoTemplateId='" + cainiaoTemplateId + '\'' +
                ", kddType=" + kddType +
                ", logisticsCompanyId='" + logisticsCompanyId + '\'' +
                ", subTaobaoId=" + subTaobaoId +
                ", enableStatus=" + enableStatus +
                ", modeId='" + modeId + '\'' +
                ", modeListshowId=" + modeListshowId +
                '}';
    }
}
