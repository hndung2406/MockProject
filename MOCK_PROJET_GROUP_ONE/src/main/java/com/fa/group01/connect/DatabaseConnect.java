/**
 * 
 */
package com.fa.group01.connect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * @author DungHN2
 *
 */
public class DatabaseConnect {

	private static Connection connection;
	/**
	 * @return
	 */
	public static Connection getConnection() {
		Properties properties = new Properties();
		try {
			properties.load(DatabaseConnect.class.getResourceAsStream("/dbconfig.properties"));
			final String driver = properties.getProperty("driver");
			final String server = properties.getProperty("server");
			final String user = properties.getProperty("user");
			final String pass = properties.getProperty("pass");
			Class.forName(driver);
			connection = DriverManager.getConnection(server, user, pass);
		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return connection;
	}
	
}
