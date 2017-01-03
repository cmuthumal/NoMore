/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.PurchaseOrderDBAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import model.PurchaseOrder;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class PurchaseOrderController {

    private PurchaseOrderDBAccess orderDBAccess;

    public PurchaseOrderController() {
        orderDBAccess = new PurchaseOrderDBAccess();
    }
    
    public boolean addOrder(PurchaseOrder order) throws SQLException, ClassNotFoundException {
        return orderDBAccess.addOrder(order);
    }

    public boolean updateOrder(PurchaseOrder order) throws SQLException, ClassNotFoundException {
        return orderDBAccess.updateOrder(order);
    }

    public boolean deleteOrder(String id) throws SQLException, ClassNotFoundException {
        return orderDBAccess.deleteOrder(id);
    }

    public ArrayList<PurchaseOrder> getAllOrders() throws SQLException, ClassNotFoundException {
        return orderDBAccess.getAllOrders();
    }

    public ArrayList<PurchaseOrder> searchOrder(String key, String type) throws SQLException, ClassNotFoundException {
        return orderDBAccess.searchOrder(key, type);
    }
}
