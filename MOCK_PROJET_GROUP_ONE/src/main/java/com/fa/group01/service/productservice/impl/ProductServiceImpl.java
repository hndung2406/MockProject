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
	public int save(Product product) throws SQLException {
		return this.productDao.save(product);
	}

	@Override
	public List<Product> findAll() throws SQLException {
		return this.productDao.findAll();
	}

	@Override
	public Product findById(String productId) throws SQLException {
		return this.productDao.findById(productId);
	}

}
