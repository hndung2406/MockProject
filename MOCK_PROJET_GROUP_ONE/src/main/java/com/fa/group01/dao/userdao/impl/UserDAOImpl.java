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
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	@Override
	public String registerUser(User user) throws SQLException {
		int affectedRow = 0;
		String insertUserQuery = DbQuery.INSERT_NEW_USER_QUERY;
		connection = DatabaseConnect.getConnection();
		if(connection != null) {
			try {
				callabaleStatement = connection.prepareCall(insertUserQuery);
				callabaleStatement.setString(1, user.getUserName());
				callabaleStatement.setString(2, user.getUserPassword());
				callabaleStatement.setString(3, user.getUserEmail());
				callabaleStatement.setString(4, user.getUserFirstName());
				callabaleStatement.setString(5, user.getUserLastName());
				callabaleStatement.setString(6, user.getUserRole());
				callabaleStatement.setTimestamp(7, user.getUserCreateDate());
				affectedRow = callabaleStatement.executeUpdate();
				if(affectedRow > 0) {
					return "Update Successful";
				}
			} finally {
				if(connection != null) {
					connection.close();
				}
				if(callabaleStatement != null) {
					callabaleStatement.close();
				}
			}
		}
		return "Update fail";
	}

	/**
	 * Find all the user in the database
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<User> findAll() throws SQLException {
		List<User> users = new ArrayList<>();
		User user = null;
		String getUserQuery = DbQuery.SELECT_ALL_USER_QUERY;
		connection = DatabaseConnect.getConnection();
		if(connection != null) {
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(getUserQuery);
				while(resultSet.next()) {
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
		return users;
	}

	@Override
	public boolean isAuthenticatedUser(String email, String password) throws SQLException {
		
		connection = DatabaseConnect.getConnection();
		prepareStatement = connection.prepareStatement(DbQuery.SELECT_USER_BY_EMAIL_AND_PASSWORD);
		prepareStatement.setString(1, email);
		prepareStatement.setString(2, password);		
		ResultSet resultSet = prepareStatement.executeQuery();
		
//		while(resultSet.next()) {
//			resultSet.getInt("UserId");
//			resultSet.getString("UserName");
//			resultSet.getString("Password");
//			resultSet.getString("Email");
//			resultSet.getString("FirstName");
//		}
		
		return resultSet.next();
	}

	@Override
	public User fetchUserByEmail(String email) throws SQLException {
		User user = findAll().stream().filter(u->u.getUserEmail().equals(email)).findFirst().get();
		return user;
		
	}
}
