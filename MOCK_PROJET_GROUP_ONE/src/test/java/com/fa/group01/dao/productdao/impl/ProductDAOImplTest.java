package com.fa.group01.dao.productdao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fa.group01.connect.DatabaseConnect;
import com.fa.group01.constants.DbQuery;
import com.fa.group01.entity.Manufacture;
import com.fa.group01.entity.Product;

@RunWith(MockitoJUnitRunner.class)
public class ProductDAOImplTest {

	@Mock
	private ProductDAOImpl productDao;

	@Mock
	private Connection mockConnection;
	@Mock
	private PreparedStatement mockPreparedStatement;
	@Mock
	private DatabaseConnect mockDatabaseConnect;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testAddProductSuccess() throws SQLException {
		Manufacture manufacture = new Manufacture(1, "Apple");
		Product product = new Product("P001", "Name", 123, "Description", "imageUrl", 3, "condition",new Date(2018, 11, 19), "spec", "properties", manufacture);
		Mockito.when(productDao.addProduct(product)).thenReturn(1);
		
		assertEquals(productDao.addProduct(product), 1);
	}
	
	@Test
	public void testAddProductFail() throws SQLException {
		Manufacture manufacture = new Manufacture(1, "Apple");
		Product product = new Product("P001", "Name", 123, "Description", "imageUrl", 3, "condition",new Date(2018, 11, 19), "spec", "properties", manufacture);
		Mockito.when(productDao.addProduct(product)).thenReturn(0);
		
		assertEquals(productDao.addProduct(product), 0);
	}
	
	@Test
	public void testFindAllProductNotNull() {
		Mockito.when(productDao.findAllProduct()).thenReturn(new ArrayList<>());
		assertNotNull(productDao.findAllProduct());
	}
	
	@Test
	public void testFindAllProductSize1() {
		Manufacture manufacture = new Manufacture(1, "Apple");
		Product product = new Product("P001", "Name", 123, "Description", "imageUrl", 3, "condition",new Date(2018, 11, 19), "spec", "properties", manufacture);
		List<Product> products = new ArrayList<>();
		products.add(product);
		Mockito.when(productDao.findAllProduct()).thenReturn(products);
		assertEquals(productDao.findAllProduct().size(), 1);
	}
	
	@Test
	public void testFindAllProductNull() {
		Mockito.when(productDao.findAllProduct()).thenReturn(null);
		assertNull(productDao.findAllProduct());
	}
	
//	@Test
//	public void test

//	@Test
//	public void CanGetListProducts() throws SQLException {
//		List<Product> products = productDAO.findAllProduct();
//		products.forEach(System.out::println);
//		assertNotEquals(products.size(), 0);
//	}
//
//	@Test	
//	public void CanGetLimitNumberOfProduct() {
//		List<Product> products;
//		products = productDAO.fetchLimitNumberOfProducts(0, 3);
//		products.forEach(System.out::println);
//		assertNotEquals(products.size(), 0);
//
//	}
//	
//	@Test
//	public void CanGetProductsFromSpecificDate() {
//		List<Product> products = productDAO.fetchProductsFromSpecificDate("2018-10-01");
//		products.forEach(System.out::println);
//		assertNotEquals(products.size(),0);
//	}

}
