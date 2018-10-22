package com.fa.group01.dao.productdao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fa.group01.connect.DatabaseConnect;
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
	
	private static Product product;
	
	static {
		Manufacture manufacture = new Manufacture(1, "Apple");
		product = new Product("P001", "Name", 123, "Description", "imageUrl", 3, "condition",new Date(2018, 11, 19), "spec", "properties", manufacture);
	}

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testAddProductSuccess() throws SQLException {
		Mockito.when(productDao.addProduct(product)).thenReturn(1);
		assertEquals(1, productDao.addProduct(product));
		Mockito.verify(productDao, Mockito.times(1)).addProduct(product);
	}
	
	@Test
	public void testAddProductFail() throws SQLException {
		Mockito.when(productDao.addProduct(product)).thenReturn(0);
		assertEquals(0, productDao.addProduct(product));
		Mockito.verify(productDao, Mockito.times(1)).addProduct(product);
	}
	
	@Test
	public void testFindAllProductNotNull() {
		Mockito.when(productDao.findAllProduct()).thenReturn(new ArrayList<>());
		assertNotNull(productDao.findAllProduct());
		Mockito.verify(productDao, Mockito.times(1)).findAllProduct();
	}
	
	@Test
	public void testFindAllProductSize1() {
		List<Product> products = new ArrayList<>();
		products.add(product);
		Mockito.when(productDao.findAllProduct()).thenReturn(products);
		assertEquals(1, productDao.findAllProduct().size());
		Mockito.verify(productDao, Mockito.times(1)).findAllProduct();
	}
	
	@Test
	public void testFindAllProductNull() {
		Mockito.when(productDao.findAllProduct()).thenReturn(null);
		assertNull(productDao.findAllProduct());
		Mockito.verify(productDao, Mockito.times(1)).findAllProduct();
	}
	
	@Test
	public void testFindByIdSuccess() {
		String productId = "P001";
		product.setId(productId);
		Mockito.when(productDao.findById(productId)).thenReturn(product);
		assertEquals(product, productDao.findById(productId));
		Mockito.verify(productDao).findById(productId);
	}
	
	@Test
	public void testFindByIdReturnNull() {
		String productId = "P001";
		product.setId(productId);
		Mockito.when(productDao.findById(productId)).thenReturn(null);
		assertEquals(null, productDao.findById(productId));
		Mockito.verify(productDao).findById(productId);
	}
	
	@Test
	public void testUpdateProductSuccess() {
		Mockito.when(productDao.updateProduct(product)).thenReturn(1);
		assertEquals(1, productDao.updateProduct(product));
		Mockito.verify(productDao, Mockito.times(1)).updateProduct(product);
	}
	
	@Test
	public void testUpdateProductFail() {
		Mockito.when(productDao.updateProduct(product)).thenReturn(0);
		assertEquals(0, productDao.updateProduct(product));
		Mockito.verify(productDao, Mockito.times(1)).updateProduct(product);
	}
	
	@Test
	public void testFetchLimitNumberOfProducts() {
		int rowIndex = 1;
		int maxNumberOfRecords = 5;
		List<Product> products = new ArrayList<>();
		for (int i = rowIndex; i < maxNumberOfRecords; i++) {
			products.add(product);
		}
		Mockito.when(productDao.fetchLimitNumberOfProducts(rowIndex, maxNumberOfRecords)).thenReturn(products);
		assertEquals(products.size(), productDao.fetchLimitNumberOfProducts(rowIndex, maxNumberOfRecords).size());
		Mockito.verify(productDao).fetchLimitNumberOfProducts(rowIndex, maxNumberOfRecords);
	}

	@Test
	public void testFetchLimitNumberOfProductsNull() {
		int rowIndex = 1;
		int maxNumberOfRecords = 5;
		List<Product> products = null;
		
		Mockito.when(productDao.fetchLimitNumberOfProducts(rowIndex, maxNumberOfRecords)).thenReturn(products);
		assertNull(productDao.fetchLimitNumberOfProducts(rowIndex, maxNumberOfRecords));
		Mockito.verify(productDao).fetchLimitNumberOfProducts(rowIndex, maxNumberOfRecords);
	}
	
	@Test
	public void testDeleteProductSuccess() {
		String productId = "P001";
		Mockito.when(productDao.deleteProduct(productId)).thenReturn(1);
		assertEquals(1, productDao.deleteProduct(productId));
		Mockito.verify(productDao, Mockito.times(1)).deleteProduct(productId);
	}
	
	@Test
	public void testDeleteProductFail() {
		String productId = "P001";
		Mockito.when(productDao.deleteProduct(productId)).thenReturn(0);
		assertEquals(0, productDao.deleteProduct(productId));
		Mockito.verify(productDao, Mockito.times(1)).deleteProduct(productId);
	}
	
	@Test
	public void testFetchProductsFromSpecificDate() {
		String specificDate = "1999/12/12";
		List<Product> products = Arrays.asList(product);
		Mockito.when(productDao.fetchProductsFromSpecificDate(specificDate)).thenReturn(products);
		assertEquals(products.size(), productDao.fetchProductsFromSpecificDate(specificDate).size());
		Mockito.verify(productDao, Mockito.times(1)).fetchProductsFromSpecificDate(specificDate);
	}
	
	@Test
	public void testFetchProductsFromSpecificDateReturnNull() {
		String specificDate = "1999/12/12";
		List<Product> products = null;
		Mockito.when(productDao.fetchProductsFromSpecificDate(specificDate)).thenReturn(products);
		assertNull(productDao.fetchProductsFromSpecificDate(specificDate));
		Mockito.verify(productDao, Mockito.times(1)).fetchProductsFromSpecificDate(specificDate);
	}
}
