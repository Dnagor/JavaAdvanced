package JDBC.lecture;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper {

    public static Employee map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String first_name = resultSet.getString("first_name");
        String last_name = resultSet.getString("last_name");

        return new Employee(id, first_name, last_name);
    }
}
