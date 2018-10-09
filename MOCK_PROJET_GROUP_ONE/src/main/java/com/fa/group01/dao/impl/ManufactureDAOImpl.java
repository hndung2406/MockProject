/**
 * 
 */
package com.fa.group01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fa.group01.connect.DatabaseConnect;
import com.fa.group01.constants.DbQuery;
import com.fa.group01.dao.ManufactureDAO;
import com.fa.group01.entity.Manufacture;

/**
 * @author nguyenthanhlinh
 *
 */
public class ManufactureDAOImpl implements ManufactureDAO {

	/* (non-Javadoc)
	 * @see com.fa.group01.dao.ManufactureDAO#save(com.fa.group01.entity.Manufacture)
	 */
	@Override
	public int save(Manufacture manufacture) throws SQLException {
		Connection conn = DatabaseConnect.getConnection();
		PreparedStatement pstm = null;
		int affectedRow = 0;

		try {
			pstm = conn.prepareStatement(DbQuery.SAVE_NEW_MANUFACTURE);
			pstm.setString(1, manufacture.getName());
			affectedRow = pstm.executeUpdate();
		} finally {
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return affectedRow;

	}

}
