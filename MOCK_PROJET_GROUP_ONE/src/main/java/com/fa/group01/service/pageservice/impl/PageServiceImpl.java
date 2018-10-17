package com.fa.group01.service.pageservice.impl;

import java.sql.SQLException;
import java.util.List;

import com.fa.group01.dao.productdao.ProductDAO;
import com.fa.group01.entity.Product;
import com.fa.group01.service.pageservice.PageService;

public class PageServiceImpl implements PageService {

	private ProductDAO productDAO;

	public PageServiceImpl(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public List<Product> getLimitProductsPerPage(int rowIndex, int maxNumberOfRecords) {
		return productDAO.fetchLimitNumberOfProducts(rowIndex, maxNumberOfRecords);
	}

	@Override
	public int getMaxNavigationTabForProductPage(int maxNumberOfRecords) throws SQLException {
		int totalProductRecord = getTotalProductRecord();
		return Math.round(totalProductRecord/maxNumberOfRecords) + 1;

	}

	@Override
	public int getTotalProductRecord() throws SQLException {
		return this.productDAO.findAllProduct().size();

	}

}
