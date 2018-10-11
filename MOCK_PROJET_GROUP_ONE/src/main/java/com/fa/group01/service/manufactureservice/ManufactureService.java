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
	int addManufacture(Manufacture manufacture) throws SQLException;
	
	/**
	 * @return
	 * @throws SQLException
	 */
	List<Manufacture> findAll() throws SQLException;

}
