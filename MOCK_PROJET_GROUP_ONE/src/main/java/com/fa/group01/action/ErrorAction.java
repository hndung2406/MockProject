package com.fa.group01.action;

import com.opensymphony.xwork2.ActionSupport;

public class ErrorAction extends ActionSupport {

	
	private static final long serialVersionUID = 1L;
	
	public String unauthorize() {
		return "403";
	}

}
