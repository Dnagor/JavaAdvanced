package JDBC.homework;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityMapper {
    public static City map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String countryCode = resultSet.getString("countryCode");
        String district = resultSet.getString("district");
        int population = resultSet.getInt("population");
        return new City(id, name, countryCode, district, population);
    }
}
