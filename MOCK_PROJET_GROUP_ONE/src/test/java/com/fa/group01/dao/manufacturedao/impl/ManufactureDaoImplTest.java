/**
 * 
 */
package com.fa.group01.dao.manufacturedao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fa.group01.dao.manufacture.ManufactureDAO;
import com.fa.group01.dao.manufacture.impl.ManufactureDAOImpl;
import com.fa.group01.entity.Manufacture;

/**
 * @author DungHN2
 *
 */
public class ManufactureDaoImplTest {

	private ManufactureDAO manufactureDao;
	private Manufacture manufacture;

	@Before
	public void setUp() throws Exception {
		manufactureDao = new ManufactureDAOImpl();
		manufacture = new Manufacture();
	}
	
	@Test
	public void addManufactureAlreadyInDatabase () {
		manufacture = new Manufacture(1, "Apple");
		int result = manufactureDao.addManufacture(manufacture);
		assertEquals(0, result);
	}
	
	@Test
	public void addManufactureNotInDatabase () {
		manufacture = new Manufacture();
		manufacture.setManufactureName("Test");
		int result = manufactureDao.addManufacture(manufacture);
		assertEquals(1, result);
	}
	
	@Test
	public void findAll() {
		List<Manufacture> manufactures = manufactureDao.findAll();
		assertEquals(7, manufactures.size());
	}
	
	@Test
	public void findById() {
		manufacture = manufactureDao.findById(2);
		assertEquals(1, manufacture.getManufactureId());
	}
}
