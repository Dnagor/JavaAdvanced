package JDBC.homework;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryLanguageDAO {
    private static final String readAll = "select * from countrylanguage";
    private static final String insertCountryLanguage = "insert into " +
            "countrylanguage(CountryCode, Language, IsOfficial, Percentage) values (?,?,?,?)";
    private static final String readByCountryCode = "select * from countrylanguage where CountryCode = ?";
    private static final String updateCountryLanguagePercentage = "update countrylanguage " +
            "set Percentage=? where CountryCode=? and Language=? and IsOfficial=?";
    private static final String deleteByCountryCode = "delete from countrylanguage where CountryCode = ?";

    private final Connection connection;
    Logger log = Logger.getLogger(CityDAO.class);
    private PreparedStatement preparedStatement;


    public CountryLanguageDAO(Connection connection) {
        this.connection = connection;
    }

    public List<CountryLanguage> readAll() {
        List<CountryLanguage> countryLanguages = new ArrayList<>();
        try {
            log.info("Reading all information from CounryLangyage table.");
            preparedStatement = connection.prepareStatement(readAll);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                countryLanguages.add(CountryLanguageMapper.map(resultSet));
            }
        } catch (SQLException throwables) {
            log.warn("Couldnt read all from CountryLanguage table", throwables);
        }
        return countryLanguages;
    }

    public List<CountryLanguage> readByCountryCode(String code) {
        List<CountryLanguage> countryLanguages = new ArrayList<>();
        try {
            log.info(String.format("Reading from CountryLanguage table by code: %s", code));
            preparedStatement = connection.prepareStatement(readByCountryCode);
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                countryLanguages.add(CountryLanguageMapper.map(resultSet));
            }
        } catch (SQLException throwables) {
            log.warn(String.format("Couldn't read from CountryLanguage table by code: %s", code),throwables);
        }
        return countryLanguages;
    }

    public void insertCountryLanguage(CountryLanguage countryLanguage) {
        log.info(String.format("Inserting inro CountryLanguage table: %s", countryLanguage));
        try {
            preparedStatement = connection.prepareStatement(insertCountryLanguage);
            preparedStatement.setString(1, countryLanguage.getCountryCode());
            preparedStatement.setString(2, countryLanguage.getLanguage());
            preparedStatement.setString(3, countryLanguage.getOfficial());
            preparedStatement.setDouble(4, countryLanguage.getPercentage());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            log.warn(String.format("Couldn't add %s to CountryLanguage table", countryLanguage), throwables);
        }
    }

    public void updateCountryLanguagePercentage(CountryLanguage countryLanguage) {
        try {
            log.info(String.format("Updating CountryLanguage table with %s", countryLanguage));
            preparedStatement = connection.prepareStatement(updateCountryLanguagePercentage);
            preparedStatement.setDouble(1, countryLanguage.getPercentage());
            preparedStatement.setString(2, countryLanguage.getCountryCode());
            preparedStatement.setString(3, countryLanguage.getLanguage());
            preparedStatement.setString(4, countryLanguage.getOfficial());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            log.warn(String.format("Couldn't update CountryLanguage with %s", countryLanguage), throwables);
        }
    }

    public void deleteByCountryCode(String code) {
        try {
            log.info(String.format("Deleting from CountryLanguage table by code: %s", code));
            preparedStatement = connection.prepareStatement(deleteByCountryCode);
            preparedStatement.setString(1, code);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            log.warn(String.format("Couldn't delete from CountryLanguage table by code: %s", code), throwables);
        }
    }

}
