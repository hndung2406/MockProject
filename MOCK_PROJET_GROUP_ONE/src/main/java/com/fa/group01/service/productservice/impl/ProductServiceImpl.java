/**
 * 
 */
package com.fa.group01.service.productservice.impl;

import java.sql.SQLException;
import java.util.List;

import com.fa.group01.dao.productdao.ProductDAO;
import com.fa.group01.entity.Product;
import com.fa.group01.service.productservice.ProductService;

/**
 * @author nguyenthanhlinh
 *
 */
public class ProductServiceImpl implements ProductService {

	private ProductDAO productDao;

	public ProductServiceImpl(ProductDAO productDao) {
		this.productDao = productDao;
	}

	@Override
	public int addProduct(Product product) throws SQLException {
		return productDao.addProduct(product);
	}

	@Override
	public List<Product> findAllProduct() throws SQLException {
		return productDao.findAllProduct();
	}

	@Override
	public List<Product> fetchAllProducts() throws SQLException {
		return this.productDao.findAllProduct();
	}

	@Override
	public Product findById(String productId) throws SQLException {
		return this.productDao.findById(productId);
	}

	@Override
	public String[] splitStringProduct(String productString) {
		String[] split = productString.split("\\.+");
		for(int i = 0; i < split.length; i ++) {
			split[i] = split[i].trim() + ".";
		}
		return split;
	}

	@Override
	public int updateProduct(Product product) throws SQLException {
		return this.productDao.updateProduct(product);
	}

	@Override
	public int deleteProduct(String productId) throws SQLException {
		return this.productDao.deleteProduct(productId);
	}

}
