/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.PurchaseOrderDetailDBAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import model.PurchaseOrderDetail;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class PurchaseOrderDetailController {

    private PurchaseOrderDetailDBAccess orderDetailDBAccess;

    public PurchaseOrderDetailController() {
        orderDetailDBAccess = new PurchaseOrderDetailDBAccess();
    }

    public boolean addOrderDetail(PurchaseOrderDetail order) throws SQLException, ClassNotFoundException {
        return orderDetailDBAccess.addOrderDetail(order);
    }

    public boolean updateOrderDetail(PurchaseOrderDetail order) throws SQLException, ClassNotFoundException {
        return orderDetailDBAccess.updateOrderDetail(order);
    }

    public boolean deleteOrderDetail(String orderId, String itemCode) throws SQLException, ClassNotFoundException {
        return orderDetailDBAccess.deleteOrderDetail(orderId, itemCode);
    }

    public ArrayList<PurchaseOrderDetail> getAllOrderDetails(String orderId) throws SQLException, ClassNotFoundException {
        return orderDetailDBAccess.getOrderDetails(orderId);
    }
}
