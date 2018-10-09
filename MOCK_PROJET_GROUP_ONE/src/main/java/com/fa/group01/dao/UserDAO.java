/**
 * 
 */
package com.fa.group01.dao;

import java.sql.SQLException;

/**
 * @author nguyenthanhlinh
 *
 */
public interface UserDAO {
	
	public boolean isAuthenticatedUser(String email, String password) throws SQLException;
	
	public boolean fetchUserByEmail(String email);
}
