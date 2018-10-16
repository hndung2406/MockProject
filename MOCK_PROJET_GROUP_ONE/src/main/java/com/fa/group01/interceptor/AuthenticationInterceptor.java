package com.fa.group01.interceptor;

import java.util.Map;

import com.fa.group01.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {		
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		Object action = invocation.getAction();
		
		//retrieve user from session
		User user = (User) session.get("authenticatedUser");
		System.out.println(user);
		if(user== null) {
			//if user not attempt to login then store action name in session for redirecting after login success
			String forwardUrl = invocation.getInvocationContext().getName();
			System.out.println(forwardUrl);
			session.put("forwardUrl", forwardUrl);
			
			return ActionSupport.INPUT;
		}else {
			
			if(user.getUserRole().equals("admin")) {	
				System.out.println("Master here");
				//return "master";
				return invocation.invoke();
			}
			if(user.getUserRole().equals("user")) {				
				return "user";
			}
			
		}
		
		
		return invocation.invoke();
	}

}