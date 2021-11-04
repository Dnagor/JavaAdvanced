package JDBC.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    private static final String URL = "jdbc:mysql://localhost/world";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection openConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
