/**
 * 
 */
package com.fa.group01.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.productdao.ProductDAO;
import com.fa.group01.dao.productdao.impl.ProductDAOImpl;
import com.fa.group01.dao.userdao.UserDAO;
import com.fa.group01.dao.userdao.impl.UserDAOImpl;
import com.fa.group01.entity.Product;
import com.fa.group01.entity.User;
import com.fa.group01.logging.DbLogging;
import com.fa.group01.service.productservice.ProductService;
import com.fa.group01.service.productservice.impl.ProductServiceImpl;
import com.fa.group01.service.userservice.UserService;
import com.fa.group01.service.userservice.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author DungHN2
 *
 */
public class ReportAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6726901906485612157L;
	private UserDAO userDao = new UserDAOImpl();
	private ProductDAO productDao = new ProductDAOImpl();
	private UserService userService = new UserServiceImpl(userDao);
	private ProductService productService = new ProductServiceImpl(productDao);
	private List<User> users = new ArrayList<>();
	private List<Product> products = new ArrayList<>();

	public String findAllUser() {
		try {
			users = userService.findAll();
		} catch (SQLException e) {
			DbLogging.LOG.error("ERROR!", e);
		}
		return PageConstant.REPORT;
	}
	
	public String findAllProduct() {
		try {
			products = productService.findAllProduct();
		} catch (SQLException e) {
			DbLogging.LOG.error("ERROR!", e);
		}
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
