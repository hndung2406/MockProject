/**
 * 
 */
package com.fa.group01.entity;

import java.sql.Date;

/**
 * @author DungHN2
 *
 */
public class Order {

	private String orderId;
	private User user;
	private String orderCardNumber;
	private Country country;
	private Date orderDate;
	private String orderPhone;
	private String orderPostalCode;
	private State state;
	private String orderCity;
	private String orderAddress1;
	private String orderAddress2;
	
	public Order(String orderId, User user, String orderCardNumber, Country country, Date orderDate, String orderPhone,
			String orderPostalCode, State state, String orderCity, String orderAddress1, String orderAddress2) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.orderCardNumber = orderCardNumber;
		this.country = country;
		this.orderDate = orderDate;
		this.orderPhone = orderPhone;
		this.orderPostalCode = orderPostalCode;
		this.state = state;
		this.orderCity = orderCity;
		this.orderAddress1 = orderAddress1;
		this.orderAddress2 = orderAddress2;
	}
	
	public Order() {
		
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOrderCardNumber() {
		return orderCardNumber;
	}

	public void setOrderCardNumber(String orderCardNumber) {
		this.orderCardNumber = orderCardNumber;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public String getOrderPostalCode() {
		return orderPostalCode;
	}

	public void setOrderPostalCode(String orderPostalCode) {
		this.orderPostalCode = orderPostalCode;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getOrderCity() {
		return orderCity;
	}

	public void setOrderCity(String orderCity) {
		this.orderCity = orderCity;
	}

	public String getOrderAddress1() {
		return orderAddress1;
	}

	public void setOrderAddress1(String orderAddress1) {
		this.orderAddress1 = orderAddress1;
	}

	public String getOrderAddress2() {
		return orderAddress2;
	}

	public void setOrderAddress2(String orderAddress2) {
		this.orderAddress2 = orderAddress2;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", user=" + user + ", orderCardNumber=" + orderCardNumber + ", country="
				+ country + ", orderDate=" + orderDate + ", orderPhone=" + orderPhone + ", orderPostalCode="
				+ orderPostalCode + ", state=" + state + ", orderCity=" + orderCity + ", orderAddress1=" + orderAddress1
				+ ", orderAddress2=" + orderAddress2 + "]";
	}
	
}
