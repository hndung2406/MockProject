/**
 * 
 */
package com.fa.group01.action;

import com.fa.group01.constants.PageConstant;
import com.fa.group01.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author DungHN2
 *
 */
public class HomeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1938832076579954108L;
	private User user;

	public String home() {
		return PageConstant.SUCCESS;
	}

	public String checkSession() {
		user = (User) ActionContext.getContext().getSession().get("authenticatedUser");
		return PageConstant.SUCCESS;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
