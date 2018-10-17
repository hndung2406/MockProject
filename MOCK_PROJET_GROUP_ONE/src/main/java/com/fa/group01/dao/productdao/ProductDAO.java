/**
 * 
 */
package com.fa.group01.dao.productdao;

import java.sql.SQLException;
import java.util.List;

import com.fa.group01.entity.Product;

/**
 * @author nguyenthanhlinh
 *
 */
public interface ProductDAO {

	/**
	 * @param product
	 * @return
	 * @throws SQLException
	 */
	public int addProduct(Product product);

	/**
	 * @param productId
	 * @return
	 * @throws SQLException
	 */
	public Product findById(String productId);

	/**
	 * @return
	 * @throws SQLException
	 */
	public List<Product> findAllProduct();

	/**
	 * @param product
	 * @return
	 * @throws SQLException
	 */
	public int updateProduct(Product product);

	/**
	 * @param rowIndex
	 * @param maxNumberOfRecords
	 * @return
	 * @throws SQLException
	 */
	public List<Product> fetchLimitNumberOfProducts(int rowIndex, int maxNumberOfRecords);

	/**
	 * @param productId
	 * @return
	 * @throws SQLException
	 */
	public int deleteProduct(String productId);

}
