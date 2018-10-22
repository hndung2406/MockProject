/**
 * 
 */
package com.fa.group01.service.stateservice.impl;

import java.util.List;

import com.fa.group01.dao.statedao.StateDAO;
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
	public int addState(State state) {
		return stateDao.addState(state);
	}

	@Override
	public List<State> findAll() {
		return stateDao.findAll();
	}

	@Override
	public State findById(State state) {
		return stateDao.findById(state);
	}

}
