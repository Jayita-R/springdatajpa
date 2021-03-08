package com.cognizant.ormlearn;
import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) throws CountryNotFoundException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		countryService = context.getBean(CountryService.class);
		Country country = context.getBean(Country.class);
		//testGetAllCountries();
		//getAllCountriesTest();
		
		//testAddCountry(country);
		//testGetAllCountries();
		//testUpdateCountry();
		//testDeleteCountry();
		//testGetAllCountries();
		//testSearchByPlaceHolder();
		//testNameStartWith();
		testSortCountry();
		
		
		
		
	}
	private static void testGetAllCountries() {

		LOGGER.info("Start");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");

		}
	private static void getAllCountriesTest() throws CountryNotFoundException {

		LOGGER.info("Start");

		Country country = countryService.findCountryByCode("IN");

		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");

		}
	private static void testAddCountry(Country country) {
		LOGGER.info("start");
		country.setCode("ZZ");
		country.setName("Kolkata");
		countryService.addCountry(country);
		LOGGER.info("end");
	}
	private static void testUpdateCountry() {
		LOGGER.info("start");
		countryService.updateCountry("US", "United States");
		LOGGER.info("end");
	}
	private static void testDeleteCountry() {
		LOGGER.info("start");
		countryService.deleteCountry("ZZ");
		LOGGER.info("end");
    }
	private static void testSearchByPlaceHolder() {
		
		LOGGER.info("start");
		List<Country> countries = countryService.searchByPlaceHolder("di");
		LOGGER.debug("countries={}", countries);
		LOGGER.info("end");
	}
	private static void testNameStartWith() {
		LOGGER.info("start");
		List<Country> countries = countryService.searchByStartingLetter("I");
		LOGGER.debug("countries={}", countries);
		LOGGER.info("end");
	}
	private static void testSortCountry() {
		LOGGER.info("start");
		List<Country> countries = countryService.searchByStartingLetter("Ind");
		LOGGER.debug("countries={}", countries);
		LOGGER.info("end");
	}

}
