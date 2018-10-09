/**
 * 
 */
package com.fa.group01.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fa.group01.connect.DatabaseConnect;
import com.fa.group01.constants.DbQuery;
import com.fa.group01.dao.UserDAO;
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

	/**
	 * Save the register user to the database;
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	@Override
	public String registerUser(User user) throws SQLException {
		int affectedRow = 0;
		String insertUserQuery = DbQuery.INSERT_USER_QUERY;
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
				callabaleStatement.setDate(6, user.getUserCreateDate());
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

}
