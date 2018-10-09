/**
 * 
 */
package com.fa.group01.constants;

/**
 * @author nguyenthanhlinh
 *
 */
public class DbQuery {

	public static final String SAVE_NEW_MANUFACTURE = "INSERT INTO [Manufacture]([ManufactureName]) VALUES (?)";
	public static final String SAVE_NEW_STATE = "INSERT INTO [State]([StateName]) VALUES (?)";
	public static final String INSERT_USER_QUERY = "INSERT INTO [Users] (UserName, Password, Email, FirstName, LastName, Role, CreateDate) VALUES (?,?,?,?,?,?,?)";
	public static final String GET_ALL_USER_QUERY = "SELECT * FROM [Users]";

}
