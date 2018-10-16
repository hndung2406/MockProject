/**
 * 
 */
package com.fa.group01.service.userservice;

import java.sql.SQLException;
import java.util.List;

import com.fa.group01.entity.User;

/**
 * @author nguyenthanhlinh
 *
 */
public interface UserService {

	/**
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public String registerUser(User user) throws SQLException;
	
	/**
	 * @return
	 * @throws SQLException
	 */
	public List<User> findAll() throws SQLException;
	
	/**
	 * @param email
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public boolean isAuthenticated (String email, String password) throws SQLException;
	
	/**
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public User fetchUserByEmail(String email) throws SQLException;
	
	/**
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int updateUser(User user) throws SQLException;
	
}
