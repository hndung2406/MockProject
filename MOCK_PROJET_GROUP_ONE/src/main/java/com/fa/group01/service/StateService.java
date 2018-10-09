/**
 * 
 */
package com.fa.group01.service;

import java.sql.SQLException;

import com.fa.group01.entity.State;

/**
 * @author nguyenthanhlinh
 *
 */
public interface StateService {

	int save(State state) throws SQLException;

}
