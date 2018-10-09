/**
 * 
 */
package com.fa.group01.constants;

/**
 * @author nguyenthanhlinh
 *
 */
public class DbQuery {

	public static final String INSERT_USER_QUERY = "INSERT INTO [Users] (UserName, Password, Email, FirstName, LastName, Role, CreateDate) VALUES (?,?,?,?,?,?,?)";
	public static final String GET_ALL_USER_QUERY = "SELECT * FROM [Users]";
	
}
