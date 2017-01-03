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
import model.Customer;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class CustomerDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO Customers VALUES('" + customer.getId() + "', '" + customer.getName() + "',  '" + customer.getAddress() + "', " + customer.getMobile() + ", " + customer.getPhone() + ", '" + customer.getAddedDate() + "','" + customer.getNote() + "');";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE Customers SET name='" + customer.getName() + "', address='" + customer.getAddress() + "', mobile=" + customer.getMobile() + ", phone=" + customer.getPhone() + ", addedDate='" + customer.getAddedDate() + "',notes='"+customer.getNote()+"' WHERE id='" + customer.getId() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM Customers WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM Customers";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Customer> customersList = new ArrayList<>();
        while (resultSet.next()) {
            Customer customer = new Customer(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("address"), resultSet.getInt("mobile"), resultSet.getInt("phone"), resultSet.getString("addedDate"), resultSet.getString("notes"));
            customersList.add(customer);
        }
        return customersList;
    }

    public ArrayList<Customer> searchCustomer(String key, String type) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM Customers WHERE " + type + " LIKE '" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Customer> customersList = new ArrayList<>();
        while (resultSet.next()) {
            Customer customer = new Customer(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("address"), resultSet.getInt("mobile"), resultSet.getInt("phone"), resultSet.getString("addedDate"), resultSet.getString("notes"));
            customersList.add(customer);
        }
        return customersList;
    }
}
