/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Payment;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class SupplierPaymentDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addPayment(Payment payment) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO SupplierPayments VALUES('" + payment.getPaymentId() + "', '" + payment.getOrderId() + "',  '" + payment.getDate() + "', " + payment.getPayment() + ", " + payment.getPaidAmount() + ", '" + payment.getInvoiceNo() + "','" + payment.getMethod() + "','" + payment.getChequeID() + "');";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updatePayment(Payment payment) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE SupplierPayments SET orderId='" + payment.getOrderId() + "', date='" + payment.getDate() + "', payment=" + payment.getPayment() + ", paidAmount=" + payment.getPaidAmount() + ", invoiceNo='" + payment.getInvoiceNo() + "',method='" + payment.getMethod() + "',chequeId='" + payment.getChequeID() + "' WHERE paymentId='" + payment.getPaymentId() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deletePayment(String id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM SupplierPayments WHERE paymentId='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<Payment> getAllPayments() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM SupplierPayments;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Payment> paymentList = new ArrayList<>();
        while (resultSet.next()) {
            Payment payment = new Payment(resultSet.getString("paymentId"), resultSet.getString("orderId"), resultSet.getString("date"), resultSet.getDouble("payment"), resultSet.getDouble("paidAmount"), resultSet.getString("invoiceNo"), resultSet.getString("method"), resultSet.getString("chequeId"));
            paymentList.add(payment);
        }
        return paymentList;
    }

    public ArrayList<Payment> getPayments(String orderId) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM SupplierPayments WHERE orderId='" + orderId + "';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Payment> paymentList = new ArrayList<>();
        while (resultSet.next()) {
            Payment payment = new Payment(resultSet.getString("paymentId"), resultSet.getString("orderId"), resultSet.getString("date"), resultSet.getDouble("payment"), resultSet.getDouble("paidAmount"), resultSet.getString("invoiceNo"), resultSet.getString("method"), resultSet.getString("chequeId"));
            paymentList.add(payment);
        }
        return paymentList;
    }

    public ArrayList<Payment> searchPayments(String key, String type) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM SupplierPayments WHERE " + type + " LIKE '" + key + "';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Payment> paymentList = new ArrayList<>();
        while (resultSet.next()) {
            Payment payment = new Payment(resultSet.getString("paymentId"), resultSet.getString("orderId"), resultSet.getString("date"), resultSet.getDouble("payment"), resultSet.getDouble("paidAmount"), resultSet.getString("invoiceNo"), resultSet.getString("method"), resultSet.getString("chequeId"));
            paymentList.add(payment);
        }
        return paymentList;
    }

    public String getLastID() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String lastID;

        String sql = "SELECT * FROM SupplierPayments ORDER BY paymentId DESC LIMIT 1;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Payment> paymentList = new ArrayList<>();
        while (resultSet.next()) {
            Payment payment = new Payment(resultSet.getString("paymentId"), resultSet.getString("orderId"), resultSet.getString("date"), resultSet.getDouble("payment"), resultSet.getDouble("paidAmount"), resultSet.getString("invoiceNo"), resultSet.getString("method"), resultSet.getString("chequeId"));
            paymentList.add(payment);
        }
        
        if (!paymentList.isEmpty()) {
            Payment p = paymentList.get(0);
            lastID = p.getPaymentId();
        } else {
            lastID = "SP0000";
        }
        
        return lastID;
    }
}
