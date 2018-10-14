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
	
	int save(Product product) throws SQLException;

	
	List<Product> fetchAllProducts() throws SQLException;
}
