package com.fa.group01.dao.productdao.impl;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fa.group01.dao.productdao.ProductDAO;
import com.fa.group01.entity.Product;

public class ProductDAOImplTest {

	private ProductDAO productDAO;
	
	@Before
	public void setUp() throws Exception {
		productDAO = new ProductDAOImpl();
	}

	@Test
	public void CanGetListProducts() throws SQLException {
		List<Product> products = productDAO.findAllProduct();
		products.forEach(System.out::println);
		assertNotEquals(products.size(),0);
	}

}
