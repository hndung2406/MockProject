/**
 * 
 */
package com.fa.group01.service.orderservice;

import java.sql.SQLException;

import com.fa.group01.entity.Order;

/**
 * @author DungHN2
 *
 */
public interface OrderService {

	/**
	 * @param order
	 * @return
	 * @throws SQLException
	 */
	public int addOrder(Order order) throws SQLException;
	
}
