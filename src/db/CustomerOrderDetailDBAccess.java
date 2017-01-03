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
import model.OrderDetail;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class CustomerOrderDetailDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addOrderDetail(OrderDetail orderDetail) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO CustomerOrderDetails VALUES('" + orderDetail.getOrderId() + "','" + orderDetail.getItemCode() + "'," + orderDetail.getQty() + "," + orderDetail.getUnitPrice() + "," + orderDetail.getDiscount() + ");";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateOrderDetail(OrderDetail orderDetail) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE CustomerOrderDetails SET qty=" + orderDetail.getQty() + ",unitPrice=" + orderDetail.getUnitPrice() + ",discount=" + orderDetail.getDiscount() + " WHERE orderId='" + orderDetail.getOrderId() + "' AND itemCode='" + orderDetail.getItemCode() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteOrderDetail(String orderId, String itemCode) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM CustomerOrderDetails WHERE orderId='" + orderId + "' AND itemCode='" + itemCode + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<OrderDetail> getOrderDetails(String orderId) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM CustomerOrderDetails WHERE orderId='" + orderId + "';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<OrderDetail> orderDetailList = new ArrayList<>();
        while (resultSet.next()) {
            OrderDetail order = new OrderDetail(resultSet.getString("orderId"), resultSet.getString("itemCode"), resultSet.getInt("qty"), resultSet.getDouble("unitPrice"), resultSet.getDouble("discount"));
            orderDetailList.add(order);
        }
        return orderDetailList;
    }
}
