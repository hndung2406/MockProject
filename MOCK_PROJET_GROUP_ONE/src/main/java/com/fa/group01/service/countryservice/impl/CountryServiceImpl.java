/**
 * 
 */
package com.fa.group01.service.countryservice.impl;

import java.sql.SQLException;
import java.util.List;

import com.fa.group01.dao.countrydao.CountryDAO;
import com.fa.group01.entity.Country;
import com.fa.group01.service.countryservice.CountryService;

/**
 * @author DungHN2
 *
 */
public class CountryServiceImpl implements CountryService {

	private CountryDAO countryDao;

	public CountryServiceImpl(CountryDAO countryDao) {
		super();
		this.countryDao = countryDao;
	}

	/**
	 * Add country to the database
	 * 
	 * @param country
	 * @return
	 * @throws SQLException
	 */
	@Override
	public int addCountry(Country country) {
		return countryDao.addCountry(country);
	}

	/**
	 * Find all countries in the database
	 * 
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<Country> findAll() {
		return countryDao.findAll();
	}

	/**
	 * Find country by id
	 * 
	 * @param country
	 * @return
	 * @throws SQLException
	 */
	@Override
	public Country findById(Country country) {
		return countryDao.findById(country);
	}

}
