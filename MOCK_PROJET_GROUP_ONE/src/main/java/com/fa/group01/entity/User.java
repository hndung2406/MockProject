/**
 * 
 */
package com.fa.group01.entity;

import java.sql.Timestamp;

/**
 * @author nguyenthanhlinh
 *
 */
public class User {

	private int userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userFirstName;
	private String userLastName;
	private String userRole;
	private Timestamp userCreateDate;

	public User(int userId, String userName, String userPassword, String userEmail, String userFirstName,
			String userLastName, String userRole, Timestamp userCreateDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userRole = userRole;
		this.userCreateDate = userCreateDate;
	}

	public User() {

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Timestamp getUserCreateDate() {
		return userCreateDate;
	}

	public void setUserCreateDate(Timestamp userCreateDate) {
		this.userCreateDate = userCreateDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userRole="
				+ userRole + ", userCreateDate=" + userCreateDate + "]";
	}

}
