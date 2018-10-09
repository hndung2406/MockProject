/**
 * 
 */
package com.fa.group01.constants;

/**
 * @author nguyenthanhlinh
 *
 */
public class DbQuery {

	public interface ManufactureQuery{
		public static final String SAVE_NEW_MANUFACTURE = "INSERT INTO [Manufacture]([ManufactureName]) VALUES (?)";
	}
	
	public interface StateQuery{
		public static final String SAVE_NEW_STATE = "INSERT INTO [State]([StateName]) VALUES (?)";
	}
	
}
