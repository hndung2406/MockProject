/**
 * 
 */
package com.fa.group01.dao.productdao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.fa.group01.connect.DatabaseConnect;
import com.fa.group01.constants.DbQuery;
import com.fa.group01.dao.productdao.ProductDAO;
import com.fa.group01.entity.Manufacture;
import com.fa.group01.entity.Product;
import com.fa.group01.logging.DbLogging;
import com.fa.group01.utils.DateUtils;



/**
 * @author nguyenthanhlinh
 *
 */
public class ProductDAOImpl implements ProductDAO {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private CallableStatement callableStatement;

	@Override
	public int addProduct(Product product) {
		int affectedRow = 0;
		try {
			connection = DatabaseConnect.getInstance().getConnection();
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
		} catch (SQLException e) {
			DbLogging.LOG.error("Error Database exception", e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				DbLogging.LOG.error("Error Database exception", e);
			}
		}
		return affectedRow;
	}

	@Override
	public List<Product> findAllProduct() {
		List<Product> products = new ArrayList<>();
		Product product = null;
		Manufacture manufacture = null;
		try {
			connection = DatabaseConnect.getInstance().getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(DbQuery.SELECT_ALL_PRODUCT_QUERY);
			while (resultSet.next()) {
				product = new Product();
				manufacture = new Manufacture();

				fetchOneProduct(product, manufacture);

				products.add(product);
			}
		} catch (SQLException e) {
			DbLogging.LOG.error("Error Database exception");
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e2) {
				DbLogging.LOG.error("Error Database exception");
			}
		}
		return products;
	}

	@Override
	public Product findById(String productId) {
		Product product = new Product();
		Manufacture manufacture = new Manufacture();
		try {
			connection = DatabaseConnect.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(DbQuery.SELECT_PRODUCT_BY_ID);
			preparedStatement.setString(1, productId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				fetchOneProduct(product, manufacture);
			}
		} catch (SQLException e) {
			DbLogging.LOG.error("Error Database Exception", e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				DbLogging.LOG.error("Error Database Exception", e);
			}
		}
		return product;
	}

	/**
	 * @param product
	 * @param manufacture
	 * @throws SQLException
	 */
	private void fetchOneProduct(Product product, Manufacture manufacture) throws SQLException {
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

	@Override
	public int updateProduct(Product product) {
		int affectedRow = 0;
		try {
			connection = DatabaseConnect.getInstance().getConnection();
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
		} catch (SQLException e) {
			DbLogging.LOG.error("Error Database exception", e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				DbLogging.LOG.error("Error Database exception", e);
			}
		}
		return affectedRow;
	}

	@Override
	public List<Product> fetchLimitNumberOfProducts(int rowIndex, int maxNumberOfRecords) {
		List<Product> products = new ArrayList<>();
		Product product = null;
		Manufacture manufacture = null;
		try {
			connection = DatabaseConnect.getInstance().getConnection();
			callableStatement = connection.prepareCall(DbQuery.FETCH_LIMIT_PRODUCS);
			callableStatement.setInt(1, rowIndex);
			callableStatement.setInt(2, maxNumberOfRecords);
			resultSet = callableStatement.executeQuery();
			while (resultSet.next()) {
				product = new Product();
				manufacture = new Manufacture();
				fetchOneProduct(product, manufacture);
				products.add(product);
			}
		} catch (SQLException e) {
			DbLogging.LOG.error("Error Database exception", e);
		} finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				DbLogging.LOG.error("Error Database exception", e);
			}

		}
		return products;
	}

	public int deleteProduct(String productId) {
		int affectedRow = 0;
		try {
			connection = DatabaseConnect.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(DbQuery.DELETE_PRODUCT);
			preparedStatement.setString(1, productId);
			affectedRow = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			DbLogging.LOG.error("Error Database exception", e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				DbLogging.LOG.error("Error Database exception", e);
			}
		}
		return affectedRow;
	}

	@Override
	public List<Product> fetchProductsFromSpecificDate(String specificDate) {
		List<Product> products = new ArrayList<>();
		Product product = null;
		Manufacture manufacture = null;
		try {
			connection = DatabaseConnect.getInstance().getConnection();
			callableStatement = connection.prepareCall(DbQuery.FETCH_PRODUCTS_BY_CREATED_DATE);
			Date sqlDate = DateUtils.getDateByStringFormat(specificDate);
			
			callableStatement.setDate(1,sqlDate);			
			resultSet = callableStatement.executeQuery();
			
			while (resultSet.next()) {
				product = new Product();
				manufacture = new Manufacture();
				fetchOneProduct(product, manufacture);
				products.add(product);
			}
		} catch (SQLException e) {
			DbLogging.LOG.error("Error Database exception", e);
		} finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				DbLogging.LOG.error("Error Database exception", e);
			}

		}
		return products;
	}

}