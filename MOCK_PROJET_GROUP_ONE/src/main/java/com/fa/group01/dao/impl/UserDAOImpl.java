/**
 * 
 */
package com.fa.group01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fa.group01.connect.DatabaseConnect;
import com.fa.group01.constants.DbQuery;
import com.fa.group01.dao.UserDAO;
import com.fa.group01.entity.User;

/**
 * @author nguyenthanhlinh
 *
 */
public class UserDAOImpl implements UserDAO {

	private Connection connection = null;
	private PreparedStatement prepareStatement = null;

	@Override
	public boolean isAuthenticatedUser(String email, String password) throws SQLException {
		
		connection = DatabaseConnect.getConnection();
		prepareStatement = connection.prepareStatement(DbQuery.SELECT_USER_BY_EMAIL_AND_PASSWORD);
		prepareStatement.setString(1, email);
		prepareStatement.setString(2, password);		
		ResultSet resultSet = prepareStatement.executeQuery();
		
		while(resultSet.next()) {
			resultSet.getInt("UserId");
			resultSet.getString("UserName");
			resultSet.getString("Password");
			resultSet.getString("Email");
			resultSet.getString("FirstName");
		}
		
		return resultSet.next();
	}

	@Override
	public boolean fetchUserByEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
