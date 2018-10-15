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
	
	public int save(Product product) throws SQLException;
	
	public List<Product> findAll() throws SQLException;
	
	public Product findById(String productId) throws SQLException;

}
