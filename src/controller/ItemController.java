/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import db.ItemDBAccess;
import model.Item;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class ItemController {
    private ItemDBAccess itemDBAccess;

    public ItemController() {
        itemDBAccess = new ItemDBAccess();
    }

    public boolean addItem(Item item) throws SQLException, ClassNotFoundException {
        return itemDBAccess.addItem(item);
    }

    public boolean updateItem(Item item) throws SQLException, ClassNotFoundException {
        return itemDBAccess.updateItem(item);
    }

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return itemDBAccess.deleteItem(code);
    }

    public ArrayList<Item> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDBAccess.getAllItems();
    }

    public ArrayList<Item> searchItem(String key, String type) throws SQLException, ClassNotFoundException {
        return itemDBAccess.searchItem(key, type);
    }
}
