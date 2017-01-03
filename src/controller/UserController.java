/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import db.UserDBAccess;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class UserController {

    private UserDBAccess userDBAccess;

    public UserController() {
        userDBAccess = new UserDBAccess();
    }

    public ArrayList<User> searchUser(String userName) throws SQLException, ClassNotFoundException {
        return userDBAccess.searchUser(userName);
    }

    public boolean checkPassword(String userName, String password) throws SQLException, ClassNotFoundException {
        return userDBAccess.checkPassword(userName, password);
    }

    public boolean updateUser(User user) throws SQLException, ClassNotFoundException {
        return userDBAccess.updateUser(user);
    }
}