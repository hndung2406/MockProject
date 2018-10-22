package com.fa.group01.dao.productdao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fa.group01.connect.DatabaseConnect;
import com.fa.group01.dao.productdao.ProductDAO;
import com.fa.group01.entity.Manufacture;
import com.fa.group01.entity.Product;

@RunWith(MockitoJUnitRunner.class)
public class ProductDAOImplTest {

	@InjectMocks
	private ProductDAOImpl productDao;

	@Mock
	private Connection mockConnection;
	@Mock
	private PreparedStatement mockPreparedStatement;
	@Mock
	private DatabaseConnect mockDatabaseConnect;
	@Mock
	private DataSource dataSource;

	private static Product product;

	static {
		Manufacture manufacture = new Manufacture(1, "Apple");
		product = new Product("P001", "Name", 123, "Description", "imageUrl", 3, "condition", new Date(2018, 11, 19),
				"spec", "properties", manufacture);
	}

	@Before
	public void setUp() throws Exception {
		Mockito.when(mockDatabaseConnect.getConnection()).thenReturn(mockConnection);
		Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
		Mockito.doNothing().when(mockPreparedStatement).setString(Mockito.anyInt(), Mockito.anyString());
		Mockito.doNothing().when(mockPreparedStatement).setInt(Mockito.anyInt(), Mockito.anyInt());
		Mockito.doNothing().when(mockPreparedStatement).setDouble(Mockito.anyInt(), Mockito.anyDouble());
		Mockito.doNothing().when(mockPreparedStatement).setDate(Mockito.anyInt(), Mockito.any());
		Mockito.when(mockPreparedStatement.executeUpdate()).thenReturn(1);
	}

	@Test
	public void testAddProductWithNoExceptions() throws SQLException {

//		ProductDAO instance = new ProductDAOImpl();
		productDao.addProduct(product);

		// verify and assert
//		Mockito.verify(mockConnection, Mockito.times(1)).prepareStatement(Mockito.anyString());
//		Mockito.verify(mockPreparedStatement).setString(Mockito.anyInt(), Mockito.anyString());
//		Mockito.verify(mockPreparedStatement).executeUpdate();
	}

}
