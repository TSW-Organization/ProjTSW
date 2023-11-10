package it.unisa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverManagerConnectionPool  {

	private DriverManagerConnectionPool() {}
	
	private static List<Connection> freeDbConnections;
	private final static Logger logger = Logger.getLogger(DriverManagerConnectionPool.class.getName());
			
	static {
		freeDbConnections = new LinkedList<Connection>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.log(Level.WARNING, "DB driver not found:"+ e.getMessage());
			
		} 
	}
	
	private static synchronized Connection createDBConnection() throws SQLException {
		Connection newConnection = null;
		String ip = "localhost";
		String port = "3306";
		String db = "worldcrafters";
		String username = "root";
		String password = "1234";

		newConnection = DriverManager.getConnection("jdbc:mysql://"+ ip+":"+ port+"/"+db+"?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", username, password);
		newConnection.setAutoCommit(false);
		return newConnection;
	}


	public static synchronized Connection getConnection() throws SQLException {
		Connection connection;

		if (!freeDbConnections.isEmpty()) {
			connection = freeDbConnections.get(0);
			freeDbConnections.remove(0);

			try {
				if (connection.isClosed())
					connection = getConnection();
			} catch (SQLException e) {
				connection.close();
				connection = getConnection();
			}
		} else {
			connection = createDBConnection();		
		}

		return connection;
	}

	public static synchronized void releaseConnection(Connection connection) throws SQLException {
		if(connection != null) freeDbConnections.add(connection);
	}
}
