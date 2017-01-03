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
import model.Item;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class ItemDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addItem(Item item) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        
        String sql = "INSERT INTO Items values('" + item.getCode() + "','" + item.getDescription() + "'," + item.getUnitPrice() + "," + item.getDiscount() + "," + item.getQtyOnHand() + ",'"+item.getAddedDate()+"','" + item.getNotes() + "');";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateItem(Item item) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        
        String sql = "UPDATE Items SET description='"+item.getDescription()+"',unitPrice="+item.getUnitPrice()+",discount="+item.getDiscount()+",qtyOnHand="+item.getQtyOnHand()+",addedDate='"+item.getAddedDate()+"',notes='"+item.getNotes()+"' WHERE code='"+item.getCode()+"';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }
    
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        
        String sql = "DELETE FROM Items WHERE code='" + code + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }
    
    public ArrayList<Item> getAllItems() throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        
        String sql = "SELECT * FROM Items";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Item> itemsList = new ArrayList<Item>();
        while (resultSet.next()) {
            Item item = new Item(resultSet.getString("code"),resultSet.getString("description"),resultSet.getDouble("unitPrice"),resultSet.getDouble("discount"),resultSet.getInt("qtyOnHand"),resultSet.getString("addedDate"),resultSet.getString("notes"));
            itemsList.add(item);
        }
        return itemsList;
    }
    
    public ArrayList<Item> searchItem(String key, String type) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        
        String sql = "SELECT * FROM Items WHERE " + type + " LIKE '" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Item> itemsList = new ArrayList<Item>();
        while (resultSet.next()) {
            Item item = new Item(resultSet.getString("code"),resultSet.getString("description"),resultSet.getDouble("unitPrice"),resultSet.getDouble("discount"),resultSet.getInt("qtyOnHand"),resultSet.getString("addedDate"),resultSet.getString("notes"));
            itemsList.add(item);
        }
        return itemsList;
    }
}
