/**
 * 
 */
package com.fa.group01.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fa.group01.dao.countrydao.CountryDAO;
import com.fa.group01.entity.Country;
import com.fa.group01.service.countryservice.impl.CountryServiceImpl;

/**
 * @author DungHN2
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CountryServiceImplTest {

	@InjectMocks
	CountryServiceImpl countryService;
	
	@Mock
	CountryDAO countryDao;
	
	private static Country country;
	private static List<Country> countries;
	private static List<Country> emptyCountries;
	
	static {
		country = new Country(1, "USA");
		countries = Arrays.asList(country);
		emptyCountries = null;
	}
	
	@Test
	public void testAddCountrySuccess() {
		Mockito.when(countryDao.addCountry(country)).thenReturn(1);
		assertEquals(1, countryService.addCountry(country));
		Mockito.verify(countryDao, Mockito.times(1)).addCountry(country);
	}
	
	@Test
	public void testAddCountryFail() {
		Mockito.when(countryDao.addCountry(country)).thenReturn(0);
		assertEquals(0, countryService.addCountry(country));
		Mockito.verify(countryDao, Mockito.times(1)).addCountry(country);
	}
	
	@Test
	public void testFindAllCountry() {
		Mockito.when(countryDao.findAll()).thenReturn(countries);
		assertEquals(1, countryService.findAll().size());
		Mockito.verify(countryDao).findAll();
	}
	
	@Test
	public void testFindAllCountryReturnNull() {
		Mockito.when(countryDao.findAll()).thenReturn(emptyCountries);
		assertNull(countryService.findAll());
		Mockito.verify(countryDao).findAll();
	}
	
	@Test
	public void testFindById() {
		Mockito.when(countryDao.findById(country)).thenReturn(country);
		assertEquals(country, countryService.findById(country));
		Mockito.verify(countryDao).findById(country);
	}
	
}
