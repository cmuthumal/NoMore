/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import db.CustomerDBAccess;
import model.Customer;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class CustomerController {

    private CustomerDBAccess customerDBAccess;

    public CustomerController() {
        customerDBAccess = new CustomerDBAccess();
    }

    public boolean addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        return customerDBAccess.addCustomer(customer);
    }

    public boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        return customerDBAccess.updateCustomer(customer);
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDBAccess.deleteCustomer(id);
    }

    public ArrayList<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {
        return customerDBAccess.getAllCustomers();
    }

    public ArrayList<Customer> searchCustomer(String key, String type) throws SQLException, ClassNotFoundException {
        return customerDBAccess.searchCustomer(key, type);
    }
}
