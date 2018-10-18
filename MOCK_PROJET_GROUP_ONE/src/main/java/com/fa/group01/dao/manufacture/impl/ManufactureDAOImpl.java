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
import com.fa.group01.logging.DbLogging;

/**
 * @author nguyenthanhlinh
 *
 */
public class ManufactureDAOImpl implements ManufactureDAO {

	private Connection connection = null;
	private CallableStatement callableStatement = null;
	private PreparedStatement prepareStatement = null;
	private ResultSet resultSet = null;

	/**
	 * Add manufacture to the database
	 * 
	 * @param manufacture
	 * @return
	 * @throws SQLException
	 */
	@Override
	public int addManufacture(Manufacture manufacture) {
		int affectedRow = 0;
		try {
			connection = DatabaseConnect.getInstance().getConnection();
			callableStatement = connection.prepareCall(DbQuery.INSERT_NEW_MANUFACTURE);
			callableStatement.setString(1, manufacture.getManufactureName());
			affectedRow = callableStatement.executeUpdate();
		} catch (SQLException e) {
			DbLogging.LOG.error("Error Database exception");
		} finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				DbLogging.LOG.error("Error Database exception");
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
	public List<Manufacture> findAll() {
		List<Manufacture> listManufacture = new ArrayList<>();
		try {
			connection = DatabaseConnect.getInstance().getConnection();
			prepareStatement = connection.prepareStatement(DbQuery.SELECT_ALL_MANUFACTURE_QUERY);
			resultSet = prepareStatement.executeQuery();
			Manufacture manufacture = null;
			while (resultSet.next()) {
				manufacture = new Manufacture();
				manufacture.setManufactureId(resultSet.getInt("ManufactureId"));
				manufacture.setManufactureName(resultSet.getString("ManufactureName"));
				listManufacture.add(manufacture);
			}
		} catch (SQLException e) {
			DbLogging.LOG.error("Error Database exception");
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				DbLogging.LOG.error("Error Database exception");
			}
		}
		return listManufacture;
	}

	@Override
	public Manufacture findById(int id) {
		Manufacture manufacture = null;
		if (connection != null) {
			try {
				connection = DatabaseConnect.getInstance().getConnection();
				prepareStatement = connection.prepareStatement(DbQuery.SELECT_MANUFACTURE_BY_ID);
				prepareStatement.setInt(1, id);
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					manufacture = new Manufacture();
					manufacture.setManufactureId(resultSet.getInt("ManufactureId"));
					manufacture.setManufactureName(resultSet.getString("ManufactureName"));
				}
			} catch (SQLException e) {
				DbLogging.LOG.error("Error Database exception", e);
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (prepareStatement != null) {
						prepareStatement.close();
					}
					if (resultSet != null) {
						resultSet.close();
					}
				} catch (SQLException e) {
					DbLogging.LOG.error("Error Database exception", e);
				}
			}
		}
		return manufacture;
	}

}
