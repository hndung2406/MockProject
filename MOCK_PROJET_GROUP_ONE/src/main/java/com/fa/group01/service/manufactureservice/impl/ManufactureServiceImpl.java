/**
 * 
 */
package com.fa.group01.service.manufactureservice.impl;

import java.sql.SQLException;

import com.fa.group01.dao.manufacture.ManufactureDAO;
import com.fa.group01.dao.manufacture.impl.ManufactureDAOImpl;
import com.fa.group01.entity.Manufacture;
import com.fa.group01.service.manufactureservice.ManufactureService;

/**
 * @author nguyenthanhlinh
 *
 */
public class ManufactureServiceImpl implements ManufactureService {

	private ManufactureDAO manufactureDao;

	/**
	 * Constructor
	 */
	public ManufactureServiceImpl(ManufactureDAO manufactureDao) {
		this.manufactureDao = manufactureDao;
	}

	@Override
	public int addManufacture(Manufacture manufacture) throws SQLException {
		return manufactureDao.addManufacture(manufacture);
	}

}
