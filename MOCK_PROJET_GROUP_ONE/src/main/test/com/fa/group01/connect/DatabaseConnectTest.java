package com.fa.group01.connect;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class DatabaseConnectTest {

	@Test
	public void TestConnectionIsNotNull() {
		Connection connection = DatabaseConnect.getConnection();
		assertNotEquals(connection,null);
	}

}
