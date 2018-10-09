/**
 * 
 */
package com.fa.group01.dao;

import java.sql.SQLException;

import com.fa.group01.entity.State;

/**
 * @author nguyenthanhlinh
 *
 */
public interface StateDAO {
	
	/**
	 * @param state
	 * @return
	 * @throws SQLException
	 */
	int save(State state) throws SQLException;

}
