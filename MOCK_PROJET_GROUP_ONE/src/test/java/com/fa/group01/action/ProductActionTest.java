/**
 * 
 */
package com.fa.group01.action;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fa.group01.dao.manufacture.ManufactureDAO;
import com.fa.group01.dao.productdao.ProductDAO;
import com.fa.group01.entity.Manufacture;
import com.fa.group01.entity.Product;
import com.fa.group01.service.manufactureservice.impl.ManufactureServiceImpl;
import com.fa.group01.service.productservice.impl.ProductServiceImpl;

/**
 * @author nguyenthanhlinh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductActionTest {
	@Mock
	ProductServiceImpl productService;
	
	@Mock
	ManufactureServiceImpl manufactureService;
	
//	@Mock
//	ProductDAO productDao;
//	@Mock
//	ManufactureDAO manufactureDao;
	@Mock
	ProductAction productAction;
	
	private static Product product;
	private static List<Product> products;
	private static List<Product> emptyProducts;
	private static String productId;
	private static Manufacture manufacture;
	private static int manufactureId;
	static {
		productId = "P001";
		manufactureId = 1;
		manufacture = new Manufacture(1, "Apple");
		product = new Product("P001", "Name", 123, "Description", "imageUrl", 3, "condition", new Date(2018, 11, 19),
				"spec", "properties", manufacture);
		product.setId(productId);
		products = Arrays.asList(product);
		emptyProducts = null;
	}
	
	@Test
	public void testShowDeleteProductPage() {
//		Mockito.when(productDao.findById(productId)).thenReturn(product);
		Mockito.when(productService.findById(productId)).thenReturn(product);
		Mockito.when(manufactureService.findById(manufactureId)).thenReturn(manufacture);
		assertEquals("success", productAction.showDeleteProductPage());
	}

}
