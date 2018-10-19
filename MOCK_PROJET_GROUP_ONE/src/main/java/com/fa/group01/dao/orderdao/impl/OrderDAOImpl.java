/**
 * 
 */
package com.fa.group01.dao.orderdao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.fa.group01.connect.DatabaseConnect;
import com.fa.group01.constants.DbQuery;
import com.fa.group01.dao.orderdao.OrderDAO;
import com.fa.group01.entity.Order;
import com.fa.group01.entity.OrderDetail;
import com.fa.group01.logging.DbLogging;

/**
 * @author DungHN2
 *
 */
public class OrderDAOImpl implements OrderDAO {

	private Connection connection = null;
	private CallableStatement callableStatement = null;

	/**
	 * Add order into database
	 * 
	 * @param order
	 * @return
	 * @throws SQLException
	 */
	@Override
	public int addOrder(Order order) {
		int affectedRow = 0;
		try {
			connection = DatabaseConnect.getInstance().getConnection();
			callableStatement = connection.prepareCall(DbQuery.INSERT_NEW_ORDER_QUERY);
			callableStatement.setInt(1, order.getUser().getUserId());
			callableStatement.setString(2, order.getOrderCardNumber());
			callableStatement.setInt(3, order.getCountry().getCountryId());
			callableStatement.setDate(4, order.getOrderDate());
			callableStatement.setString(5, order.getOrderPhone());
			callableStatement.setString(6, order.getOrderPostalCode());
			callableStatement.setInt(7, order.getState().getStateId());
			callableStatement.setString(8, order.getOrderCity());
			callableStatement.setString(9, order.getOrderAddress1());
			callableStatement.setString(10, order.getOrderAddress2());
			callableStatement.setString(11, order.getOrderId());
			affectedRow = callableStatement.executeUpdate();
		} catch (SQLException e) {
			DbLogging.LOG.error("Error Database exception", e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (callableStatement != null) {
					callableStatement.close();
				}
			} catch (Exception e) {
				DbLogging.LOG.error("Error Database exception", e);
			}
		}
		return affectedRow;
	}

	@Override
	public int addOrderDetail(OrderDetail orderDetail) {
		int affectedRow = 0;
		try {
			connection = DatabaseConnect.getInstance().getConnection();
			callableStatement = connection.prepareCall(DbQuery.INSERT_NEW_ORDER_DETAIL);
			callableStatement.setString(1, orderDetail.getOrder().getOrderId());
			callableStatement.setString(2, orderDetail.getProduct().getId());
			callableStatement.setInt(3, orderDetail.getTotalQuantity());
			callableStatement.setDouble(4, orderDetail.getTotalAmount());
			
			affectedRow = callableStatement.executeUpdate();
		} catch (SQLException e) {
			DbLogging.LOG.error("Error Database exception", e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (callableStatement != null) {
					callableStatement.close();
				}
			} catch (Exception e) {
				DbLogging.LOG.error("Error Database exception", e);
			}
		}
		return affectedRow;
	}

}
