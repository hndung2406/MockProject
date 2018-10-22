/**
 * 
 */
package com.fa.group01.service.userservice.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fa.group01.dao.userdao.UserDAO;
import com.fa.group01.entity.User;

/**
 * @author nguyenthanhlinh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	@InjectMocks
	UserServiceImpl userService;
	@Mock
	UserDAO userDao;
	
	private static User user;
	private static List<User> users;
	private static List<User> emptyUsers;
	private static String email;
	
	static {
		email = "email@gmail.com";
		user = new User(1, "UserName", "UserPassword", "email@gmail.com", "FisrtName", "LastName", "user", Timestamp.valueOf("1999-12-12 12:23:12"));
		users = Arrays.asList(user);
		emptyUsers = null;
	}
	
	@Test
	public void testRegisterSuccess() {
		Mockito.when(userDao.registerUser(user)).thenReturn("success");
		assertEquals("success", userService.registerUser(user));
		Mockito.verify(userDao).registerUser(user);
	}
	
	@Test
	public void testRegisterFail() {
		Mockito.when(userDao.registerUser(user)).thenReturn("fail");
		assertEquals("fail", userService.registerUser(user));
		Mockito.verify(userDao).registerUser(user);
	}
	
	@Test
	public void testFindAll() {
		Mockito.when(userDao.findAll()).thenReturn(users);
		assertEquals(users, userService.findAll());
		Mockito.verify(userDao).findAll();
	}
	
	@Test
	public void testFindAllReturnNull() {
		Mockito.when(userDao.findAll()).thenReturn(emptyUsers);
		assertNull(userService.findAll());
		Mockito.verify(userDao).findAll();
	}
	
	@Test
	public void testIsAuthenticatedSuccess() {
		Mockito.when(userDao.isAuthenticatedUser("email@gmail.com", "pass")).thenReturn(true);
		assertTrue(userService.isAuthenticated("email@gmail.com", "pass"));
		Mockito.verify(userDao).isAuthenticatedUser("email@gmail.com", "pass");
	}
	
	@Test
	public void testIsAuthenticatedFail() {
		Mockito.when(userDao.isAuthenticatedUser("email@gmail.com", "pass")).thenReturn(false);
		assertFalse(userService.isAuthenticated("email@gmail.com", "pass"));
		Mockito.verify(userDao).isAuthenticatedUser("email@gmail.com", "pass");
	}
	
	@Test
	public void testFetchUserByEmail() {
		Mockito.when(userDao.fetchUserByEmail(email)).thenReturn(user);
		assertEquals(user, userService.fetchUserByEmail(email));
		Mockito.verify(userDao).fetchUserByEmail(email);
	}
	
	@Test
	public void testUpdateUser() {
		Mockito.when(userDao.updateUser(user)).thenReturn(1);
		assertEquals(1, userService.updateUser(user));
		Mockito.verify(userDao).updateUser(user);
	}
	
	@Test
	public void testSetUser() {
		User userTest = new User();
		assertNotNull(userService.setUser(userTest,Timestamp.valueOf("1999-12-12 12:23:12"), "user"));
	}
}
