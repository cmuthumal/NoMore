/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.SupplierDBAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Supplier;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class SupplierController {

    private SupplierDBAccess supplierDBAccess;

    public SupplierController() {
        supplierDBAccess = new SupplierDBAccess();
    }

    public boolean addSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {
        return supplierDBAccess.addSupplier(supplier);
    }

    public boolean updateSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {
        return supplierDBAccess.updateSupplier(supplier);
    }

    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException {
        return supplierDBAccess.deleteSupplier(id);
    }

    public ArrayList<Supplier> getAllSuppliers() throws SQLException, ClassNotFoundException {
        return supplierDBAccess.getAllSuppliers();
    }

    public ArrayList<Supplier> searchSupplier(String key, String type) throws SQLException, ClassNotFoundException {
        return supplierDBAccess.searchSupplier(key, type);
    }
}
