/**
 * 
 */
package com.fa.group01.entity;

/**
 * @author DungHN2
 *
 */
public class OrderDetail {

	private int orderDetailId;
	private Order order;
	private Product product;
	private int totalQuantity;
	private double totalAmount;
	
	public OrderDetail(int orderDetailId, Order order, Product product, int totalQuantity, double totalAmount) {
		super();
		this.orderDetailId = orderDetailId;
		this.order = order;
		this.product = product;
		this.totalQuantity = totalQuantity;
		this.totalAmount = totalAmount;
	}
	
	public OrderDetail() {
		
	}
	
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	
}
