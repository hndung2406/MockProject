package com.fa.group01.dao.impl;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.fa.group01.dao.UserDAO;

public class UserDAOImplTest {

	private UserDAO userDAO;
	
	@Before
	public void setUp() throws Exception {
		
		userDAO = new UserDAOImpl();
		
	}

	@Test
	public void IsUserAuthenticated() {
		try {
			boolean isAuthenticated = userDAO.isAuthenticatedUser("group01@domain.com", "Hoangday@7589");
			assertTrue(isAuthenticated);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
