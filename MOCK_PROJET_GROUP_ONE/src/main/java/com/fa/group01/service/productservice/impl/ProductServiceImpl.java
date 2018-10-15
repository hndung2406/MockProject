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

}
