/**
 * 
 */
package com.fa.group01.service.impl;

import java.sql.SQLException;

import com.fa.group01.dao.ManufactureDAO;
import com.fa.group01.dao.impl.ManufactureDAOImpl;
import com.fa.group01.entity.Manufacture;
import com.fa.group01.service.ManufactureService;

/**
 * @author nguyenthanhlinh
 *
 */
public class ManufactureServiceImpl implements ManufactureService {

	private ManufactureDAO manufactureDAO;

	/**
	 * Constructor
	 */
	public ManufactureServiceImpl() {
		this.manufactureDAO = new ManufactureDAOImpl();
	}

	/* (non-Javadoc)
	 * @see com.fa.group01.service.ManufactureService#save(com.fa.group01.entity.Manufacture)
	 */
	@Override
	public int save(Manufacture manufacture) throws SQLException {
		return this.manufactureDAO.save(manufacture);
	}

}
