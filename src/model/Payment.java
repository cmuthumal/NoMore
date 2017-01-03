/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class Payment {

    private String paymentId;
    private String orderId;
    private String date;
    private double payment;
    private double paidAmount;
    private String invoiceNo;
    private String method;
    private String chequeID;;

    public Payment(String paymentId, String orderId, String date, double payment, double paidAmount, String invoiceNo, String method, String chequeID) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.date = date;
        this.payment = payment;
        this.paidAmount = paidAmount;
        this.invoiceNo = invoiceNo;
        this.method = method;
        this.chequeID = chequeID;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getChequeID() {
        return chequeID;
    }

    public void setChequeID(String chequeID) {
        this.chequeID = chequeID;
    }
}
