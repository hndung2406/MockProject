/**
 * 
 */
package com.fa.group01.service;

import java.sql.SQLException;

import com.fa.group01.entity.Manufacture;

/**
 * @author nguyenthanhlinh
 *
 */
public interface ManufactureService {
	
	/**
	 * @param manufacture
	 * @return
	 * @throws SQLException
	 */
	int save(Manufacture manufacture) throws SQLException;

}
