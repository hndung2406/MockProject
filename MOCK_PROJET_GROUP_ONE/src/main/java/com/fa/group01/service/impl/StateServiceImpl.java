/**
 * 
 */
package com.fa.group01.service.impl;

import java.sql.SQLException;

import com.fa.group01.dao.StateDAO;
import com.fa.group01.dao.impl.StateDAOImpl;
import com.fa.group01.entity.State;
import com.fa.group01.service.StateService;

/**
 * @author nguyenthanhlinh
 *
 */
public class StateServiceImpl implements StateService {
	
	private StateDAO stateDAO;
	
	public StateServiceImpl() {
		this.stateDAO = new StateDAOImpl();
	}

	@Override
	public int save(State state) throws SQLException {
		return this.stateDAO.save(state);
	}

}
