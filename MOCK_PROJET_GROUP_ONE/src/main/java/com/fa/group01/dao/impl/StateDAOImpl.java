/**
 * 
 */
package com.fa.group01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fa.group01.connect.DatabaseConnect;
import com.fa.group01.constants.DbQuery;
import com.fa.group01.dao.StateDAO;
import com.fa.group01.entity.State;

/**
 * @author nguyenthanhlinh
 *
 */
public class StateDAOImpl implements StateDAO {

	/* (non-Javadoc)
	 * @see com.fa.group01.dao.StateDAO#save(com.fa.group01.entity.State)
	 */
	@Override
	public int save(State state) throws SQLException {
		Connection conn = DatabaseConnect.getConnection();
		PreparedStatement pstm = null;
		int affectedRow = 0;

		try {
			pstm = conn.prepareStatement(DbQuery.SAVE_NEW_STATE);
			pstm.setString(1, state.getStateName());
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
