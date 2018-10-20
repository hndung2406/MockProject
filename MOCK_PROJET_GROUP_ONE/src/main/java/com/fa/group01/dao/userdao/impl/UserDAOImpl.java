/**
 * 
 */
package com.fa.group01.dao.userdao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fa.group01.connect.DatabaseConnect;
import com.fa.group01.constants.DbQuery;
import com.fa.group01.dao.userdao.UserDAO;
import com.fa.group01.entity.User;
import com.fa.group01.logging.DbLogging;

/**
 * @author nguyenthanhlinh
 *
 */
public class UserDAOImpl implements UserDAO {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	CallableStatement callabaleStatement = null;
	PreparedStatement prepareStatement = null;

	/**
	 * Save the register user to the database;
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	@Override
	public String registerUser(User user) {
		int affectedRow = 0;
		String insertUserQuery = DbQuery.INSERT_NEW_USER_QUERY;
		try {
			connection = DatabaseConnect.getInstance().getConnection();
			callabaleStatement = connection.prepareCall(insertUserQuery);
			callabaleStatement.setString(1, user.getUserName());
			callabaleStatement.setString(2, user.getUserPassword());
			callabaleStatement.setString(3, user.getUserEmail());
			callabaleStatement.setString(4, user.getUserFirstName());
			callabaleStatement.setString(5, user.getUserLastName());
			callabaleStatement.setString(6, user.getUserRole());
			callabaleStatement.setTimestamp(7, user.getUserCreateDate());
			affectedRow = callabaleStatement.executeUpdate();
			if (affectedRow > 0) {
				return "Update Successful";
			}
		} catch (SQLException e) {
			DbLogging.LOG.error(this.getClass() + "Error Database exception", e);
		} finally {
			try {
				DatabaseConnect.getInstance().close(callabaleStatement);
				DatabaseConnect.getInstance().close(connection);
			} catch (SQLException e) {
				DbLogging.LOG.error(this.getClass() + "- Error Database exception", e);
			}
		}
		return "Update fail";
	}

	/**
	 * Find all the user in the database
	 * 
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		User user = null;
		String getUserQuery = DbQuery.SELECT_ALL_USER_QUERY;
		try {
			connection = DatabaseConnect.getInstance().getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(getUserQuery);
			while (resultSet.next()) {
				user = new User();
				user.setUserId(resultSet.getInt("UserId"));
				user.setUserName(resultSet.getString("UserName"));
				user.setUserPassword(resultSet.getString("Password"));
				user.setUserEmail(resultSet.getString("Email"));
				user.setUserFirstName(resultSet.getString("FirstName"));
				user.setUserLastName(resultSet.getString("LastName"));
				user.setUserRole(resultSet.getString("Role"));
				user.setUserCreateDate(resultSet.getTimestamp("CreateDate"));
				users.add(user);
			}
		} catch (SQLException e) {
			DbLogging.LOG.error("Error Database exception", e);
		} finally {
			try {
				DatabaseConnect.getInstance().close(statement);
				DatabaseConnect.getInstance().close(resultSet);
				DatabaseConnect.getInstance().close(connection);
			} catch (Exception e) {
				DbLogging.LOG.error(this.getClass() + "- Error Database exception", e);
			}
		}
		return users;
	}

	@Override
	public boolean isAuthenticatedUser(String email, String password) {
		boolean isAuthenticated = false;
		try {
			connection = DatabaseConnect.getInstance().getConnection();
			prepareStatement = connection.prepareStatement(DbQuery.SELECT_USER_BY_EMAIL_AND_PASSWORD);
			prepareStatement.setString(1, email);
			prepareStatement.setString(2, password);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				isAuthenticated = true;
			}
		} catch (SQLException e) {
			DbLogging.LOG.error("Erro Database exception", e);
		} finally {
			try {
				DatabaseConnect.getInstance().close(prepareStatement);
				DatabaseConnect.getInstance().close(resultSet);
				DatabaseConnect.getInstance().close(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				DbLogging.LOG.error(this.getClass() + "- Error Database exception", e);
			}
		}
		return isAuthenticated;
	}

	@Override
	public User fetchUserByEmail(String email) {
		User user = findAll().stream().filter(u -> u.getUserEmail().equals(email)).findFirst().get();
		return user;

	}

	@Override
	public int updateUser(User user) {
		int affectedRow = 0;
		try {
			connection = DatabaseConnect.getInstance().getConnection();
			callabaleStatement = connection.prepareCall(DbQuery.UPDATE_USER);
			callabaleStatement.setString(1, user.getUserName());
			callabaleStatement.setString(2, user.getUserPassword());
			callabaleStatement.setString(3, user.getUserFirstName());
			callabaleStatement.setString(4, user.getUserLastName());
			callabaleStatement.setInt(5, user.getUserId());
			affectedRow = callabaleStatement.executeUpdate();
		} catch (SQLException e) {
			DbLogging.LOG.error("Error Database exception", e);
		} finally {
			try {
				DatabaseConnect.getInstance().close(callabaleStatement);
				DatabaseConnect.getInstance().close(connection);
			} catch (SQLException e) {
				DbLogging.LOG.error(this.getClass() + "- Error Database exception", e);
			}
		}
		return affectedRow;
	}

}
