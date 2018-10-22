/**
 * 
 */
package com.fa.group01.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.userdao.UserDAO;
import com.fa.group01.dao.userdao.impl.UserDAOImpl;
import com.fa.group01.entity.User;
import com.fa.group01.logging.DbLogging;
import com.fa.group01.service.userservice.UserService;
import com.fa.group01.service.userservice.impl.UserServiceImplTest;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * @author DungHN2
 *
 */
public class UserAction extends ActionSupport implements SessionAware, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5031124201182742786L;
	private User user;
	private UserDAO userDao;
	private UserService userService;
	private String message;
	private Map<String, Object> userSession;

	@Override
	public void prepare() throws Exception {
		userDao = new UserDAOImpl();
		userService = new UserServiceImplTest(userDao);
	}

	public String fetchUser() {
		user = (User) ActionContext.getContext().getSession().get("authenticatedUser");
		return PageConstant.SUCCESS;
	}

	public String updateUser() {
		user.setUserRole("user");
		int affectedRow = userService.updateUser(user);
		if (affectedRow > 0) {
			message = "Update Successful!";
			DbLogging.LOG.info("Update Successful!");
			userSession.put("authenticatedUser", user);
			return PageConstant.SUCCESS;
		} else {
			message = "Update Fail!";
			DbLogging.LOG.error("Update Fail!");
			return PageConstant.ERROR;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}

}
