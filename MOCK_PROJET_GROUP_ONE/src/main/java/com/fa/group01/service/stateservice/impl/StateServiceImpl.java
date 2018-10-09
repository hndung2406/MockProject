/**
 * 
 */
package com.fa.group01.service.stateservice.impl;

import java.sql.SQLException;

import com.fa.group01.dao.statedao.StateDAO;
import com.fa.group01.dao.statedao.impl.StateDAOImpl;
import com.fa.group01.entity.State;
import com.fa.group01.service.stateservice.StateService;

/**
 * @author nguyenthanhlinh
 *
 */
public class StateServiceImpl implements StateService {

	private StateDAO stateDao;

	public StateServiceImpl(StateDAO stateDao) {
		this.stateDao = stateDao;
	}

	@Override
	public int addState(State state) throws SQLException {
		return stateDao.addState(state);
	}

}
