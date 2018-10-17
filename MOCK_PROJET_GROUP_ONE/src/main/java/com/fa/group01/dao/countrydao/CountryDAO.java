/**
 * 
 */
package com.fa.group01.dao.countrydao;

import java.sql.SQLException;
import java.util.List;

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
	public int addCountry(Country country);
	
	/**
	 * @return
	 * @throws SQLException
	 */
	public List<Country> findAll();
	
	/**
	 * @param country
	 * @return
	 * @throws SQLException
	 */
	public Country findById(Country country);
	
}
