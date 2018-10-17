/**
 * 
 */
package com.fa.group01.dao.userdao;

import java.sql.SQLException;
import java.util.List;

import com.fa.group01.entity.User;

/**
 * @author nguyenthanhlinh
 *
 */
public interface UserDAO {

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
	public boolean isAuthenticatedUser(String email, String password);
	
	/**
	 * @param email
	 * @return
	 */
	public User fetchUserByEmail(String email);
	
	/**
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int updateUser(User user);
	
}
