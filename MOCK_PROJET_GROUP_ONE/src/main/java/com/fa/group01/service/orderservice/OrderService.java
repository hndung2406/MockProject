/**
 * 
 */
package com.fa.group01.service.orderservice;

import java.sql.SQLException;

import com.fa.group01.entity.Country;
import com.fa.group01.entity.Order;
import com.fa.group01.entity.State;
import com.fa.group01.entity.User;

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
	public int addOrder(Order order);
	
	/**
	 * @param order
	 * @param state
	 * @param country
	 * @param user
	 * @return
	 */
	public Order setOrder(Order order, State state, Country country, User user);
	
}
