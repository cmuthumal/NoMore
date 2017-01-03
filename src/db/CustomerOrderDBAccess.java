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
import model.Order;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class CustomerOrderDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addOrder(Order order) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        
        String sql = "INSERT INTO CustomerOrders VALUES('" + order.getId() + "','" + order.getCustomerId() + "','" + order.getAddedDate() + "','" + order.getDueDate() + "'," + order.getDiscount() + ",'" + order.getAmount()+ "');";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteOrder(String id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        
        String sql = "DELETE FROM CustomerOrders WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateOrder(Order order) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        
        String sql = "UPDATE CustomerOrders SET customerId ='" + order.getCustomerId() + "', addedDate='" + order.getAddedDate() + "', dueDate='" + order.getDueDate() + "', discount=" + order.getDiscount() + ", amount='" + order.getAmount()+ "'  WHERE id='" + order.getId() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<Order> getAllOrders() throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        
        String sql = "SELECT * FROM CustomerOrders;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Order> ordersList = new ArrayList<>();
        while (resultSet.next()) {
            Order order = new Order(resultSet.getString("id"), resultSet.getString("customerId"), resultSet.getString("addedDate"), resultSet.getString("dueDate"), resultSet.getDouble("discount"), resultSet.getDouble("amount"));
            ordersList.add(order);
        }
        return ordersList;
    }

    public ArrayList<Order> searchOrder(String key, String type) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        
        String sql = "SELECT * FROM CustomerOrders WHERE " + type + " LIKE '" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Order> ordersList = new ArrayList<>();
        while (resultSet.next()) {
            Order order = new Order(resultSet.getString("id"), resultSet.getString("customerId"), resultSet.getString("addedDate"), resultSet.getString("dueDate"), resultSet.getDouble("discount"), resultSet.getDouble("amount"));
            ordersList.add(order);
        }
        return ordersList;
    }
}
