/**
 * 
 */
package com.fa.group01.action;

import java.util.List;
import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.countrydao.impl.CountryDAOImpl;
import com.fa.group01.dao.orderdao.impl.OrderDAOImpl;
import com.fa.group01.dao.statedao.impl.StateDAOImpl;
import com.fa.group01.entity.Country;
import com.fa.group01.entity.Order;
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
public class CheckOutAction extends ActionSupport implements UserAware, Preparable {

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

	@Override
	public void prepare() throws Exception {
		stateDao = new StateDAOImpl();
		countryDao = new CountryDAOImpl();
		stateService = new StateServiceImpl(stateDao);
		countryService = new CountryServiceImpl(countryDao);
		orderDao = new OrderDAOImpl();
		orderService = new OrderServiceImpl(orderDao);
	}

	/**
	 * Go to checkout page
	 * 
	 * @return
	 */
	public String checkOut() {
		countries = countryService.findAll();
		states = stateService.findAll();
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
		orderService.setOrder(order, state, country, user);
		int affectedRow = orderService.addOrder(order);
		if (affectedRow > 0) {
			DbLogging.LOG.info("Check Out Success");
			return PageConstant.SUCCESS;
		} else {
			DbLogging.LOG.error("Check Out Error");
			return PageConstant.ERROR;
		}
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
