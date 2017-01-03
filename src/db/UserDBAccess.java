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
import model.User;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class UserDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean checkPassword(String userName, String password) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM Users WHERE username='" + userName + "' AND password=(SELECT PASSWORD('" + password + "'));";
        ResultSet resultSet = connection.createStatement().executeQuery(sql);

        if (resultSet.first()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateUser(User user) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE Users SET userName='" + user.getUserName() + "', password=(SELECT PASSWORD('" + user.getPassword() + "')) WHERE id='" + user.getId() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<User> searchUser(String userName) throws SQLException, ClassNotFoundException {
        ArrayList<User> userList = new ArrayList<>();
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM Users WHERE username='" + userName + "';";
        ResultSet resultSet = stm.executeQuery(sql);
        while (resultSet.next()) {
            User user = new User(resultSet.getString("id"), resultSet.getString("userName"), null);
            userList.add(user);
        }

        return userList;
    }
}
