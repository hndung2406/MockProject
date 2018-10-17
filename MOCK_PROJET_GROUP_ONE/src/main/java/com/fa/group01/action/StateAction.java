/**
 * 
 */
package com.fa.group01.action;

import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.statedao.StateDAO;
import com.fa.group01.dao.statedao.impl.StateDAOImpl;
import com.fa.group01.entity.State;
import com.fa.group01.service.stateservice.StateService;
import com.fa.group01.service.stateservice.impl.StateServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * @author nguyenthanhlinh
 *
 */
public class StateAction extends ActionSupport implements Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StateService stateService;
	private StateDAO stateDao;
	private State state;
	private String message;
	
	@Override
	public void prepare() throws Exception {
		stateDao = new StateDAOImpl();
		stateService = new StateServiceImpl(stateDao);
	}
	
	public String addState() {
		int isAddSuccess = stateService.addState(state);
		if (isAddSuccess > 0) {
			this.message = "Add Success!";
			return PageConstant.SUCCESS;
		} else {
			this.message = "Add Fail!";
			return PageConstant.ERROR;
		}
	}

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
