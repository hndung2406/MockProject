/**
 * 
 */
package com.fa.group01.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fa.group01.dao.statedao.StateDAO;
import com.fa.group01.entity.Country;
import com.fa.group01.entity.State;
import com.fa.group01.service.stateservice.impl.StateServiceImpl;

/**
 * @author DungHN2
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class StateServiceImplTest {

	@InjectMocks
	StateServiceImpl stateService;
	
	@Mock
	StateDAO stateDao;
	
	private static State state;
	private static List<State> states;
	private static List<State> emptyStates;
	
	static {
		state = new State(1, "IL");
		states = Arrays.asList(state);
		emptyStates = null;
	}
	
	@Test
	public void testAddStateSuccess() {
		Mockito.when(stateDao.addState(state)).thenReturn(1);
		assertEquals(1, stateService.addState(state));
		Mockito.verify(stateDao, Mockito.times(1)).addState(state);
	}
	
	@Test
	public void testAddStateFail() {
		Mockito.when(stateDao.addState(state)).thenReturn(0);
		assertEquals(0, stateService.addState(state));
		Mockito.verify(stateDao, Mockito.times(1)).addState(state);
	}
	
	@Test
	public void testFindAllState() {
		Mockito.when(stateDao.findAll()).thenReturn(states);
		assertEquals(1, stateService.findAll().size());
		Mockito.verify(stateDao).findAll();
	}
	
	@Test
	public void testFindAllStateReturnNull() {
		Mockito.when(stateDao.findAll()).thenReturn(emptyStates);
		assertNull(stateService.findAll());
		Mockito.verify(stateDao).findAll();
	}
	
	@Test
	public void testFindById() {
		Mockito.when(stateDao.findById(state)).thenReturn(state);
		assertEquals(state, stateService.findById(state));
		Mockito.verify(stateDao).findById(state);
	}
	
}
