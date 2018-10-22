/**
 * 
 */
package com.fa.group01.connect;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			DbLogging.LOG.error(this.getClass() + " - Error login connection", e);

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

	public void close(Connection connection) throws SQLException {
		if (connection != null)
			connection.close();
	}

	public void close(CallableStatement callableStatement) throws SQLException {
		if (callableStatement != null)
			callableStatement.close();
	}

	public void close(Statement statement) throws SQLException {
		if (statement != null)
			statement.close();
	}

	public void close(ResultSet resultSet) throws SQLException {
		if (resultSet != null)
			resultSet.close();
	}

	public void close(PreparedStatement prepareStatement) throws SQLException {
		if (prepareStatement != null)
			prepareStatement.close();
	}

}