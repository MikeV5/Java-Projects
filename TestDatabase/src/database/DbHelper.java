package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHelper {

	// Uniform resource locator
	private final static String protocol = "jdbc:postgresql" + "://";
	private final static String host = "localhost/";
	private final static String resource = "ProjectEmotionalSongs";
	private final static String url = protocol + host + resource;
	
	private final static String username = "postgres";
	private final static String password = "tommyrin3";
	
	private static Connection connection = null;
	private static Statement statement = null;
	
	public DbHelper() {
		
	}
	
	public static Connection getConnection() throws SQLException {

		if (connection == null) {
			connection = DriverManager.getConnection(url, username, password);
		}
		
		return connection;
	}
	
	public static void closeConnection() throws SQLException {
		
		connection.close();
		connection = null;
	}
	
	public static Statement getStatement() throws SQLException {
		
		if (statement == null) {
			
			Connection connection = getConnection();
			statement = connection.createStatement();
		}
		
		return statement;
	}
	
	public static void closeStatement() throws SQLException {
		
		statement.close();
		statement = null;
	}
}
