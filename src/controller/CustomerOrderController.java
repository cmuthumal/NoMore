/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.CustomerOrderDBAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Order;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class CustomerOrderController {

    private CustomerOrderDBAccess orderDBAccess;

    public CustomerOrderController() {
        orderDBAccess = new CustomerOrderDBAccess();
    }
    
    public boolean addOrder(Order order) throws SQLException, ClassNotFoundException {
        return orderDBAccess.addOrder(order);
    }

    public boolean updateOrder(Order order) throws SQLException, ClassNotFoundException {
        return orderDBAccess.updateOrder(order);
    }

    public boolean deleteOrder(String id) throws SQLException, ClassNotFoundException {
        return orderDBAccess.deleteOrder(id);
    }

    public ArrayList<Order> getAllOrders() throws SQLException, ClassNotFoundException {
        return orderDBAccess.getAllOrders();
    }

    public ArrayList<Order> searchOrder(String key, String type) throws SQLException, ClassNotFoundException {
        return orderDBAccess.searchOrder(key, type);
    }
}
