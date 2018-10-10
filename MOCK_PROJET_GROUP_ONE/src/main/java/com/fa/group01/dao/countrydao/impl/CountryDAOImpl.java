/**
 * 
 */
package com.fa.group01.dao.countrydao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.fa.group01.connect.DatabaseConnect;
import com.fa.group01.constants.DbQuery;
import com.fa.group01.dao.countrydao.CountryDAO;
import com.fa.group01.entity.Country;

/**
 * @author DungHN2
 *
 */
public class CountryDAOImpl implements CountryDAO {

	Connection connection = null;
	CallableStatement callableStatement = null;
	
	/**
	 * Add country to the database
	 * @param state
	 * @return
	 * @throws SQLException
	 */
	@Override
	public int addCountry(Country country) throws SQLException {
		connection = DatabaseConnect.getConnection();
		int affectedRow = 0;
		try {
			callableStatement = connection.prepareCall(DbQuery.INSERT_NEW_COUNTRY);
			callableStatement.setString(1, country.getCountryName());
			affectedRow = callableStatement.executeUpdate();
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return affectedRow;
	}

}
