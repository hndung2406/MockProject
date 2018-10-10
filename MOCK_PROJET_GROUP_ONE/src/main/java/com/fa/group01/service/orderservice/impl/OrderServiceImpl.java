/**
 * 
 */
package com.fa.group01.service.orderservice.impl;

import java.sql.SQLException;

import com.fa.group01.dao.orderdao.OrderDAO;
import com.fa.group01.entity.Order;
import com.fa.group01.service.orderservice.OrderService;

/**
 * @author DungHN2
 *
 */
public class OrderServiceImpl implements OrderService {

	private OrderDAO orderDao;

	public OrderServiceImpl(OrderDAO orderDao) {
		super();
		this.orderDao = orderDao;
	}

	@Override
	public int addOrder(Order order) throws SQLException {
		return orderDao.addOrder(order);
	}
	
	
	
}
