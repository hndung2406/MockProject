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
		if(user== null) {
			return ActionSupport.INPUT;
		}			
		
		return invocation.invoke();
		
		
	}

}
