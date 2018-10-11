/**
 * 
 */
package com.fa.group01.dao.orderdao;

import java.sql.SQLException;

import com.fa.group01.entity.Order;

/**
 * @author DungHN2
 *
 */
public interface OrderDAO {

	/**
	 * @param order
	 * @return
	 * @throws SQLException
	 */
	public int addOrder(Order order) throws SQLException;
	
}
