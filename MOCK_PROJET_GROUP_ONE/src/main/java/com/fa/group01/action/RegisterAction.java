/**
 * 
 */
package com.fa.group01.action;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.fa.group01.constants.Constant;
import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.UserDAO;
import com.fa.group01.dao.impl.UserDAOImpl;
import com.fa.group01.entity.User;
import com.fa.group01.logging.DbLogging;
import com.fa.group01.service.UserService;
import com.fa.group01.service.impl.UserServiceImpl;
import com.fa.group01.utils.DateUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author nguyenthanhlinh
 *
 */
public class RegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -975855527019561906L;
	private String userrepassword;
	private User user;
	private UserDAO userDao = new UserDAOImpl();
	private UserService userService = new UserServiceImpl(userDao);
	private List<User> users;

	/**
	 * Register User with the input
	 * @return
	 */
	public String registerUser() {
		Date out = DateUtils.getDate();
		java.sql.Timestamp createdDate = new java.sql.Timestamp(out.getTime());
		user.setUserCreateDate(createdDate);
		user.setUserRole("user");
		try {
			String msg = userService.registerUser(user);
			if(msg.equals("Update Successful")) {
				DbLogging.LOG.info("REGISTERED");
				return PageConstant.REGISTER;
			} else {
				DbLogging.LOG.error("ERROR REGISTERED");
				return PageConstant.ERROR;
			}
		} catch (SQLException e) {
			DbLogging.LOG.error("ERROR!", e);
		}
		return PageConstant.REGISTER;
	}
	
	/**
	 * Validate the input
	 * @return
	 */
	@Override
	public void validate() {
		String regex = Constant.EMAIL_REGEX;
		if (user.getUserName().length() < 6) {
			addFieldError("user.userName", "*Username must have at least 6 characters");
		}
		if (!user.getUserEmail().matches(regex)) {
			addFieldError("user.userEmail", "*Wrong email format");
		}
		if (user.getUserPassword().length() < 8) {
			addFieldError("user.userPassword", "*Password must have at least 8 characters or digits");
		}
		if (!userrepassword.equals(user.getUserPassword())) {
			addFieldError("userrepassword", "*Password does not match");
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserrepassword() {
		return userrepassword;
	}

	public void setUserrepassword(String userrepassword) {
		this.userrepassword = userrepassword;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
