/**
 * 
 */
package com.fa.group01.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.UserDAO;
import com.fa.group01.dao.impl.UserDAOImpl;
import com.fa.group01.entity.User;
import com.fa.group01.logging.DbLogging;
import com.fa.group01.service.UserService;
import com.fa.group01.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author DungHN2
 *
 */
public class ReportAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6726901906485612157L;
	private UserDAO userDao = new UserDAOImpl();
	private UserService userService = new UserServiceImpl(userDao);
	private List<User> users = new ArrayList<>();

	public String findAll() {
		try {
			users = userService.findAll();
		} catch (SQLException e) {
			DbLogging.LOG.error("ERROR!", e);
		}
		return PageConstant.REPORT;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
