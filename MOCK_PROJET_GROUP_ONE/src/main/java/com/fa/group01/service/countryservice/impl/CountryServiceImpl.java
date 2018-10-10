/**
 * 
 */
package com.fa.group01.service.countryservice.impl;

import java.sql.SQLException;

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
	 * add country
	 * @param country
	 * @return
	 * @throws SQLException
	 */
	public int addCountry(Country country) throws SQLException {
		return countryDao.addCountry(country);
	}
	
}
