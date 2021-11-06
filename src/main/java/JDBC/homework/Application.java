package JDBC.homework;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.SQLException;
import java.util.List;

public class Application {
    private static final Logger LOG = Logger.getLogger(Application.class);

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        DOMConfigurator.configure("loggerConfig.xml");
        CityDAO cityDao = new CityDAO(ConnectionUtils.openConnection());
        List<City> cities = cityDao.readAll();
        cities.forEach(System.out::println);
        City city = new City("AAA","ABW","BBB",5);
        cityDao.insertCity(city);
        city.setPopulation(100000);
        cityDao.updateCityPopulation(city);

        System.out.println(cityDao.readByName("AAA"));
        cityDao.deleteCityByName("AAA");

        CountryLanguageDAO countryLanguageDAO = new CountryLanguageDAO(ConnectionUtils.openConnection());
        List<CountryLanguage> countryLanguages = countryLanguageDAO.readAll();
        countryLanguages.forEach(System.out::println);
        countryLanguageDAO.insertCountryLanguage(new CountryLanguage("ABW","AAAAAA","T",100));

        CountryLanguage countryLanguage = new CountryLanguage("ABW", "Dutch", "T", 50.3);
        countryLanguageDAO.updateCountryLanguagePercentage(countryLanguage);
        System.out.println(countryLanguageDAO.readByCountryCode("ABW"));
        countryLanguageDAO.deleteByCountryCode("ABW");
    }
}
