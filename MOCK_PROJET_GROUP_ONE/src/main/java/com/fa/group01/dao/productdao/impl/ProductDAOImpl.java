/**
 * 
 */
package com.fa.group01.dao.productdao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fa.group01.connect.DatabaseConnect;
import com.fa.group01.constants.DbQuery;
import com.fa.group01.dao.productdao.ProductDAO;
import com.fa.group01.entity.Manufacture;
import com.fa.group01.entity.Product;

/**
 * @author nguyenthanhlinh
 *
 */
public class ProductDAOImpl implements ProductDAO {
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet;
	
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

	@Override
	public List<Product> findAllProducts() throws SQLException {
		
		connection = DatabaseConnect.getConnection();
		preparedStatement = connection.prepareStatement(DbQuery.FIND_ALL_PRODUCTS);
		resultSet = preparedStatement.executeQuery();
		
		Product product = null;
		Manufacture manufacture = new Manufacture();
		List<Product> products = new ArrayList<>();
		
		while(resultSet.next()) {
			String id = resultSet.getString("ProductId");
			String name = resultSet.getString("ProductName");
			float price = resultSet.getFloat("ProductPrice");
			String description = resultSet.getString("Description");
			String imageUrl = resultSet.getString("Image");
			int quantity = resultSet.getInt("Quantity");
			String condition = resultSet.getString("Condition");
			Date dateOfManufacture = resultSet.getDate("DateOfManufacture");
			String spec = resultSet.getString("Spec");
			String properties = resultSet.getString("Properties");
			
			int manufactureId = resultSet.getInt("ManufactureId");
			manufacture.setManufactureId(manufactureId); 
			
			product = new Product(id, name, price, description, imageUrl, quantity, condition, dateOfManufacture, spec, properties, manufacture);
						
			products.add(product);
		}
		
		return products;
	}

}
