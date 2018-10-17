/**
 * 
 */
package com.fa.group01.action;

import java.util.ArrayList;
import java.util.List;

import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.productdao.ProductDAO;
import com.fa.group01.dao.productdao.impl.ProductDAOImpl;
import com.fa.group01.dao.userdao.UserDAO;
import com.fa.group01.dao.userdao.impl.UserDAOImpl;
import com.fa.group01.entity.Product;
import com.fa.group01.entity.User;
import com.fa.group01.service.productservice.ProductService;
import com.fa.group01.service.productservice.impl.ProductServiceImpl;
import com.fa.group01.service.userservice.UserService;
import com.fa.group01.service.userservice.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * @author DungHN2
 *
 */
public class ReportAction extends ActionSupport implements Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6726901906485612157L;
	private UserDAO userDao;
	private ProductDAO productDao;
	private UserService userService;
	private ProductService productService;
	private List<User> users;
	private List<Product> products;


	@Override
	public void prepare() throws Exception {
		userDao = new UserDAOImpl();
		productDao = new ProductDAOImpl();
		userService = new UserServiceImpl(userDao);
		productService = new ProductServiceImpl(productDao);
		users = new ArrayList<>();
		products = new ArrayList<>();
	}
	
	public String findAllUser() {
		users = userService.findAll();
		return PageConstant.REPORT;
	}

	public String findAllProduct() {
		products = productService.findAllProduct();
		return PageConstant.REPORT;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}


}
