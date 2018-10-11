/**
 * 
 */
package com.fa.group01.dao.productdao;

import java.sql.SQLException;

import com.fa.group01.entity.Product;

/**
 * @author nguyenthanhlinh
 *
 */
public interface ProductDAO {
	
	int save(Product product) throws SQLException;

}
