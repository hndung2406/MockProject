/**
 * 
 */
package com.fa.group01.service.stateservice;

import java.sql.SQLException;
import java.util.List;

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
	public int addState(State state);

	/**
	 * @return
	 * @throws SQLException
	 */
	public List<State> findAll();

	/**
	 * @param state
	 * @return
	 * @throws SQLException
	 */
	public State findById(State state);

}
