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
import model.Employee;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class EmployeeDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO Employees VALUES('" + employee.getId() + "', '" + employee.getName() + "',  " + employee.getNic() + ", '" + employee.getDob() + "', '" + employee.getAddress() + "', " + employee.getSalary() + ", " + employee.getMobile() + ", " + employee.getPhone() + ", '" + employee.getJoinedDate() + "' , '" + employee.getNotes() + "' );";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE Employees SET name='" + employee.getName() + "', nic=" + employee.getNic() + ", dob='" + employee.getDob() + "', address='" + employee.getAddress() + "', salary=" + employee.getSalary() + ", mobile=" + employee.getMobile() + ",phone=" + employee.getPhone() + ", joinedDate='" + employee.getJoinedDate() + "', notes='" + employee.getNotes() + "' WHERE id='" + employee.getId() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM Employees WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<Employee> getAllEmployees() throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM Employees";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Employee> employeesList = new ArrayList<Employee>();
        while (resultSet.next()) {
            Employee employee = new Employee(resultSet.getString("id"), resultSet.getString("name"), resultSet.getInt("nic"), resultSet.getString("dob"), resultSet.getString("address"), resultSet.getDouble("salary"), resultSet.getInt("mobile"), resultSet.getInt("phone"), resultSet.getString("joinedDate"), resultSet.getString("notes"));
            employeesList.add(employee);
        }
        return employeesList;
    }

    public ArrayList<Employee> searchEmployee(String key, String type) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM Employees WHERE " + type + " LIKE '" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Employee> employeesList = new ArrayList<Employee>();
        while (resultSet.next()) {
            Employee employee = new Employee(resultSet.getString("id"), resultSet.getString("name"), resultSet.getInt("nic"), resultSet.getString("dob"), resultSet.getString("address"), resultSet.getDouble("salary"), resultSet.getInt("mobile"), resultSet.getInt("phone"), resultSet.getString("joinedDate"), resultSet.getString("notes"));
            employeesList.add(employee);
        }
        return employeesList;
    }
}
