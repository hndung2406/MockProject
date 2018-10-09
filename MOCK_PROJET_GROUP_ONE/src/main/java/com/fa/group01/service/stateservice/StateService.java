/**
 * 
 */
package com.fa.group01.service.stateservice;

import java.sql.SQLException;

import com.fa.group01.entity.State;

/**
 * @author nguyenthanhlinh
 *
 */
public interface StateService {

	/**
	 * @param state
	 * @return
	 * @throws SQLException
	 */
	int addState(State state) throws SQLException;

}
