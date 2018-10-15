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
	public int addManufacture(Manufacture manufacture) throws SQLException;
	
	/**
	 * @return
	 * @throws SQLException
	 */
	List<Manufacture> findAll() throws SQLException;
	
	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Manufacture findById(int id) throws SQLException;

}
