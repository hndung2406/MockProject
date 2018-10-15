/**
 * 
 */
package com.fa.group01.dao.manufacture;

import java.sql.SQLException;
import java.util.List;

import com.fa.group01.entity.Manufacture;

/**
 * @author nguyenthanhlinh
 *
 */
public interface ManufactureDAO {
	
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
	
	/**
	 * @param manufactureId
	 * @return
	 * @throws SQLException
	 */
	Manufacture findById(int manufactureId) throws SQLException;

}
