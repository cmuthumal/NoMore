/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.SupplierPaymentDBAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Payment;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class SupplierPaymentController {

    private SupplierPaymentDBAccess paymentDBAccess;

    public SupplierPaymentController() {
        paymentDBAccess = new SupplierPaymentDBAccess();
    }

    public boolean addPayment(Payment payment) throws SQLException, ClassNotFoundException {
        return paymentDBAccess.addPayment(payment);
    }

    public boolean updatePayment(Payment payment) throws SQLException, ClassNotFoundException {
        return paymentDBAccess.updatePayment(payment);
    }

    public boolean deletePayment(String id) throws SQLException, ClassNotFoundException {
        return paymentDBAccess.deletePayment(id);
    }

    public ArrayList<Payment> getAllPayments() throws SQLException, ClassNotFoundException {
        return paymentDBAccess.getAllPayments();
    }

    public ArrayList<Payment> getPayments(String orderId) throws SQLException, ClassNotFoundException {
        return paymentDBAccess.getPayments(orderId);
    }

    public ArrayList<Payment> searchPayments(String key, String type) throws SQLException, ClassNotFoundException {
        return paymentDBAccess.searchPayments(key, type);
    }

    public String getLastID() throws SQLException, ClassNotFoundException {
        return paymentDBAccess.getLastID();
    }
}
