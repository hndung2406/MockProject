/**
 * 
 */
package com.fa.group01.entity;

import java.io.Serializable;

/**
 * @author DungHN2
 *
 */
public class State implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7901983893355022112L;
	private int stateId;
	private String stateName;

	public State(int stateId, String stateName) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
	}

	public State() {

	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", stateName=" + stateName + "]";
	}

}