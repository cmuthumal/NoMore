/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import db.EmployeeDBAccess;
import model.Employee;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class EmployeeController {

    private EmployeeDBAccess employeeDBAccess;

    public EmployeeController() {
        employeeDBAccess = new EmployeeDBAccess();
    }

    public boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        return employeeDBAccess.addEmployee(employee);
    }

    public boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        return employeeDBAccess.updateEmployee(employee);
    }

    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDBAccess.deleteEmployee(id);
    }

    public ArrayList<Employee> getAllEmployees() throws SQLException, ClassNotFoundException {
        return employeeDBAccess.getAllEmployees();
    }

    public ArrayList<Employee> searchEmployee(String key, String type) throws SQLException, ClassNotFoundException {
        return employeeDBAccess.searchEmployee(key, type);
    }
}
