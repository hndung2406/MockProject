package com.fa.group01.interceptor;

import java.util.HashMap;
import java.util.Map;

import com.fa.group01.entity.Product;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CartInterceptor implements Interceptor {

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
		Map<String, Object> userSession = invocation.getInvocationContext().getSession();
		 @SuppressWarnings("unchecked")
		Map<Product, Integer> cart = (Map<Product, Integer>) userSession.get("cart");
		if(cart == null) {			
			cart = new HashMap<>();
			userSession.put("cart", cart);
			return invocation.invoke();
		}
		return invocation.invoke();
	}

}
