/**
 * 
 */
package com.fa.group01.service.userservice.impl;

import java.sql.SQLException;
import java.util.Date;
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
	public String registerUser(User user) {
		return userDao.registerUser(user);
	}

	/**
	 * Get all the user from the database
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
	
	/**
	 * @param email
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	@Override
	public boolean isAuthenticated(String email, String password) {
		return userDao.isAuthenticatedUser(email, password);
	}
	
	/**
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	@Override
	public User fetchUserByEmail(String email) {
		return userDao.fetchUserByEmail(email);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public User setUser(User user, Date date, String role) {
		java.sql.Timestamp createdDate = new java.sql.Timestamp(date.getTime());
		user.setUserCreateDate(createdDate);
		user.setUserRole(role);
		return user;
	}
	
}
