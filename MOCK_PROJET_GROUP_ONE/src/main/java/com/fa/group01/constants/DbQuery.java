/**
 * 
 */
package com.fa.group01.constants;

/**
 * @author nguyenthanhlinh
 *
 */
public class DbQuery {

	//Queries for table User
	
	public static String SELECT_USER_BY_EMAIL_AND_PASSWORD = 
			"SELECT * FROM Users WHERE Email=? AND Password=?";
	
}
