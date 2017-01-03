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
import model.PurchaseOrder;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class PurchaseOrderDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addOrder(PurchaseOrder order) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        
        String sql = "INSERT INTO PurchaseOrders VALUES('" + order.getId() + "','" + order.getSupplierId() + "','" + order.getAddedDate() + "','" + order.getDueDate() + "','" + order.getAmount()+ "');";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteOrder(String id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        
        String sql = "DELETE FROM PurchaseOrders WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateOrder(PurchaseOrder order) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        
        String sql = "UPDATE PurchaseOrders SET customerId ='" + order.getSupplierId() + "', addedDate='" + order.getAddedDate() + "', dueDate='" + order.getDueDate() + "', amount='" + order.getAmount()+ "'  WHERE id='" + order.getId() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<PurchaseOrder> getAllOrders() throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        
        String sql = "SELECT * FROM PurchaseOrders;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<PurchaseOrder> ordersList = new ArrayList<>();
        while (resultSet.next()) {
            PurchaseOrder order = new PurchaseOrder(resultSet.getString("id"), resultSet.getString("supplierId"), resultSet.getString("addedDate"), resultSet.getString("dueDate"), resultSet.getDouble("amount"));
            ordersList.add(order);
        }
        return ordersList;
    }

    public ArrayList<PurchaseOrder> searchOrder(String key, String type) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        
        String sql = "SELECT * FROM PurchaseOrders WHERE " + type + " LIKE '" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<PurchaseOrder> ordersList = new ArrayList<>();
        while (resultSet.next()) {
            PurchaseOrder order = new PurchaseOrder(resultSet.getString("id"), resultSet.getString("supplierId"), resultSet.getString("addedDate"), resultSet.getString("dueDate"), resultSet.getDouble("amount"));
            ordersList.add(order);
        }
        return ordersList;
    }
}
