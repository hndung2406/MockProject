package com.fa.group01.dao.userdao.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.fa.group01.dao.userdao.UserDAO;
import com.fa.group01.entity.User;
import com.fa.group01.utils.DateUtils;

public class UserDAOImplTest {

	private UserDAO userDAO;
	private User user;

	@Before
	public void setUp() throws Exception {
		userDAO = new UserDAOImpl();
		user = new User();
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	@Ignore
	public void CanRegisterANewUserHasNotExistedInDatabase() {
		user.setUserName("hoanglaminh21");
		user.setUserPassword("demo12");
		user.setUserEmail("hoang21@gmail.com");
		user.setUserFirstName("Nguyen");
		user.setUserLastName("Dinh Hoang");
		user.setUserCreateDate(new java.sql.Timestamp(DateUtils.getDate().getTime()));
		String message = userDAO.registerUser(user);
		assertEquals(message,"Update Successful");
	}
	
	@Test
	public void CanRegisterANewUserHasUsernameAlreadyExistInDatabase() {
		user.setUserName("hoanglaminh");
		user.setUserPassword("demo12");
		user.setUserEmail("hoang@gmail.com");
		user.setUserFirstName("Nguyen");
		user.setUserLastName("Dinh Hoang");
		user.setUserCreateDate(new java.sql.Timestamp(DateUtils.getDate().getTime()));
		String message = userDAO.registerUser(user);
		assertEquals(message,"Update fail");
	}
	
	@Test
	public void CanRegisterANewUserHasEmailAlreadyExistInDatabase() {
		user.setUserName("hoanglaminh21");
		user.setUserPassword("demo12");
		user.setUserEmail("hoang@gmail.com");
		user.setUserFirstName("Nguyen");
		user.setUserLastName("Dinh Hoang");
		user.setUserCreateDate(new java.sql.Timestamp(DateUtils.getDate().getTime()));
		String message = userDAO.registerUser(user);
		assertEquals(message,"Update fail");
	}

}
