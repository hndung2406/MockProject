/**
 * 
 */
package com.fa.group01.action;

import java.sql.SQLException;

import com.fa.group01.constants.PagesConstants;
import com.fa.group01.entity.State;
import com.fa.group01.logging.DbLogging;
import com.fa.group01.service.StateService;
import com.fa.group01.service.impl.StateServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author nguyenthanhlinh
 *
 */
public class StateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StateService stateService;
	private State state;
	private String message;
	
	public StateAction() {
		this.stateService = new StateServiceImpl();
	}
	
	public String addState() {
		int isAddSuccess = 0;
		
		try {
			isAddSuccess = this.stateService.save(state);
		} catch (SQLException e) {
			DbLogging.LOGGER.error("SQLException", e);
		}
		if (isAddSuccess > 0) {
			this.message = "Add Success!!";
			return PagesConstants.SUCCESS;
		}
		this.message = "Add Fail!!!";
		return PagesConstants.ERROR;
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
