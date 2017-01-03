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
import model.Cheque;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class IssuedChequesDBAccess {

    private Connection connection = null;
    private Statement stm = null;
    
    public boolean addCheque(Cheque cheque) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO IssuedCheques VALUES('" + cheque.getId() + "','" + cheque.getOrderId() + "','" + cheque.getNumber() + "','" + cheque.getBank() + "','" + cheque.getIssuedDate() + "','" + cheque.getRealDate() + "'," + cheque.getAmount() + ");";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateCheque(Cheque cheque) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE IssuedCheques SET orderId='" + cheque.getOrderId() + "',number='" + cheque.getNumber() + "',bank='" + cheque.getBank() + "',issuedDate='" + cheque.getIssuedDate() + "',realDate='" + cheque.getRealDate() + "',amount=" + cheque.getAmount() + " WHERE id='" + cheque.getId() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteCheque(String id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM IssuedCheques WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<Cheque> getCheques() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM IssuedCheques;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Cheque> chequesList = new ArrayList<>();
        while (resultSet.next()) {
            Cheque cheque = new Cheque(resultSet.getString("id"), resultSet.getString("orderId"), resultSet.getString("number"), resultSet.getString("bank"), resultSet.getString("issuedDate"), resultSet.getString("realDate"), resultSet.getDouble("amount"));
            chequesList.add(cheque);
        }
        return chequesList;
    }

    public ArrayList<Cheque> searchCheques(String key, String type) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM IssuedCheques WHERE " + type + " LIKE '" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Cheque> chequesList = new ArrayList<>();
        while (resultSet.next()) {
            Cheque cheque = new Cheque(resultSet.getString("id"), resultSet.getString("orderId"), resultSet.getString("number"), resultSet.getString("bank"), resultSet.getString("issuedDate"), resultSet.getString("realDate"), resultSet.getDouble("amount"));
            chequesList.add(cheque);
        }
        return chequesList;
    }

    public String getLastID() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String lastID = null;

        String sql = "SELECT * FROM IssuedCheques ORDER BY id DESC LIMIT 1;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Cheque> chequesList = new ArrayList<>();
        while (resultSet.next()) {
            Cheque cheque = new Cheque(resultSet.getString("id"), resultSet.getString("orderId"), resultSet.getString("number"), resultSet.getString("bank"), resultSet.getString("issuedDate"), resultSet.getString("realDate"), resultSet.getDouble("amount"));
            chequesList.add(cheque);
        }

        if (!chequesList.isEmpty()) {
            Cheque c = chequesList.get(0);
            lastID = c.getId();
        } else {
            lastID = "QI0000";
        }

        return lastID;
    }
}
