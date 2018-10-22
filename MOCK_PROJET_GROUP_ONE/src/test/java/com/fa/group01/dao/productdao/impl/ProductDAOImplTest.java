package com.fa.group01.dao.productdao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.fa.group01.dao.productdao.ProductDAO;
import com.fa.group01.entity.Manufacture;
import com.fa.group01.entity.Product;

public class ProductDAOImplTest {

	private ProductDAO productDao;
	private Product product;

	@Before
	public void setUp() throws Exception {
		productDao = new ProductDAOImpl();
		product = new Product();
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
    
	@Test
	public void AddProductAlreradyNotInDatabase() {
		product.setId("P0001");
		product.setName("IphoneXS");
		product.setPrice(1200.0);
		product.setDescription("asd");
		product.setCondition("New");
		product.setDateOfManufacture(new Date(2018, 11, 19));
		product.setImageUrl("asdasd");
		product.setManufacture(new Manufacture(1, "Apple"));
		product.setProperties("asdasd");
		product.setQuantity(12);
		product.setSpec("123");
		int result = productDao.addProduct(product);
		assertEquals(1, result);
	}
	
	@Test
	public void AddProductAlreadyInDatabase() {
		product.setId("P0001");
		product.setName("IphoneXS");
		product.setPrice(1200.0);
		product.setDescription("asd");
		product.setCondition("New");
		product.setDateOfManufacture(new Date(2018, 11, 19));
		product.setImageUrl("asdasd");
		product.setManufacture(new Manufacture(1, "Apple"));
		product.setProperties("asdasd");
		product.setQuantity(12);
		product.setSpec("123");
		int result = productDao.addProduct(product);
		assertEquals(0, result);
	}
	
	
	
	@Test
	public void FindAllProduct() {
		List<Product> products = productDao.findAllProduct();
		assertEquals(18, products.size());
	}
	
	@Test
	public void FindById() {
		product = productDao.findById("0001");
		assertNotNull(product);
	}
	
	@Test
	public void UpdateProduct() {
		product.setId("P0001");
		product.setName("IphoneXS");
		product.setPrice(2100.0);
		product.setDescription("asd");
		product.setCondition("New");
		product.setDateOfManufacture(new Date(2018, 11, 19));
		product.setImageUrl("asdasd");
		product.setManufacture(new Manufacture(1, "Apple"));
		product.setProperties("asdasd");
		product.setQuantity(12);
		product.setSpec("123");
		int result = productDao.updateProduct(product);
		assertEquals(1, result);
	}
	
	@Test
	public void UpdateProductNotInDatabase() {
		product.setId("P9999");
		product.setName("IphoneXS");
		product.setPrice(2100.0);
		product.setDescription("asd");
		product.setCondition("New");
		product.setDateOfManufacture(new Date(2018, 11, 19));
		product.setImageUrl("asdasd");
		product.setManufacture(new Manufacture(1, "Apple"));
		product.setProperties("asdasd");
		product.setQuantity(12);
		product.setSpec("123");
		int result = productDao.updateProduct(product);
		assertEquals(0, result);
	}
	
	@Test
	public void DeleteProduct() {
		int result = productDao.deleteProduct("P0001");
		assertEquals(1, result);
	}
	
	@Test
	public void DeleteProductNotInDatabase() {
		int result = productDao.deleteProduct("P10010");
		assertEquals(0, result);
	}
	
	@Test
	public void FetchProductsFromSpecificDate () {
		List<Product> products = productDao.fetchProductsFromSpecificDate("2018-10-10");
		assertEquals(8, products.size());
	}
}
