/**
 * 
 */
package com.fa.group01.action;

import java.util.Date;
import java.util.List;

import com.fa.group01.constants.Constant;
import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.userdao.UserDAO;
import com.fa.group01.dao.userdao.impl.UserDAOImpl;
import com.fa.group01.entity.User;
import com.fa.group01.logging.DbLogging;
import com.fa.group01.service.userservice.UserService;
import com.fa.group01.service.userservice.impl.UserServiceImplTest;
import com.fa.group01.utils.DateUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * @author nguyenthanhlinh
 *
 */
public class RegisterAction extends ActionSupport implements Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -975855527019561906L;
	private String userrepassword;
	private User user;
	private UserDAO userDao;
	private UserService userService;
	private List<User> users;

	@Override
	public void prepare() throws Exception {
		userDao = new UserDAOImpl();
		userService = new UserServiceImplTest(userDao);
	}
	
	/**
	 * Register User with the input
	 * 
	 * @return
	 */
	public String registerUser() {
		Date out = DateUtils.getDate();
		userService.setUser(user, out, "user");
		String msg = userService.registerUser(user);
		if (msg.equals("Update Successful")) {
			DbLogging.LOG.info("REGISTERED");
			return PageConstant.REGISTER;
		} else {
			DbLogging.LOG.error("ERROR REGISTERED");
			return PageConstant.ERROR;
		}

	}

	/**
	 * Validate the input
	 * 
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
