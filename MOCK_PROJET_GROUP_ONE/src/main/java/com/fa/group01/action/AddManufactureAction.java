/**
 * 
 */
package com.fa.group01.action;

import java.sql.SQLException;

import com.fa.group01.constants.PagesConstants;
import com.fa.group01.entity.Manufacture;
import com.fa.group01.logging.DbLogging;
import com.fa.group01.service.ManufactureService;
import com.fa.group01.service.impl.ManufactureServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author nguyenthanhlinh
 *
 */
public class AddManufactureAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ManufactureService manufactureService;
	private Manufacture manufacture;
	private String message;

	/**
	 * 
	 */
	public AddManufactureAction() {
		this.manufactureService = new ManufactureServiceImpl();
	}

	/**
	 * @return
	 */
	public String addManufacture() {
		int isAddSuccess = 0;
		try {
			isAddSuccess = this.manufactureService.save(manufacture);
		} catch (SQLException e) {
			DbLogging.LOGGER.error("SQLException");
		}
		if (isAddSuccess > 0) {
			this.message = "Add Success!!!";
			return PagesConstants.SUCCESS;
		}
		this.message = "Add Fail!!!";
		return PagesConstants.ERROR;
	}

	/**
	 * @return the manufacture
	 */
	public Manufacture getManufacture() {
		return manufacture;
	}

	/**
	 * @param manufacture the manufacture to set
	 */
	public void setManufacture(Manufacture manufacture) {
		this.manufacture = manufacture;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
