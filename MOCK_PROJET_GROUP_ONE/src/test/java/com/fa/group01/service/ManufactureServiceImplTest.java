/**
 * 
 */
package com.fa.group01.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fa.group01.dao.manufacture.ManufactureDAO;
import com.fa.group01.entity.Manufacture;
import com.fa.group01.service.manufactureservice.impl.ManufactureServiceImpl;

/**
 * @author DungHN2
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ManufactureServiceImplTest {

	@InjectMocks
	ManufactureServiceImpl manufactureService;
	
	@Mock
	ManufactureDAO manufactureDao;
	
	private static Manufacture manufacture;
	private static int manufactureId;
	private static List<Manufacture> manufactures;
	private static List<Manufacture> emptyManufactures;
	
	static {
		manufacture = new Manufacture(1, "Apple");
		manufactureId = 1;
		manufactures = Arrays.asList(manufacture);
		emptyManufactures = null;
	}
	
	@Test
	public void testAddManufactureSuccess() {
		Mockito.when(manufactureDao.addManufacture(manufacture)).thenReturn(1);
		assertEquals(1, manufactureService.addManufacture(manufacture));
		Mockito.verify(manufactureDao, Mockito.times(1)).addManufacture(manufacture);
	}
	
	@Test
	public void testAddManufactureFail() {
		Mockito.when(manufactureDao.addManufacture(manufacture)).thenReturn(0);
		assertEquals(0, manufactureService.addManufacture(manufacture));
		Mockito.verify(manufactureDao, Mockito.times(1)).addManufacture(manufacture);
	}
	
	@Test
	public void testFindAllManufacture() {
		Mockito.when(manufactureDao.findAll()).thenReturn(manufactures);
		assertEquals(1, manufactureService.findAll().size());
		Mockito.verify(manufactureDao).findAll();
	}
	
	@Test
	public void testFindAllManufactureReturnNull() {
		Mockito.when(manufactureDao.findAll()).thenReturn(emptyManufactures);
		assertNull(manufactureService.findAll());
		Mockito.verify(manufactureDao).findAll();
	}
	
	@Test
	public void testFindById() {
		Mockito.when(manufactureDao.findById(manufactureId)).thenReturn(manufacture);
		assertEquals(manufacture, manufactureService.findById(manufactureId));
		Mockito.verify(manufactureDao).findById(manufactureId);
	}
	
}
