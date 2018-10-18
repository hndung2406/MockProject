/**
 * 
 */
package com.fa.group01.dao.statedao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fa.group01.connect.DatabaseConnect;
import com.fa.group01.constants.DbQuery;
import com.fa.group01.dao.statedao.StateDAO;
import com.fa.group01.entity.State;
import com.fa.group01.logging.DbLogging;

/**
 * @author nguyenthanhlinh
 *
 */
public class StateDAOImpl implements StateDAO {

	Connection connection = null;
	CallableStatement callableStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;

	/**
	 * Add state to the database
	 * 
	 * @param state
	 * @return
	 * @throws SQLException
	 */
	@Override
	public int addState(State state) {
		int affectedRow = 0;
		try {
			connection = DatabaseConnect.getInstance().getConnection();
			callableStatement = connection.prepareCall(DbQuery.INSERT_NEW_STATE);
			callableStatement.setString(1, state.getStateName());
			affectedRow = callableStatement.executeUpdate();
		} catch (SQLException e) {
			DbLogging.LOG.error("Error Database exception", e);
		} finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				DbLogging.LOG.error("Error Database exception", e);
			}
		}
		return affectedRow;
	}

	/**
	 * Find all state in the database
	 * 
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<State> findAll() {
		List<State> states = new ArrayList<>();
		State state = null;
		try {
			connection = DatabaseConnect.getInstance().getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(DbQuery.SELECT_ALL_STATE_QUERY);
			while (resultSet.next()) {
				state = new State();
				state.setStateId(resultSet.getInt("StateId"));
				state.setStateName(resultSet.getString("StateName"));
				states.add(state);
			}
		} catch (SQLException e) {
			DbLogging.LOG.error("Error Database Exception", e);

		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				DbLogging.LOG.error("Error Database Exception", e);
			}
		}
		return states;
	}

	/**
	 * Find the state with the incoming id
	 * 
	 * @param state
	 * @return
	 * @throws SQLException
	 */
	@Override
	public State findByID(State state) {
		try {
			connection = DatabaseConnect.getInstance().getConnection();
			callableStatement = connection.prepareCall(DbQuery.SELECT_STATE_BY_ID);
			callableStatement.setInt(1, state.getStateId());
			resultSet = callableStatement.executeQuery();
			while (resultSet.next()) {
				state.setStateName(resultSet.getString("StateName"));
			}
		} catch (SQLException e) {
			DbLogging.LOG.error("Error Database Exception", e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (callableStatement != null) {
					callableStatement.close();
				}
			} catch (SQLException e) {
				DbLogging.LOG.error("Error Database Exception", e);
			}
		}
		return state;
	}

}
