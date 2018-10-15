/**
 * 
 */
package com.fa.group01.dao.manufacture.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fa.group01.connect.DatabaseConnect;
import com.fa.group01.constants.DbQuery;
import com.fa.group01.dao.manufacture.ManufactureDAO;
import com.fa.group01.entity.Manufacture;

/**
 * @author nguyenthanhlinh
 *
 */
public class ManufactureDAOImpl implements ManufactureDAO {

	Connection connection = null;
	CallableStatement callableStatement = null;
	PreparedStatement prepareStatement = null;
	ResultSet resultSet = null;

	/**
	 * Add manufacture to the database
	 * 
	 * @param manufacture
	 * @return
	 * @throws SQLException
	 */
	@Override
	public int addManufacture(Manufacture manufacture) throws SQLException {
		connection = DatabaseConnect.getConnection();
		int affectedRow = 0;
		try {
			callableStatement = connection.prepareCall(DbQuery.INSERT_NEW_MANUFACTURE);
			callableStatement.setString(1, manufacture.getManufactureName());
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
	 * Find All Manufacture
	 * 
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<Manufacture> findAll() throws SQLException {
		List<Manufacture> listManufacture = new ArrayList<>();

		try {
			connection = DatabaseConnect.getConnection();
			prepareStatement = connection.prepareStatement(DbQuery.SELECT_ALL_MANUFACTURE_QUERY);
			resultSet = prepareStatement.executeQuery();
			Manufacture manufacture = null;
			while (resultSet.next()) {
				manufacture = new Manufacture();
				manufacture.setManufactureId(resultSet.getInt("ManufactureId"));
				manufacture.setManufactureName(resultSet.getString("ManufactureName"));
				listManufacture.add(manufacture);
			}
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (prepareStatement != null) {
				prepareStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return listManufacture;
	}

	@Override
	public Manufacture findById(int manufactureId) throws SQLException {
		Manufacture manufacture = null;
		try {
			connection = DatabaseConnect.getConnection();
			prepareStatement = connection.prepareStatement(DbQuery.SELECT_MANUFACTURE_BY_ID);
			prepareStatement.setInt(1, manufactureId);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				manufacture = new Manufacture();
				manufacture.setManufactureId(resultSet.getInt("ManufactureId"));
				manufacture.setManufactureName(resultSet.getString("ManufactureName"));
			}
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (prepareStatement != null) {
				prepareStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return manufacture;
	}

}
