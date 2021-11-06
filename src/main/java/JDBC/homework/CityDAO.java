package JDBC.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class CityDAO {
    private static final String readAll = "select * from city";
    private static final String insertCity = "insert into city(name, countrycode, district, population) values (?,?,?,?)";
    private static final String readByName = "select * from city where name = ?";
    private static final String updateCityPopulation = "update city set population = ? where name=?";
    private static final String deleteByName = "delete from city where name = ?";

    private final Connection connection;
    private PreparedStatement preparedStatement;
    Logger log = Logger.getLogger(CityDAO.class);

    public CityDAO(Connection connection) {
        this.connection = connection;
    }

    public List<City> readAll() throws SQLException {
        log.info("Reading all information from City table.");
        List<City> cities = new ArrayList<>();
        preparedStatement = connection.prepareStatement(readAll);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            cities.add(CityMapper.map(resultSet));
        }
        return cities;

    }

    public City readByName(String name) throws SQLException {
        log.info(String.format("Reading infromation from City table by name: %s", name));
        preparedStatement = connection.prepareStatement(readByName);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return CityMapper.map(resultSet);
    }

    public void insertCity(City city) throws SQLException {
        log.info(String.format("Inserting %s to City table.", city));
        preparedStatement = connection.prepareStatement(insertCity);
        preparedStatement.setString(1, city.getName());
        preparedStatement.setString(2, city.getCountryCode());
        preparedStatement.setString(3, city.getDistrict());
        preparedStatement.setInt(4, city.getPopulation());
        preparedStatement.executeUpdate();
    }

    public void updateCityPopulation(City city) throws SQLException {
        log.info(String.format("Updating City table with %s", city));
        preparedStatement = connection.prepareStatement(updateCityPopulation);
        preparedStatement.setInt(1,city.getPopulation());
        preparedStatement.setString(2,city.getName());
        preparedStatement.executeUpdate();
    }

    public void deleteCityByName(String name) throws SQLException {
        log.info(String.format("Deleting from city table by name: %s", name));
        preparedStatement = connection.prepareStatement(deleteByName);
        preparedStatement.setString(1,name);
        preparedStatement.executeUpdate();
    }

}
