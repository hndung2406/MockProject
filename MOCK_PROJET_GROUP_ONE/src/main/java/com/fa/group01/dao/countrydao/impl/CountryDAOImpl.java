/**
 * 
 */
package com.fa.group01.dao.countrydao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	Statement statement = null;
	ResultSet resultSet = null;
	
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

	/**
	 * Find all country in the database
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<Country> findAll() throws SQLException {
		List<Country> countries = new ArrayList<>();
		Country country = null;
		connection = DatabaseConnect.getConnection();
		if(connection != null) {
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(DbQuery.SELECT_ALL_COUNTRY_QUERY);
				while(resultSet.next()) {
					country = new Country();
					country.setCountryId(resultSet.getInt("CountryId"));
					country.setCountryName(resultSet.getString("CountryName"));
					countries.add(country);
				}
			} finally {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
			}
		}
		return countries;
	}

	/**
	 * Find country by id
	 * @param country
	 * @return
	 * @throws SQLException
	 */
	@Override
	public Country findById(Country country) throws SQLException {
		connection = DatabaseConnect.getConnection();
		if(connection != null) {
			try {
				callableStatement = connection.prepareCall(DbQuery.SELECT_COUNTRY_BY_ID);
				callableStatement.setInt(1, country.getCountryId());
				resultSet = callableStatement.executeQuery();
				while(resultSet.next()) {
					country.setCountryName(resultSet.getString("CountryName"));
				}
			} finally {
				if(connection != null) {
					connection.close();
				}
				if(callableStatement != null) {
					callableStatement.close();
				}
			}
		}
		return country;
	}

}
