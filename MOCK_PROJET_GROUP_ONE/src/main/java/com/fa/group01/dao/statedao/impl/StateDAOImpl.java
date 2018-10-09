/**
 * 
 */
package com.fa.group01.dao.statedao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fa.group01.connect.DatabaseConnect;
import com.fa.group01.constants.DbQuery;
import com.fa.group01.dao.statedao.StateDAO;
import com.fa.group01.entity.State;

/**
 * @author nguyenthanhlinh
 *
 */
public class StateDAOImpl implements StateDAO {

	Connection connection = null;
	CallableStatement callableStatement = null;
	
	/**
	 * Add state to the database
	 * @param state
	 * @return
	 * @throws SQLException
	 */
	@Override
	public int addState(State state) throws SQLException {
		connection = DatabaseConnect.getConnection();
		int affectedRow = 0;
		try {
			callableStatement = connection.prepareCall(DbQuery.INSERT_NEW_STATE);
			callableStatement.setString(1, state.getStateName());
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
