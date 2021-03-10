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

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getInvoiceHead() {
        return invoiceHead;
    }

    public void setInvoiceHead(String invoiceHead) {
        this.invoiceHead = invoiceHead;
    }

    public String getInvoiceRecipientAddress() {
        return invoiceRecipientAddress;
    }

    public void setInvoiceRecipientAddress(String invoiceRecipientAddress) {
        this.invoiceRecipientAddress = invoiceRecipientAddress;
    }

    public String getInvoiceRecipientHandPhone() {
        return invoiceRecipientHandPhone;
    }

    public void setInvoiceRecipientHandPhone(String invoiceRecipientHandPhone) {
        this.invoiceRecipientHandPhone = invoiceRecipientHandPhone;
    }

    public String getInvoiceRecipientPhone() {
        return invoiceRecipientPhone;
    }

    public void setInvoiceRecipientPhone(String invoiceRecipientPhone) {
        this.invoiceRecipientPhone = invoiceRecipientPhone;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    @Override
    public String toString() {
        return "KdzsMallInvoiceDTO{" +
                "invoice='" + invoice + '\'' +
                ", invoiceHead='" + invoiceHead + '\'' +
                ", invoiceRecipientAddress='" + invoiceRecipientAddress + '\'' +
                ", invoiceRecipientHandPhone='" + invoiceRecipientHandPhone + '\'' +
                ", invoiceRecipientPhone='" + invoiceRecipientPhone + '\'' +
                ", invoiceType='" + invoiceType + '\'' +
                '}';
    }
}
