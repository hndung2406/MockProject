/**
 * 
 */
package com.fa.group01.service.countryservice;

import java.sql.SQLException;
import java.util.List;

import com.fa.group01.entity.Country;

/**
 * @author DungHN2
 *
 */
public interface CountryService {

	/**
	 * @param country
	 * @return
	 * @throws SQLException
	 */
	public int addCountry(Country country) throws SQLException;
	
	/**
	 * @return
	 * @throws SQLException
	 */
	public List<Country> findAll() throws SQLException;

	/**
	 * @param country
	 * @return
	 * @throws SQLException
	 */
	public Country findByID(Country country) throws SQLException;
	
}
