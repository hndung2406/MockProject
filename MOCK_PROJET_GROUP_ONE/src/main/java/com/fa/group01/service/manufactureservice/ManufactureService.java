/**
 * 
 */
package com.fa.group01.service.manufactureservice;

import java.sql.SQLException;
import java.util.List;

import com.fa.group01.entity.Manufacture;

/**
 * @author nguyenthanhlinh
 *
 */
public interface ManufactureService {

	/**
	 * @param manufacture
	 * @return
	 * @throws SQLException
	 */
	public int addManufacture(Manufacture manufacture);

	/**
	 * @return
	 * @throws SQLException
	 */
	List<Manufacture> findAll();

	/**
	 * @return
	 * @throws SQLException
	 */
	public Manufacture findById(int id);

}
