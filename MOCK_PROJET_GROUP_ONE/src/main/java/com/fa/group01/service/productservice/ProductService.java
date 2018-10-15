/**
 * 
 */
package com.fa.group01.service.productservice;

import java.sql.SQLException;
import java.util.List;

import com.fa.group01.entity.Product;

/**
 * @author nguyenthanhlinh
 *
 */
public interface ProductService {
	
	/**
	 * @param product
	 * @return
	 * @throws SQLException
	 */
	public int addProduct(Product product) throws SQLException;

	/**
	 * @return
	 * @throws SQLException
	 */
	public List<Product> findAllProduct() throws SQLException;
		
	/**
	 * @return
	 * @throws SQLException
	 */
	public List<Product> fetchAllProducts() throws SQLException;
}
