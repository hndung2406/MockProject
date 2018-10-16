package com.fa.group01.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fa.group01.dao.userdao.impl.UserDAOImpl;
import com.fa.group01.entity.User;
import com.fa.group01.service.userservice.UserService;
import com.fa.group01.service.userservice.impl.UserServiceImpl;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class AuthenticationAction extends ActionSupport implements Preparable, SessionAware {

	
	private static final long serialVersionUID = 1L;

	private UserService userService;

	private String errorMessage;
	private String jsonData;
	private String redirectUrl;

	private Map<String, Object> userSession;

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
				// check role of user
				User user = (User) userSession.get("authenticatedUser");
				if (user == null) {
					user = userService.fetchUserByEmail(email);					
					String redirectUrl = (String) userSession.get("forwardUrl");
					String userRole = user.getUserRole();
					// user attempt to login
					if(redirectUrl == null) {	
						
						this.redirectUrl = "home";
					}
					// user does not attempt to login
					else {						
						this.redirectUrl = redirectUrl;
					}				
					
					//add user to session
					userSession.put("authenticatedUser", user);
					return "success";
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// response to clien error message
		errorMessage = "Email or address is not exist. Please try again";
		return "fail";
	}

	public String logout() {
		//remove session user
		User user = (User) userSession.get("authenticatedUser");
		String forwardUrl = (String) userSession.get("forwardUrl");
		if(user!= null ) {
			userSession.remove("authenticatedUser");//remove user 
			
		}
		if(forwardUrl!= null ) {
			userSession.remove("forwardUrl");//remove user 
			
		}
		return SUCCESS;
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.userSession = session;
	}

}