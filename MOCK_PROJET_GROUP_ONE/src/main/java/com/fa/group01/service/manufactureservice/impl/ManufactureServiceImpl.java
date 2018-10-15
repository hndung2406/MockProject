/**
 * 
 */
package com.fa.group01.service.manufactureservice.impl;

import java.sql.SQLException;
import java.util.List;

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

	/**
	 * Add manufacture to the database
	 * 
	 * @param manufacture
	 * @return
	 * @throws SQLException
	 */
	@Override
	public int addManufacture(Manufacture manufacture) throws SQLException {
		return manufactureDao.addManufacture(manufacture);
	}

	/**
	 * Find All Manufacture
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<Manufacture> findAll() throws SQLException {
		return manufactureDao.findAll();
	}

	@Override
	public Manufacture findById(int manufactureId) throws SQLException {
		return manufactureDao.findById(manufactureId);
	}

}
