/**
 * 
 */
package com.fa.group01.dao.countrydao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fa.group01.dao.countrydao.CountryDAO;
import com.fa.group01.entity.Country;

/**
 * @author DungHN2
 *
 */
public class CountryDaoImplTest {

	private CountryDAO countryDao;
	private Country country;

	@Before
	public void setUp() throws Exception {
		countryDao = new CountryDAOImpl();
		country = new Country();
	}
	
	@Test
	public void addCountryAlreadyInDatabase() {
		country = new Country(1, "Vietnam");
		int result = countryDao.addCountry(country);
		assertEquals(0, result);
	}
	
	@Test
	public void addCountryNotInDatabase() {
		country = new Country();
		country.setCountryName("Brazil");
		int result = countryDao.addCountry(country);
		assertEquals(1, result);
	}
	
	@Test
	public void findAll() {
		List<Country> countries = countryDao.findAll();
		assertEquals(2, countries.size());
	}
	
	@Test
	public void findById() {
		Country countryTest = new Country();
		countryTest.setCountryId(1);
		country = countryDao.findById(countryTest);
		assertEquals(country, countryTest);
	}
	
}
