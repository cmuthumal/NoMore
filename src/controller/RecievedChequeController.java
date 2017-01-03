/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.RecievedChequesDBAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cheque;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class RecievedChequeController {

    private RecievedChequesDBAccess chequeDBAccess;

    public RecievedChequeController() {
        chequeDBAccess = new RecievedChequesDBAccess();
    }

    public boolean addCheque(Cheque cheque) throws SQLException, ClassNotFoundException {
        return chequeDBAccess.addCheque(cheque);
    }

    public boolean updateCheque(Cheque cheque) throws SQLException, ClassNotFoundException {
        return chequeDBAccess.updateCheque(cheque);
    }

    public boolean deleteCheque(String id) throws SQLException, ClassNotFoundException {
        return chequeDBAccess.deleteCheque(id);
    }

    public ArrayList<Cheque> getCheques() throws SQLException, ClassNotFoundException {
        return chequeDBAccess.getCheques();
    }

    public ArrayList<Cheque> searchCheques(String key, String type) throws SQLException, ClassNotFoundException {
        return chequeDBAccess.searchCheques(key, type);
    }

    public String getLastID() throws SQLException, ClassNotFoundException {
        return chequeDBAccess.getLastID();
    }
}
