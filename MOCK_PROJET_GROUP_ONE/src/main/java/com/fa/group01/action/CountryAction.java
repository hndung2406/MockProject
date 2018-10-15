/**
 * 
 */
package com.fa.group01.action;

import java.sql.SQLException;

import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.countrydao.CountryDAO;
import com.fa.group01.dao.countrydao.impl.CountryDAOImpl;
import com.fa.group01.entity.Country;
import com.fa.group01.logging.DbLogging;
import com.fa.group01.service.countryservice.CountryService;
import com.fa.group01.service.countryservice.impl.CountryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author DungHN2
 *
 */
public class CountryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6706314336271841645L;
	private CountryService countryService;
	private CountryDAO countryDao = new CountryDAOImpl();
	private Country country;
	private String message;

	public CountryAction() {
		countryService = new CountryServiceImpl(countryDao);
	}

	public String addCountry() {
		int isAddSuccess = 0;
		try {
			isAddSuccess = countryService.addCountry(country);
		} catch (SQLException e) {
			DbLogging.LOG.error("SQLException", e);
		}
		if (isAddSuccess > 0) {
			message = "Add Success!";
			return PageConstant.SUCCESS;
		}
		message = "Add Fail!";
		return PageConstant.ERROR;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
