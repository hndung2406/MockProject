/**
 * 
 */
package com.fa.group01.service.productservice;

import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.fa.group01.entity.Manufacture;
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
	 */
	public String[] splitStringProduct(String productString);

	/**
	 * @param product
	 * @return
	 * @throws SQLException
	 */
	public int updateProduct(Product product);
	
	/**
	 * @param productId
	 * @return
	 * @throws SQLException
	 */
	public int deleteProduct(String productId);

	/**
	 * @param rowIndex
	 * @param maxNumberOfRecords
	 * @return
	 * @throws SQLException
	 */
	public List<Product> fetchThreeProductsOnOneSinglePage(int rowIndex, int maxNumberOfRecords) throws SQLException;

	/**
	 * @return
	 */
	public String getRandomName(String randomName, File image, String imageFileName);

	/**
	 * @param product
	 * @param randomName
	 * @param manufacture
	 * @param date
	 * @return
	 */
	public Product setProduct(Product product, String randomName, Manufacture manufacture, Date date);
	
}
