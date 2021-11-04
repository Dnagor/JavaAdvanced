package JDBC.homework;

import JDBC.lecture.Employee;

import java.sql.SQLException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

    CityDAO cityDao = new CityDAO(ConnectionUtils.openConnection());
    List<City> cities = cityDao.readAll();
        cities.forEach(System.out::println);
        System.out.println(cityDao.readByName("Lviv"));
    System.out.println("\n");
    City city = new City("AAA","AAAAAA","BBB",10000);
        cityDao.insertCity(city);

        city.setPopulation(100000);
        cityDao.updateCityPopulation(city);

        cityDao.deleteCityByName("AAA");

    CountryLanguageDAO countryLanguageDAO = new CountryLanguageDAO(ConnectionUtils.openConnection());
        List<CountryLanguage> countryLanguages = countryLanguageDAO.readAll();
        countryLanguages.forEach(System.out::println);
        countryLanguageDAO.insertCountryLanguage(new CountryLanguage("ABW","AAAAAA","T",100));

        countryLanguageDAO.deleteByCountryCode("ABW");
    CountryLanguage countryLanguage = new CountryLanguage("ABW", "Dutch", "T", 50.3);
        countryLanguageDAO.updateCountryLanguagePercentage(countryLanguage);
        System.out.println(countryLanguageDAO.readByCountryCode("ABW"));
        countryLanguageDAO.deleteByCountryCode("ABW");
    }
}
