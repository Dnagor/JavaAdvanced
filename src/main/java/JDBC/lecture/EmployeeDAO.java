package JDBC.lecture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static final String READ_ALL = "select * from employee";
    private static final String CREATE = "insert into employee(first_name,last_name) values(?,?)";
    private static final String READ_BY_ID = "select * from employee where id=?";
    private static final String UPDATE_BY_ID = "update employee set first_name=?,last_name=? where id=?";
    private static final String DELETE_BY_ID = "delete from employee where id=?";

    private final Connection connection;
    private PreparedStatement preparedStatement;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Employee employee) {
        try {
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Employee read(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(READ_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return EmployeeMapper.map(resultSet);
    }

    public void update(Employee employee) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setInt(3, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Employee> readAll() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employeeList.add(EmployeeMapper.map(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }
}
