package JDBC.homework;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    private static final String URL = "jdbc:mysql://localhost/world";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Logger log = Logger.getLogger(ConnectionUtils.class);

    public static Connection openConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        log.info("Establishing connection to database");
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
