/**
 * 
 */
package com.fa.group01.dao.countrydao;

import java.sql.SQLException;

import com.fa.group01.entity.Country;

/**
 * @author DungHN2
 *
 */
public interface CountryDAO {

	/**
	 * @param country
	 * @return
	 * @throws SQLException
	 */
	int addCountry(Country country) throws SQLException;
	
}
