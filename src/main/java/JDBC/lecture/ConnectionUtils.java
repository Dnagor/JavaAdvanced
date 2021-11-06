package JDBC.lecture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    private static final String URL = "jdbc:mysql://localhost/employee";
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "root";

    public static Connection openConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
    }

}
