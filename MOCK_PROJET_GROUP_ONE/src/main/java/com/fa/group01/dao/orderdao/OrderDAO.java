/**
 * 
 */
package com.fa.group01.dao.orderdao;

import java.sql.SQLException;

import com.fa.group01.entity.Order;
import com.fa.group01.entity.OrderDetail;

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
	public int addOrder(Order order);
	
	/**
	 * @param orderDetail
	 * @return
	 */
	public int addOrderDetail(OrderDetail orderDetail);
	
}
