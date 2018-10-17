/**
 * 
 */
package com.fa.group01.action;


import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.manufacture.ManufactureDAO;
import com.fa.group01.dao.manufacture.impl.ManufactureDAOImpl;
import com.fa.group01.entity.Manufacture;
import com.fa.group01.service.manufactureservice.ManufactureService;
import com.fa.group01.service.manufactureservice.impl.ManufactureServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * @author nguyenthanhlinh
 *
 */
public class ManufactureAction extends ActionSupport implements Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ManufactureService manufactureService;
	private Manufacture manufacture;
	private String message;
	private ManufactureDAO manufactureDao;

	
	@Override
	public void prepare() throws Exception {
		manufactureDao = new ManufactureDAOImpl();
		manufactureService = new ManufactureServiceImpl(manufactureDao);
	}

	/**
	 * @return
	 */
	public String addManufacture() {
		int isAddSuccess = manufactureService.addManufacture(manufacture);
		if (isAddSuccess > 0) {
			this.message = "Add Success!";
			return PageConstant.SUCCESS;
		} else {
			this.message = "Add Fail!";
			return PageConstant.ERROR;
		}
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
