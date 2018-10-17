/**
 * 
 */
package com.fa.group01.action;


import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.countrydao.CountryDAO;
import com.fa.group01.dao.countrydao.impl.CountryDAOImpl;
import com.fa.group01.entity.Country;
import com.fa.group01.service.countryservice.CountryService;
import com.fa.group01.service.countryservice.impl.CountryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * @author DungHN2
 *
 */
public class CountryAction extends ActionSupport implements Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6706314336271841645L;
	private CountryService countryService;
	private CountryDAO countryDao;
	private Country country;
	private String message;

	@Override
	public void prepare() throws Exception {
		countryDao = new CountryDAOImpl();
		countryService = new CountryServiceImpl(countryDao);
	}


	public String addCountry() {
		int isAddSuccess = 0;
		isAddSuccess = countryService.addCountry(country);
		if (isAddSuccess > 0) {
			message = "Add Success!";
			return PageConstant.SUCCESS;
		} else {
			message = "Add Fail!";
			return PageConstant.ERROR;
		}
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
