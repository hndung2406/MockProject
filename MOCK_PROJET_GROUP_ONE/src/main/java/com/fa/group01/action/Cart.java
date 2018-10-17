/**
 * 
 */
package com.fa.group01.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fa.group01.constants.PageConstant;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * @author DungHN2
 *
 */
public class Cart extends ActionSupport implements Preparable, SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6840147582101483525L;
	private Map<String, Integer> cart;
	private String id;
	private Map<String, Object> cartSession;
	
	@SuppressWarnings("unchecked")
	@Override
	public void prepare() throws Exception {
		cartSession = ActionContext.getContext().getSession();
		
	}
	
	public String addToCart() {
		if(cartSession.isEmpty()) {
			cart = new HashMap<String, Integer>();
			cartSession.put("cart", cart);
		}
		cart = (Map<String, Integer>) cartSession.get("cart");
		if(cart.containsKey(id)) {
			int a = cart.get(id);
			a += 1;
			cart.put(id, a);
		} else {
			cart.put(id, 1);
		}
		System.out.println(cartSession);
		cartSession.put("cart", cart);
		return PageConstant.SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.cartSession = session;
	}
	
}
