/**
 * 
 */
package com.fa.group01.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fa.group01.dao.productdao.ProductDAO;
import com.fa.group01.entity.Manufacture;
import com.fa.group01.entity.Product;
import com.fa.group01.service.productservice.impl.ProductServiceImpl;

/**
 * @author nguyenthanhlinh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
	
	@InjectMocks
	ProductServiceImpl productService;
	
	@Mock
	ProductDAO productDao;

	@Mock
	File image;
	
	@Mock
	File file;
	
	private static Product product;
	private static List<Product> products;
	private static List<Product> emptyProducts;
	private static String productId;
	private static Manufacture manufacture;
	
	static {
		productId = "P001";
		manufacture = new Manufacture(1, "Apple");
		product = new Product("P001", "Name", 123, "Description", "imageUrl", 3, "condition", new Date(2018, 11, 19),
				"spec", "properties", manufacture);
		product.setId(productId);
		products = Arrays.asList(product);
		emptyProducts = null;
	}

	@Test
	public void testAddProductSuccess() {
		Mockito.when(productDao.addProduct(product)).thenReturn(1);
		assertEquals(1, productService.addProduct(product));
		Mockito.verify(productDao, Mockito.times(1)).addProduct(product);
	}
	
	@Test
	public void testAddProductFail() {
		Mockito.when(productDao.addProduct(product)).thenReturn(0);
		assertEquals(0, productService.addProduct(product));
		Mockito.verify(productDao, Mockito.times(1)).addProduct(product);
	}
	
	@Test
	public void testFindAllProduct() {
		Mockito.when(productDao.findAllProduct()).thenReturn(products);
		assertEquals(1, productService.findAllProduct().size());
		Mockito.verify(productDao).findAllProduct();
	}
	
	@Test
	public void testFindAllProductReturnNull() {
		Mockito.when(productDao.findAllProduct()).thenReturn(emptyProducts);
		assertNull(productService.findAllProduct());
		Mockito.verify(productDao).findAllProduct();
	}
	
	@Test
	public void testFindById() {
		Mockito.when(productDao.findById(productId)).thenReturn(product);
		assertEquals(product, productService.findById(productId));
		Mockito.verify(productDao).findById(productId);
	}
	
	@Test
	public void testSplitStringProduct() {
		String properties = "Apple. 15in. 1080px";
		String[] result = {"Apple.", "15in.", "1080px."};
		assertArrayEquals(result, productService.splitStringProduct(properties));
	}
	
	@Test
	public void testUpdateProduct() {
		Mockito.when(productDao.updateProduct(product)).thenReturn(1);
		assertEquals(1, productService.updateProduct(product));
		Mockito.verify(productDao).updateProduct(product);
	}
	
	@Test
	public void testFetchThreeProductsOnOneSinglePage() throws SQLException {
		Mockito.when(productDao.fetchLimitNumberOfProducts(1, 2)).thenReturn(products);
		assertEquals(1, productService.fetchThreeProductsOnOneSinglePage(1, 2).size());
		Mockito.verify(productDao).fetchLimitNumberOfProducts(1, 2);
	}
	
	@Test
	public void testDeleteProduct() {
		Mockito.when(productDao.deleteProduct(productId)).thenReturn(1);
		assertEquals(1, productService.deleteProduct(productId));
		Mockito.verify(productDao).deleteProduct(productId);
	}
	
	@Test
	public void testSetProduct() {
		Product product = new Product();
		String randomeName = "random.jpg";
		java.util.Date dateOfManufacture = new java.util.Date();
		product = productService.setProduct(product, randomeName, manufacture, dateOfManufacture);
		assertEquals(product, productService.setProduct(product, randomeName, manufacture, dateOfManufacture));
	}
	
	@Test
	public void testSetProductDateOfManufactureNull() {
		Product product = new Product();
		String randomeName = "random.jpg";
		product = productService.setProduct(product, randomeName, manufacture, null);
		assertEquals(product, productService.setProduct(product, randomeName, manufacture, null));
	}
	
}
