/**
 * 
 */
package com.fa.group01.service.orderservice.impl;

import java.util.Calendar;

import com.fa.group01.dao.orderdao.OrderDAO;
import com.fa.group01.entity.Country;
import com.fa.group01.entity.Order;
import com.fa.group01.entity.State;
import com.fa.group01.entity.User;
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
	public int addOrder(Order order){
		return orderDao.addOrder(order);
	}
	@Override
	public Order setOrder(Order order, State state, Country country, User user) {
		java.sql.Date createDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		order.setState(state);
		order.setCountry(country);
		order.setOrderDate(createDate);
		order.setUser(user);
		return order;
	}
	
}
