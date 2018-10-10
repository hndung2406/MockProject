/**
 * 
 */
package com.fa.group01.dao.manufacture.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
	/**
	 * Add manufacture to the database
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
			callableStatement.setString(1, manufacture.getName());
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
