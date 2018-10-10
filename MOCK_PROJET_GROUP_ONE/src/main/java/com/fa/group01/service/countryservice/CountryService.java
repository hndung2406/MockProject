/**
 * 
 */
package com.fa.group01.service.countryservice;

import java.sql.SQLException;

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
	
}
