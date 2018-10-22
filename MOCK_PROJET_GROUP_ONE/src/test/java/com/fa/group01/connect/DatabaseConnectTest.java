package com.fa.group01.connect;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assume.assumeTrue;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.NotNull;

public class DatabaseConnectTest {

	@Mock
	private DatabaseConnect databaseConnect;

	private Connection connection;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		connection = Mockito.mock(Connection.class);
	}

	@Test
	public void testCanGetConnection() throws SQLException {	
		
		assertNotEquals(connection, null);
	}

	@Test
	public void testCanCloseConnection() throws SQLException {
		assertNotNull(connection);
		databaseConnect.close(connection);
		Mockito.verify(databaseConnect).close(connection);
	}

	@Test
	public void testCanCloseResultSet() throws SQLException {

		ResultSet resultSet = Mockito.mock(ResultSet.class);
		assertNotNull(resultSet);
		databaseConnect.close(resultSet);
		Mockito.verify(databaseConnect).close(resultSet);
	}
	
	@Test
	public void testCanClosePrepareStatement() throws SQLException {

		PreparedStatement prepareStatement = Mockito.mock(PreparedStatement.class);
		assertNotNull(prepareStatement);
		databaseConnect.close(prepareStatement);
		Mockito.verify(databaseConnect).close(prepareStatement);
	}
	
	@Test
	public void testCanCloseStatement() throws SQLException {

		Statement statement = Mockito.mock(Statement.class);
		assertNotNull(statement);
		databaseConnect.close(statement);
		Mockito.verify(databaseConnect).close(statement);
	}
	
	@Test
	public void testCanCloseCallableStatement() throws SQLException {

		CallableStatement callableStatement = Mockito.mock(CallableStatement.class);
		assertNotNull(callableStatement);
		databaseConnect.close(callableStatement);
		Mockito.verify(databaseConnect).close(callableStatement);
	}	
	
	

}
