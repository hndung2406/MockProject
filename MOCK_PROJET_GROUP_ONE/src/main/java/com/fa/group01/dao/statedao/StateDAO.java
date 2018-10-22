/**
 * 
 */
package com.fa.group01.dao.statedao;

import java.sql.SQLException;
import java.util.List;

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
