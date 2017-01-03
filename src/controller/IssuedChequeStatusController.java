/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.IssuedChequeStatusDBAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ChequeStatus;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class IssuedChequeStatusController {

    private IssuedChequeStatusDBAccess chequeStatusDBAccess;

    public IssuedChequeStatusController() {
        chequeStatusDBAccess = new IssuedChequeStatusDBAccess();
    }

    public boolean addChequeStatus(ChequeStatus chequeStatus) throws SQLException, ClassNotFoundException {
        return chequeStatusDBAccess.addChequeStatus(chequeStatus);
    }

    public boolean updateChequeStatus(ChequeStatus chequeStatus) throws SQLException, ClassNotFoundException {
        return chequeStatusDBAccess.updateChequeStatus(chequeStatus);
    }

    public boolean deleteChequeStatus(String id) throws SQLException, ClassNotFoundException {
        return chequeStatusDBAccess.deleteChequeStatus(id);
    }

    public ArrayList<ChequeStatus> getChequeStatuses() throws SQLException, ClassNotFoundException {
        return chequeStatusDBAccess.getChequeStatuses();
    }

    public ArrayList<ChequeStatus> searchChequeStatuses(String key, String type) throws SQLException, ClassNotFoundException {
        return chequeStatusDBAccess.searchChequeStatuses(key, type);
    }

    public String getLastID() throws SQLException, ClassNotFoundException {
        return chequeStatusDBAccess.getLastID();
    }
}
