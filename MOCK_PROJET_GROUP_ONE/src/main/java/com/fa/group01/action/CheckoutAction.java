/**
 * 
 */
package com.fa.group01.action;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.interceptor.SessionAware;

import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.countrydao.impl.CountryDAOImpl;
import com.fa.group01.dao.orderdao.impl.OrderDAOImpl;
import com.fa.group01.dao.statedao.impl.StateDAOImpl;
import com.fa.group01.entity.Country;
import com.fa.group01.entity.Order;
import com.fa.group01.entity.OrderDetail;
import com.fa.group01.entity.Product;
import com.fa.group01.entity.State;
import com.fa.group01.entity.User;
import com.fa.group01.interceptor.UserAware;
import com.fa.group01.logging.DbLogging;
import com.fa.group01.service.countryservice.impl.CountryServiceImpl;
import com.fa.group01.service.orderservice.impl.OrderServiceImpl;
import com.fa.group01.service.stateservice.impl.StateServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * @author DungHN2
 *
 */
public class CheckOutAction extends ActionSupport implements UserAware, Preparable, SessionAware {

	private static final long serialVersionUID = 4621243169647973548L;
	private List<State> states;
	private List<Country> countries;
	private Order order;
	private User user;
	private Country country;
	private State state;
	private StateDAOImpl stateDao;
	private CountryDAOImpl countryDao;
	private StateServiceImpl stateService;
	private CountryServiceImpl countryService;
	private OrderDAOImpl orderDao;
	private OrderServiceImpl orderService;
	
	private Map<String, Object> cartSession;
	private Map<Product, Integer> cart;
	private int totalQuantity;
	private double totalAmout;

	@SuppressWarnings("unchecked")
	@Override
	public void prepare() throws Exception {
		stateDao = new StateDAOImpl();
		countryDao = new CountryDAOImpl();
		stateService = new StateServiceImpl(stateDao);
		countryService = new CountryServiceImpl(countryDao);
		orderDao = new OrderDAOImpl();
		orderService = new OrderServiceImpl(orderDao);
		this.cart = (Map<Product, Integer>) cartSession.get("cart");
	}

	/**
	 * Go to checkout page
	 * 
	 * @return
	 */
	public String checkOut() {
		countries = countryService.findAll();
		states = stateService.findAll();
		totalQuantity = 0;
		totalAmout = 0;
		if(!cart.isEmpty() && cart != null) {
			for(Product product: cart.keySet()) {
				totalQuantity += cart.get(product);
				double amount = cart.get(product) * product.getPrice();
				totalAmout += amount;
			}
		}
		return PageConstant.SUCCESS;
	}

	/**
	 * Put the input from the check out form into the database
	 * 
	 * @return
	 */
	public String checkOutCart() {
		state = stateService.findById(state);
		country = countryService.findByID(country);
		user = (User) ActionContext.getContext().getSession().get("authenticatedUser");
		String randomCode = UUID.randomUUID().toString();
		order = orderService.setOrder(order, state, country, user, randomCode);
		int affectedRow = orderService.addOrder(order);
		
		int totalQuantity = 0;
		double totalAmout = 0;
		for (Product product : cart.keySet()) {
			double amout = cart.get(product) * product.getPrice();
			totalQuantity += cart.get(product);
			totalAmout += amout;
			
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrder(order);
			orderDetail.setProduct(product);
			orderDetail.setTotalQuantity(totalQuantity);
			orderDetail.setTotalAmount(totalAmout);
			orderService.addOrderDetail(orderDetail);
		}
		
		
		if (affectedRow > 0) {
			DbLogging.LOG.info("Check Out Success");
			cart.clear();
			return PageConstant.SUCCESS;
		} else {
			DbLogging.LOG.error("Check Out Error");
			return PageConstant.ERROR;
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.cartSession = session;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public double getTotalAmout() {
		return totalAmout;
	}

	public void setTotalAmout(double totalAmout) {
		this.totalAmout = totalAmout;
	}

}
