package JDBC.homework;

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
    private static final String updateCountryLanguagePercentage= "update countrylanguage " +
            "set Percentage=? where CountryCode=? and Language=? and IsOfficial=?";
    private static final String deleteByCountryCode = "delete from countrylanguage where CountryCode = ?";

    private final Connection connection;
    private PreparedStatement preparedStatement;

    public CountryLanguageDAO(Connection connection) {
        this.connection = connection;
    }

    public  List<CountryLanguage> readAll() throws SQLException {
        List<CountryLanguage> countryLanguages = new ArrayList<>();
        preparedStatement = connection.prepareStatement(readAll);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            countryLanguages.add(CountryLanguageMapper.map(resultSet));
        }
        return countryLanguages;
    }

    public List<CountryLanguage> readByCountryCode(String code) throws SQLException {
        List<CountryLanguage> countryLanguages = new ArrayList<>();
        preparedStatement = connection.prepareStatement(readByCountryCode);
        preparedStatement.setString(1,code);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            countryLanguages.add(CountryLanguageMapper.map(resultSet));
        }
        return countryLanguages;
    }

    public void insertCountryLanguage(CountryLanguage countryLanguage) throws SQLException {
        preparedStatement = connection.prepareStatement(insertCountryLanguage);
        preparedStatement.setString(1, countryLanguage.getCountryCode());
        preparedStatement.setString(2,countryLanguage.getLanguage());
        preparedStatement.setString(3,countryLanguage.getOfficial());
        preparedStatement.setDouble(4,countryLanguage.getPercentage());
        preparedStatement.executeUpdate();
    }
    public void updateCountryLanguagePercentage(CountryLanguage countryLanguage) throws SQLException {
        preparedStatement = connection.prepareStatement(updateCountryLanguagePercentage);
        preparedStatement.setDouble(1,countryLanguage.getPercentage());
        preparedStatement.setString(2,countryLanguage.getCountryCode());
        preparedStatement.setString(3,countryLanguage.getLanguage());
        preparedStatement.setString(4,countryLanguage.getOfficial());
        preparedStatement.executeUpdate();
    }
    public void deleteByCountryCode(String code) throws SQLException {
        preparedStatement = connection.prepareStatement(deleteByCountryCode);
        preparedStatement.setString(1,code);
        preparedStatement.executeUpdate();
    }

}
