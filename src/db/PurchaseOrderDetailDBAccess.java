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
import model.PurchaseOrderDetail;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class PurchaseOrderDetailDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addOrderDetail(PurchaseOrderDetail orderDetail) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO PurchaseOrderDetails VALUES('" + orderDetail.getOrderId() + "','" + orderDetail.getItemCode() + "'," + orderDetail.getQty() + "," + orderDetail.getUnitPrice() + ");";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateOrderDetail(PurchaseOrderDetail orderDetail) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE PurchaseOrderDetails SET qty=" + orderDetail.getQty() + ",unitPrice=" + orderDetail.getUnitPrice() + " WHERE orderId='" + orderDetail.getOrderId() + "' AND itemCode='" + orderDetail.getItemCode() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteOrderDetail(String orderId, String itemCode) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM PurchaseOrderDetails WHERE orderId='" + orderId + "' AND itemCode='" + itemCode + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<PurchaseOrderDetail> getOrderDetails(String orderId) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM PurchaseOrderDetails WHERE orderId='" + orderId + "';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<PurchaseOrderDetail> orderDetailList = new ArrayList<>();
        while (resultSet.next()) {
            PurchaseOrderDetail order = new PurchaseOrderDetail(resultSet.getString("orderId"), resultSet.getString("itemCode"), resultSet.getInt("qty"), resultSet.getDouble("unitPrice"));
            orderDetailList.add(order);
        }
        return orderDetailList;
    }
}
