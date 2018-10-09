/**
 * 
 */
package com.fa.group01.service;

import java.sql.SQLException;

/**
 * @author nguyenthanhlinh
 *
 */
public interface UserService {

	public boolean isAuthenticated (String email, String password) throws SQLException;
	
}
