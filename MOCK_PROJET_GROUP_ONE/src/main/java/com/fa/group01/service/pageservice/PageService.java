package com.fa.group01.service.pageservice;

import java.sql.SQLException;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.fa.group01.entity.Product;

public interface PageService {

	/**
	 * @param rowIndex
	 * @param maxNumberOfRecords
	 * @return
	 * @throws SQLException
	 */
	public List<Product> getLimitProductsPerPage(int rowIndex, int maxNumberOfRecords);

	/**
	 * @param maxNumberOfRecords
	 * @return
	 * @throws SQLException
	 */
	public int getMaxNavigationTabForProductPage(int maxNumberOfRecords) throws SQLException;

	/**
	 * @return
	 * @throws SQLException
	 */
	public int getTotalProductRecord() throws SQLException;
	
	public List<Product> fetchProductsByCreatedDate(String specificDate) throws DateTimeParseException;
}
