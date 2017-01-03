/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.CustomerOrderDetailDBAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import model.OrderDetail;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class CustomerOrderDetailController {

    private CustomerOrderDetailDBAccess orderDetailDBAccess;

    public CustomerOrderDetailController() {
        orderDetailDBAccess = new CustomerOrderDetailDBAccess();
    }

    public boolean addOrderDetail(OrderDetail order) throws SQLException, ClassNotFoundException {
        return orderDetailDBAccess.addOrderDetail(order);
    }

    public boolean updateOrderDetail(OrderDetail order) throws SQLException, ClassNotFoundException {
        return orderDetailDBAccess.updateOrderDetail(order);
    }

    public boolean deleteOrderDetail(String orderId, String itemCode) throws SQLException, ClassNotFoundException {
        return orderDetailDBAccess.deleteOrderDetail(orderId, itemCode);
    }

    public ArrayList<OrderDetail> getAllOrderDetails(String orderId) throws SQLException, ClassNotFoundException {
        return orderDetailDBAccess.getOrderDetails(orderId);
    }
}
