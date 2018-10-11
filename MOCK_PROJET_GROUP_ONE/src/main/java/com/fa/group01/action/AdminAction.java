package com.fa.group01.action;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {


	private static final long serialVersionUID = 1L;

	
	public String viewProduct() {
		return "products";
	}
	
}
