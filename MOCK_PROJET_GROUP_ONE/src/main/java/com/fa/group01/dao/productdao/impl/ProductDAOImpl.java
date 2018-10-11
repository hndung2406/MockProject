/**
 * 
 */
package com.fa.group01.dao.productdao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fa.group01.connect.DatabaseConnect;
import com.fa.group01.constants.DbQuery;
import com.fa.group01.dao.productdao.ProductDAO;
import com.fa.group01.entity.Product;

/**
 * @author nguyenthanhlinh
 *
 */
public class ProductDAOImpl implements ProductDAO {
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	
	@Override
	public int save(Product product) throws SQLException {
		connection = DatabaseConnect.getConnection();
		
		int affectedRow = 0;

		try {
			preparedStatement = connection.prepareStatement(DbQuery.INSERT_NEW_PRODUCT);
			preparedStatement.setString(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setString(4, product.getDescription());
			preparedStatement.setString(5, product.getImageUrl());
			preparedStatement.setInt(6, product.getQuantity());
			preparedStatement.setString(7, product.getCondition());
			preparedStatement.setDate(8, product.getDateOfManufacture());
			preparedStatement.setString(9, product.getSpec());
			preparedStatement.setString(10, product.getProperties());
			preparedStatement.setInt(11, product.getManufacture().getManufactureId());

			affectedRow = preparedStatement.executeUpdate();
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return affectedRow;
	}

}
