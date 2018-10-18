/**
 * 
 */
package com.fa.group01.connect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.fa.group01.logging.DbLogging;


/**
 * @author DungHN2
 *
 */
public class DatabaseConnect {

	private static DatabaseConnect instance;
	private Connection connection;
	/**
	 * @return
	 */
	private DatabaseConnect() {
		Properties properties = new Properties();
		try {
			properties.load(DatabaseConnect.class.getResourceAsStream("/dbconfig.properties"));
			final String driver = properties.getProperty("driver");
			final String server = properties.getProperty("server");
			final String user = properties.getProperty("user");
			final String pass = properties.getProperty("dung.pass");
			Class.forName(driver);
			connection = DriverManager.getConnection(server, user, pass);
		} catch (IOException | ClassNotFoundException | SQLException e) {
			DbLogging.LOG.error("Error login connection");;
		} 
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public static DatabaseConnect getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnect();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnect();
        }
        return instance;
    }
	
}