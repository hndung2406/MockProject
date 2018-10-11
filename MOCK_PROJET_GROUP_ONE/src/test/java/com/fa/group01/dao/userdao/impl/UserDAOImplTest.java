package com.fa.group01.dao.userdao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.fa.group01.dao.userdao.UserDAO;
import com.fa.group01.entity.User;

public class UserDAOImplTest {

	private UserDAO userDAO;
	
	@Before
	public void setUp() throws Exception {
		userDAO = new UserDAOImpl();
	}

	@Test
	public void CanGetUserByEmail() throws SQLException {
		User user = userDAO.fetchUserByEmail("hoang@domain.com");
		assertNotEquals(user,null);
	}

}
