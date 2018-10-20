package com.fa.group01.connect;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DatabaseConnectTest {

	private Connection connection;
	
	@Before
	public void setUp() throws Exception {
		connection = DatabaseConnect.getInstance().getConnection();
	}
	
	@Rule 
	public ExpectedException expectedException  = ExpectedException.none();

	@Test
	public void CanGetConnection() throws SQLException {
		assertNotEquals(connection, null);
	}
	
	@Test
	public void CanCloseConnection() throws SQLException {
		DatabaseConnect.getInstance().close(connection);
		assertTrue(connection.isClosed());
	}
	
	

}
