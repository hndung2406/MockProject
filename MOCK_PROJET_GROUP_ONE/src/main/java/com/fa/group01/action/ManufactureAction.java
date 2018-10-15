/**
 * 
 */
package com.fa.group01.action;

import java.sql.SQLException;

import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.manufacture.ManufactureDAO;
import com.fa.group01.dao.manufacture.impl.ManufactureDAOImpl;
import com.fa.group01.entity.Manufacture;
import com.fa.group01.logging.DbLogging;
import com.fa.group01.service.manufactureservice.ManufactureService;
import com.fa.group01.service.manufactureservice.impl.ManufactureServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author nguyenthanhlinh
 *
 */
public class ManufactureAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ManufactureService manufactureService;
	private Manufacture manufacture;
	private String message;
	private ManufactureDAO manufactureDao = new ManufactureDAOImpl();

	/**
	 * 
	 */
	public ManufactureAction() {
		this.manufactureService = new ManufactureServiceImpl(manufactureDao);
	}

	/**
	 * @return
	 */
	public String addManufacture() {
		int isAddSuccess = 0;
		try {
			isAddSuccess = manufactureService.addManufacture(manufacture);
		} catch (SQLException e) {
			DbLogging.LOG.error("SQLException", e);
		}
		if (isAddSuccess > 0) {
			this.message = "Add Success!";
			return PageConstant.SUCCESS;
		}
		this.message = "Add Fail!";
		return PageConstant.ERROR;
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
