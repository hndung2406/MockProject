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
	 * @param productId
	 * @return
	 * @throws SQLException
	 */
	public Product findById(String productId) throws SQLException;

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
	
	/**
	 * @param product
	 * @return
	 */
	public String[] splitStringProduct(String productString);

	/**
	 * @param product
	 * @return
	 * @throws SQLException
	 */
	public int updateProduct(Product product) throws SQLException;
	
	/**
	 * @param productId
	 * @return
	 * @throws SQLException
	 */
	public int deleteProduct(String productId) throws SQLException;

	public List<Product> fetchThreeProductsOnOneSinglePage(int rowIndex, int maxNumberOfRecords) throws SQLException;

	

	

}
