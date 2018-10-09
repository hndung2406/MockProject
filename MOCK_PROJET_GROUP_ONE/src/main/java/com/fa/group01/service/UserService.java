/**
 * 
 */
package com.fa.group01.service;

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
}
