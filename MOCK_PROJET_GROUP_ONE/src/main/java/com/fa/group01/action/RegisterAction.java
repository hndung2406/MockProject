/**
 * 
 */
package com.fa.group01.action;

import com.fa.group01.constants.PageConstant;
import com.fa.group01.entity.User;
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
	private User user;

	public String registerUser() {
		System.out.println(user.toString());
		return PageConstant.REGISTER;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
