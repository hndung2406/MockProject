/**
 * 
 */
package com.fa.group01.dao;

import java.sql.SQLException;

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
	public String registerUser(User user) throws SQLException;
	
}
