/**
 * 
 */
package com.fa.group01.dao.statedao.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fa.group01.dao.statedao.StateDAO;
import com.fa.group01.entity.State;

/**
 * @author DungHN2
 *
 */
public class StateDaoImplTest {

	private StateDAO stateDao;
	private State state;
	
	@Before
	public void setUp() throws Exception {
		stateDao = new StateDAOImpl();
		state = new State();
	}
	
	@Test
	public void addStateAlreadyInDatabase() {
		state = new State(1, "IL");
		int result = stateDao.addState(state);
		assertEquals(0, result);
	}
	
	@Test
	public void addStateNotInDatabase() {
		state = new State();
		state.setStateName("BA");
		int result = stateDao.addState(state);
		assertEquals(1, result);
	}
	
	@Test
	public void findAll() {
		List<State> states = stateDao.findAll();
		assertEquals(2, states.size());
	}
	
	@Test
	public void findById() {
		State stateTest = new State();
		stateTest.setStateId(1);
		state = stateDao.findById(stateTest);
		assertEquals(state, stateTest);
	}
	
}
