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
import model.ChequeStatus;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class RecievedChequeStatusDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addChequeStatus(ChequeStatus chequeStatus) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO RecievedChequeStatus VALUES('" + chequeStatus.getId() + "','" + chequeStatus.getChequeId() + "','" + chequeStatus.getStatus() + "');";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateChequeStatus(ChequeStatus chequeStatus) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE RecievedChequeStatus SET chequeId='" + chequeStatus.getChequeId() + "',status='" + chequeStatus.getStatus() + "' WHERE id='" + chequeStatus.getId() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteChequeStatus(String id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM RecievedChequeStatus WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<ChequeStatus> getChequeStatuses() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM RecievedChequeStatus;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<ChequeStatus> chequeStatusList = new ArrayList<>();
        while (resultSet.next()) {
            ChequeStatus chequeStatus = new ChequeStatus(resultSet.getString("id"), resultSet.getString("chequeId"), resultSet.getString("status"));
            chequeStatusList.add(chequeStatus);
        }
        return chequeStatusList;
    }

    public ArrayList<ChequeStatus> searchChequeStatuses(String key, String type) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM RecievedChequeStatus WHERE " + type + " LIKE '" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<ChequeStatus> chequeStatusList = new ArrayList<>();
        while (resultSet.next()) {
            ChequeStatus chequeStatus = new ChequeStatus(resultSet.getString("id"), resultSet.getString("chequeId"), resultSet.getString("status"));
            chequeStatusList.add(chequeStatus);
        }
        return chequeStatusList;
    }

    public String getLastID() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM RecievedChequeStatus ORDER BY id DESC LIMIT 1;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<ChequeStatus> chequeStatusList = new ArrayList<>();
        while (resultSet.next()) {
            ChequeStatus chequeStatus = new ChequeStatus(resultSet.getString("id"), resultSet.getString("chequeId"), resultSet.getString("status"));
            chequeStatusList.add(chequeStatus);
        }
        ChequeStatus c = chequeStatusList.get(0);

        String lastID = c.getId();
        return lastID;
    }
}
