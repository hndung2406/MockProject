/**
 * 
 */
package com.fa.group01.service;

import java.sql.SQLException;

import com.fa.group01.entity.User;

/**
 * @author nguyenthanhlinh
 *
 */
public interface UserService {

	public String registerUser(User user) throws SQLException;
	
}
