/**
 * 
 */
package com.fa.group01.service;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fa.group01.dao.orderdao.OrderDAO;
import com.fa.group01.entity.Country;
import com.fa.group01.entity.Order;
import com.fa.group01.entity.OrderDetail;
import com.fa.group01.entity.Product;
import com.fa.group01.entity.State;
import com.fa.group01.entity.User;
import com.fa.group01.service.orderservice.impl.OrderServiceImpl;

/**
 * @author DungHN2
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

	@InjectMocks
	OrderServiceImpl orderService;
	
	@Mock
	OrderDAO orderDao;
	
	private static OrderDetail orderDetail;
	private static Order order;
	private static Product product;
	
	static {
		product = new Product();
		order = new Order();
		orderDetail = new OrderDetail(1, order, product, 10, 20.0);
	}
	
	@Test
	public void testAddOrderDetailSuccess() {
		Mockito.when(orderDao.addOrderDetail(orderDetail)).thenReturn(1);
		assertEquals(1, orderService.addOrderDetail(orderDetail));
		Mockito.verify(orderDao, Mockito.times(1)).addOrderDetail(orderDetail);
	}
	
	@Test
	public void testAddOrderDetailFail() {
		Mockito.when(orderDao.addOrderDetail(orderDetail)).thenReturn(0);
		assertEquals(0, orderService.addOrderDetail(orderDetail));
		Mockito.verify(orderDao, Mockito.times(1)).addOrderDetail(orderDetail);
	}
	
	@Test
	public void testAddOrderSuccess() {
		Mockito.when(orderDao.addOrder(order)).thenReturn(1);
		assertEquals(1, orderService.addOrder(order));
		Mockito.verify(orderDao, Mockito.times(1)).addOrder(order);
	}
	
	@Test
	public void testAddOrderFail() {
		Mockito.when(orderDao.addOrder(order)).thenReturn(0);
		assertEquals(0, orderService.addOrder(order));
		Mockito.verify(orderDao, Mockito.times(1)).addOrder(order);
	}
	
	@Test
	public void testSetOrder() {
		Order orderTest = new Order();
		Order orderResult = new Order();
		State state = new State();
		Country country = new Country();
		User user = new User();
		orderResult.setState(state);
		orderResult.setCountry(country);
		orderResult.setOrderDate(new Date(2018, 11, 19));
		orderResult.setUser(user);
		orderResult.setOrderId("123");
		assertEqual(orderResult, orderService.setOrder(orderTest, state, country, user, "123"));
	}

	/**
	 * @param orderResult
	 * @param setOrder
	 */
	private void assertEqual(Order orderResult, Order setOrder) {
		// TODO Auto-generated method stub
		
	}


}
