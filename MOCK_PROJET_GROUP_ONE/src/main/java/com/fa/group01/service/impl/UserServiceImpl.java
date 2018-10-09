/**
 * 
 */
package com.fa.group01.service.impl;

import java.sql.SQLException;

import com.fa.group01.dao.UserDAO;
import com.fa.group01.service.UserService;

/**
 * @author nguyenthanhlinh
 *
 */
public class UserServiceImpl implements UserService {

	private  UserDAO userDAO;
	
	
	public UserServiceImpl(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}
	
	@Override
	public boolean isAuthenticated(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		return userDAO.isAuthenticatedUser(email, password);
	}

}
