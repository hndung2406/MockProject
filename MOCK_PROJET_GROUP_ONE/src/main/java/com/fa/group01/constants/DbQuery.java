/**
 * 
 */
package com.fa.group01.constants;

/**
 * @author nguyenthanhlinh
 *
 */
public class DbQuery {

	public static final String INSERT_NEW_MANUFACTURE = "INSERT INTO [Manufacture]([ManufactureName]) VALUES (?)";
	public static final String FIND_ALL_MANUFACTURE = "SELECT * FROM [Manufacture]";
	public static final String INSERT_NEW_STATE = "INSERT INTO [State]([StateName]) VALUES (?)";
	public static final String INSERT_NEW_COUNTRY = "INSERT INTO [Country]([CountryName]) VALUES (?)";
	public static final String INSERT_USER_QUERY = "INSERT INTO [Users] (UserName, Password, Email, FirstName, LastName, Role, CreateDate) VALUES (?,?,?,?,?,?,?)";
	public static final String SELECT_ALL_USER_QUERY = "SELECT * FROM [Users]";
	public static final String SELECT_USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM Users WHERE Email=? AND Password=?";
	public static final String INSERT_NEW_PRODUCT = "INSERT INTO [Product]([ProductId], [ProductName], [ProductPrice], [Description], [Image], [Quantity], [Condition], [DateOfManufacture], [Spec], [Properties], [ManufactureId]) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
}
