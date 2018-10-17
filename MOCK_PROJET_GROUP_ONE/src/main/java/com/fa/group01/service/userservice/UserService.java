/**
 * 
 */
package com.fa.group01.service.userservice;

import java.sql.SQLException;
import java.util.Date;
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
	public String registerUser(User user);
	
	/**
	 * @return
	 * @throws SQLException
	 */
	public List<User> findAll();
	
	/**
	 * @param email
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public boolean isAuthenticated (String email, String password);
	
	/**
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public User fetchUserByEmail(String email);
	
	/**
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int updateUser(User user);
	
	/**
	 * @param user
	 * @param date
	 * @param role
	 * @return
	 */
	public User setUser(User user, Date date, String role);
	
}
