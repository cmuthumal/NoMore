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
import model.Supplier;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class SupplierDBAccess {

    private Connection connection = null;
    private Statement stm = null;
    
    public boolean addSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO Suppliers VALUES('" + supplier.getId() + "', '" + supplier.getName() + "',  '" + supplier.getAddress() + "', " + supplier.getMobile() + ", " + supplier.getPhone() + ", '" + supplier.getAddedDate() + "'','"+supplier.getNotes()+"');";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE Suppliers SET name='" + supplier.getName() + "', address='" + supplier.getAddress() + "', mobile=" + supplier.getMobile() + ", phone=" + supplier.getPhone() + ", addedDate='" + supplier.getAddedDate() + "',notes='"+supplier.getNotes()+"' WHERE id='" + supplier.getId() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM Suppliers WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<Supplier> getAllSuppliers() throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM Suppliers";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Supplier> suppliersList = new ArrayList<>();
        while (resultSet.next()) {
            Supplier supplier = new Supplier(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("address"), resultSet.getInt("mobile"), resultSet.getInt("phone"), resultSet.getString("addedDate"), resultSet.getString("notes"));
            suppliersList.add(supplier);
        }
        return suppliersList;
    }

    public ArrayList<Supplier> searchSupplier(String key, String type) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM Suppliers WHERE " + type + " LIKE '" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Supplier> suppliersList = new ArrayList<>();
        while (resultSet.next()) {
            Supplier supplier = new Supplier(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("address"), resultSet.getInt("mobile"), resultSet.getInt("phone"), resultSet.getString("addedDate"), resultSet.getString("notes"));
            suppliersList.add(supplier);
        }
        return suppliersList;
    }
}
