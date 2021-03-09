package org.open.boot.api.kuaidizs.dto;

/**
 * 快递助手：发票内容
 *
 * @author barnak
 */
public class KdzsMallInvoiceDTO {
    /**
     * 发票内容
     */
    private String invoice;

    /**
     * 发票抬头
     */
    private String invoiceHead;

    /**
     * 发票寄件地址
     */
    private String invoiceRecipientAddress;

    /**
     * 发票手机号
     */
    private String invoiceRecipientHandPhone;

    /**
     * 发票电话
     */
    private String invoiceRecipientPhone;

    /**
     * 发票类型，增值还是普通（01增值 02普通 04 电子发票）
     */
    private String invoiceType;

}
