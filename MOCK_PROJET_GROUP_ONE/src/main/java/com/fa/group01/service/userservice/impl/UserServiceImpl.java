/**
 * 
 */
package com.fa.group01.service.userservice.impl;

import java.sql.SQLException;
import java.util.List;

import com.fa.group01.dao.userdao.UserDAO;
import com.fa.group01.entity.User;
import com.fa.group01.service.userservice.UserService;

/**
 * @author nguyenthanhlinh
 *
 */
public class UserServiceImpl implements UserService {

	private UserDAO userDao;

	public UserServiceImpl(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}

	/**
	 * Save the register user to the database
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	@Override
	public String registerUser(User user) throws SQLException {
		return userDao.registerUser(user);
	}

	/**
	 * Get all the user from the database
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<User> findAll() throws SQLException {
		return userDao.findAll();
	}
	
}
