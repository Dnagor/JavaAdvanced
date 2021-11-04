package JDBC.homework;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryLanguageMapper {

    public static CountryLanguage map(ResultSet resultSet) throws SQLException {
        String countryCode = resultSet.getString("countryCode");
        String language = resultSet.getString("language");
        String isOfficial = resultSet.getString("isOfficial");
        double percentage = resultSet.getDouble("percentage");

        return new CountryLanguage(countryCode, language, isOfficial, percentage);
    }
}
