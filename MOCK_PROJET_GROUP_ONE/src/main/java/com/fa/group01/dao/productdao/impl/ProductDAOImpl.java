/**
 * 
 */
package com.fa.group01.dao.productdao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	private Statement statement = null;
	private ResultSet resultSet = null;

	@Override
	public int addProduct(Product product) throws SQLException {
		connection = DatabaseConnect.getConnection();
		int affectedRow = 0;
		if (connection != null) {
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
		}
		return affectedRow;
	}

	@Override
	public List<Product> findAllProduct() throws SQLException {
		List<Product> products = new ArrayList<>();
		Product product = null;
		Manufacture manufacture = null;
		connection = DatabaseConnect.getConnection();
		if (connection != null) {
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(DbQuery.SELECT_ALL_PRODUCT_QUERY);
				while (resultSet.next()) {
					product = new Product();
					manufacture = new Manufacture();
					product.setId(resultSet.getString("ProductId"));
					product.setName(resultSet.getString("ProductName"));
					product.setPrice(resultSet.getDouble("ProductPrice"));
					product.setDescription(resultSet.getString("Description"));
					product.setImageUrl(resultSet.getString("Image"));
					product.setQuantity(resultSet.getInt("Quantity"));
					product.setCondition(resultSet.getString("Condition"));
					product.setDateOfManufacture(resultSet.getDate("DateOfManufacture"));
					product.setSpec(resultSet.getString("Spec"));
					product.setProperties(resultSet.getString("Properties"));
					manufacture.setManufactureId(resultSet.getInt("ManufactureId"));
					product.setManufacture(manufacture);
					products.add(product);
				}
			} finally {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			}
		}
		return products;
	}

	@Override
	public Product findById(String productId) throws SQLException {
		Product product = new Product();
		Manufacture manufacture = new Manufacture();
		try {
			connection = DatabaseConnect.getConnection();
			preparedStatement = connection.prepareStatement(DbQuery.SELECT_PRODUCT_BY_ID);
			preparedStatement.setString(1, productId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				product.setId(resultSet.getString("ProductId"));
				product.setName(resultSet.getString("ProductName"));
				product.setPrice(resultSet.getDouble("ProductPrice"));
				product.setDescription(resultSet.getString("Description"));
				product.setImageUrl(resultSet.getString("Image"));
				product.setQuantity(resultSet.getInt("Quantity"));
				product.setCondition(resultSet.getString("Condition"));
				product.setDateOfManufacture(resultSet.getDate("DateOfManufacture"));
				product.setSpec(resultSet.getString("Spec"));
				product.setProperties(resultSet.getString("Properties"));
				manufacture.setManufactureId(resultSet.getInt("ManufactureId"));
				product.setManufacture(manufacture);
			}
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return product;
	}

	@Override
	public int updateProduct(Product product) throws SQLException {
		connection = DatabaseConnect.getConnection();
		int affectedRow = 0;
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement(DbQuery.UPDATE_PRODUCT);
				preparedStatement.setString(1, product.getName());
				preparedStatement.setDouble(2, product.getPrice());
				preparedStatement.setString(3, product.getDescription());
				preparedStatement.setString(4, product.getImageUrl());
				preparedStatement.setInt(5, product.getQuantity());
				preparedStatement.setString(6, product.getCondition());
				preparedStatement.setDate(7, product.getDateOfManufacture());
				preparedStatement.setString(8, product.getSpec());
				preparedStatement.setString(9, product.getProperties());
				preparedStatement.setInt(10, product.getManufacture().getManufactureId());
				preparedStatement.setString(11, product.getId());

				affectedRow = preparedStatement.executeUpdate();
			} finally {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			}
		}
		return affectedRow;
	}

}
