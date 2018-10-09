package com.fa.group01.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;

import com.fa.group01.dao.impl.UserDAOImpl;
import com.fa.group01.service.UserService;
import com.fa.group01.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class AuthenticationAction extends ActionSupport implements Preparable {

	private UserService userService;

	private String errorMessage;
	private String jsonData;
	private String redirectUrl;

	@Override
	public void prepare() throws Exception {
		userService = new UserServiceImpl(new UserDAOImpl());
	}

	@Override
	public String execute() {
		return SUCCESS;
	}

	public String authenticate() {		

		JsonObject obj = new JsonParser().parse(jsonData).getAsJsonObject();
		String email = obj.get("email").getAsString();
		String password = obj.get("password").getAsString();
		try {
			if (userService.isAuthenticated(email, password)) {
				redirectUrl = "../index.jsp";
				return "success";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// response to clien error message
		errorMessage = "Email or address is not exist. Please try again";
		return "fail";
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

}
