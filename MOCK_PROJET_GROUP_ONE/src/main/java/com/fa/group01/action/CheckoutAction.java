/**
 * 
 */
package com.fa.group01.action;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.countrydao.CountryDAO;
import com.fa.group01.dao.countrydao.impl.CountryDAOImpl;
import com.fa.group01.dao.orderdao.OrderDAO;
import com.fa.group01.dao.orderdao.impl.OrderDAOImpl;
import com.fa.group01.dao.statedao.StateDAO;
import com.fa.group01.dao.statedao.impl.StateDAOImpl;
import com.fa.group01.entity.Country;
import com.fa.group01.entity.Order;
import com.fa.group01.entity.State;
import com.fa.group01.entity.User;
import com.fa.group01.interceptor.UserAware;
import com.fa.group01.logging.DbLogging;
import com.fa.group01.service.countryservice.CountryService;
import com.fa.group01.service.countryservice.impl.CountryServiceImpl;
import com.fa.group01.service.orderservice.OrderService;
import com.fa.group01.service.orderservice.impl.OrderServiceImpl;
import com.fa.group01.service.stateservice.StateService;
import com.fa.group01.service.stateservice.impl.StateServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author DungHN2
 *
 */
public class CheckOutAction extends ActionSupport implements UserAware {

	private static final long serialVersionUID = 4621243169647973548L;
	private StateDAO stateDao = new StateDAOImpl();
	private CountryDAO countryDao = new CountryDAOImpl();
	private StateService stateService = new StateServiceImpl(stateDao);
	private CountryService countryService = new CountryServiceImpl(countryDao);
	private OrderDAO orderDao = new OrderDAOImpl();
	private OrderService orderService = new OrderServiceImpl(orderDao);
	private List<State> states;
	private List<Country> countries;
	private Order order;
	private User user;
	private Country country;
	private State state;

	/**
	 * Go to checkout page
	 * @return
	 */
	public String checkOut() {
		try {
			countries = countryService.findAll();
			states = stateService.findAll();
		} catch (SQLException e) {
			DbLogging.LOG.error("ERROR!", e);
		}
		return PageConstant.SUCCESS;
	}
	
	/**
	 * Put the input from the check out form into the database
	 * @return
	 */
	public String checkOutCart() {
		try {
			int affectedRow = 0;
			java.sql.Date createDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			state = stateService.findById(state);
			country = countryService.findByID(country);
			user = (User) ActionContext.getContext().getSession().get("authenticatedUser");
			order.setState(state);
			order.setCountry(country);
			order.setOrderDate(createDate);
			if(user == null) {
				user = new User();
				user.setUserId(1);
				order.setUser(user);
			} else {
				order.setUser(user);
			}
			affectedRow = orderService.addOrder(order);
			if(affectedRow > 0) {
				DbLogging.LOG.info("SUCCESS");
				return PageConstant.SUCCESS;
			} else {
				DbLogging.LOG.error("ERROR");
				return PageConstant.ERROR;
			}
		} catch (SQLException e) {
			DbLogging.LOG.error("ERROR", e);			
		}
		return PageConstant.ERROR;
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
	
}
