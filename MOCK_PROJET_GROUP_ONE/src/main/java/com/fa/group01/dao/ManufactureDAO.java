/**
 * 
 */
package com.fa.group01.dao;

import java.sql.SQLException;

import com.fa.group01.entity.Manufacture;

/**
 * @author nguyenthanhlinh
 *
 */
public interface ManufactureDAO {
	
	/**
	 * @param manufacture
	 * @return
	 * @throws SQLException
	 */
	int save(Manufacture manufacture) throws SQLException;

}
